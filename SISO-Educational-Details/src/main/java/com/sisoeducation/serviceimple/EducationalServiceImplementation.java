package com.sisoeducation.serviceimple;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sisoeducation.pojo.AddEmploymentEntity;
import com.sisoeducation.pojo.ApplyJobs;
import com.sisoeducation.pojo.CertificationsDetails;
import com.sisoeducation.pojo.CollegeDetails;
import com.sisoeducation.pojo.EmployeeEntity;
import com.sisoeducation.pojo.JobsSave;
import com.sisoeducation.pojo.LoginStatus;
import com.sisoeducation.pojo.ResetPassword;
import com.sisoeducation.pojo.SchoolDetails;
import com.sisoeducation.pojo.UniverisityDetails;
import com.sisoeducation.repository.AddEmploymentRepo;
import com.sisoeducation.repository.ApplyJobsRepo;
import com.sisoeducation.repository.Certification_Repository;
import com.sisoeducation.repository.College_Repository;
import com.sisoeducation.repository.Employee_Repository;
import com.sisoeducation.repository.JobsSaveRepo;
import com.sisoeducation.repository.School_Repository;
import com.sisoeducation.repository.University_Repository;
import com.sisoeducation.service.EducationalService;

@Service
public class EducationalServiceImplementation implements EducationalService {

	@Autowired
	private JobsSaveRepo jsRepo;

	@Autowired
	private ApplyJobsRepo applyJobsRepo;
	
	@Autowired
	private Employee_Repository empRepository;

	@Autowired
	private JavaMailSender mailService;

	@Autowired
	private AddEmploymentRepo addEmploymentRepo;

	@Override
	public EmployeeEntity findByEmployeeId(String empId) {
		Optional<EmployeeEntity> emp = empRepository.findByEmail(empId);
		if (emp.isPresent()) {
			EmployeeEntity employee = emp.get();
			return employee;
		} else
			throw new RuntimeException("Employee Data Not Found.");
	}

	@Override
	public EmployeeEntity updateEmployeeDetails(String empId, EmployeeEntity employee) {
		Optional<EmployeeEntity> existEmp = empRepository.findById(empId);
		if (existEmp.isPresent()) {

			EmployeeEntity emp = existEmp.get();
			emp.setEmployeeId(empId);
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setAlternateMobile(employee.getAlternateMobile());
			emp.setGender(employee.getGender());
			emp.setDob(employee.getDob());
			emp.setResumeDescription(employee.getResumeDescription());
			emp.setCountry(employee.getCountry());
			emp.setCity(employee.getCity());
			emp.setPincode(employee.getPincode());
			emp.setState(employee.getState());
			emp.setDoorNumber(employee.getDoorNumber());
			emp.setStreetName(employee.getStreetName());
			empRepository.save(emp);
		}
		throw new RuntimeException("Employee Data Not Found With " + empId);
	}

	@Override
	public Optional<EmployeeEntity> getByUserIdAndPassword(String empId, String password) {
		Optional<EmployeeEntity> present = empRepository.findByEmployeeIdAndPassword(empId, password);
		return present;

	}

	@Override
	public String deleteEmployeeById(String empId) {
		Optional<EmployeeEntity> existEmp = empRepository.findById(empId);
		if (existEmp.isPresent()) {
			empRepository.deleteById(empId);
			return "Sucessfully Employee Data Deleted";
		}
		return "Failed to Delete the Employee Data.";
	}

	private Map<String, LocalDateTime> otpMap = new HashMap<>();
	private String otp;
	private String id;

	@Override
	public LoginStatus ResetPasswordInitation(ResetPassword resetPassword) {

		Optional<EmployeeEntity> employee = empRepository.findByEmail(resetPassword.getEmail());

		if (employee.isPresent()) {
			EmployeeEntity emp = employee.get();
			String mail = emp.getEmail();
			String m = resetPassword.getEmail();

			if (mail.equals(m)) {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("muppuri47@gmail.com");
				message.setTo(mail);
				message.setSubject("Reset Password Initiation for Source In Source Out Website");
				Random random = new Random();

				otp = Integer.toString(random.nextInt(999999));

				String body = "Greetings from Source In Source Out Website!\n\n"
						+ "You have requested to reset your password. Please enter the following OTP: \n" + otp + "\n\n"
						+ "Please note that this OTP is for one-time use only. Do not share it with anyone.\n\n"
						+ "This OTP Expired In 4 Min. Please Make Sure With In Time.\n\n"
						+ "If you did not initiate this password reset, please contact our support team.\n"
						+ "\nBest regards,\n" + "Source In Source Out Website Team";

				message.setText(body);
				mailService.send(message);
				id = emp.getEmployeeId();

				LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(4);
				otpMap.put(otp, expirationTime);

				return new LoginStatus("OTP Send to E-Mail check it Once", true);
			} else
				return new LoginStatus("E-Mail Entered Not Matched With Data-Base E-mail Plz Try Again ", false);
		} else
			return new LoginStatus("E-Mail is Not Exist Plz Try Again ", false);
	}

	@Override
	public LoginStatus NewpasswordGeneration(ResetPassword resetPassword) {

		if (otpMap.containsKey(resetPassword.getOtp())) {

			LocalDateTime expirationTime = otpMap.get(resetPassword.getOtp());

			if (LocalDateTime.now().isBefore(expirationTime)) {

				if (resetPassword.getOtp().equals(otp)) {
					Optional<EmployeeEntity> pojo = empRepository.findByEmail(resetPassword.getEmail());

					if (pojo != null) {
						Optional<EmployeeEntity> model = empRepository.findByEmployeeId(id);
						EmployeeEntity models = model.get();
						String mail2 = models.getEmail();

						models.setPassword(resetPassword.getPassword());

						empRepository.save(models);

						SimpleMailMessage message = new SimpleMailMessage();
						message.setTo(mail2);

						message.setSubject("New Password Generated for Source In Source Out Website! ");

						String body = "Dear " + models.getFirstName() + " " + models.getLastName() + ",\n\n"
								+ "Welcome to Source In Source Out Website! Your password has been successfully reset.\n\n"
								+ "Your new password Has Been Updated In Source In Source Out Website. \n\n"
								+ "Please log in using your new password. Ensure that you keep it confidential and do not share it with anyone.\n\n"
								+ "If you did not initiate this password reset, please contact our support team immediately.\n\n"
								+ "\nBest regards,\n" + "Source In Source Out Website Team";

						message.setText(body);
						mailService.send(message);

						otpMap.remove(resetPassword.getOtp());
						return new LoginStatus("Password Reset Successfully Completed", true);
					} else
						return new LoginStatus("Employee not found. Please try again.", false);
				} else
					return new LoginStatus("OTP is incorrect.", false);
			} else
				return new LoginStatus("OTP has expired. Please request a new OTP.", false);
		} else
			return new LoginStatus("Invalid OTP.", false);
	}

	// ***** School Service Implememtation ***** \\

	@Autowired
	private School_Repository schoolRepo;

	@Override
	public EmployeeEntity addSchool(String employeeId, SchoolDetails school) {
		Optional<EmployeeEntity> exist = empRepository.findByEmployeeId(employeeId);
		if (exist.isPresent()) {
			EmployeeEntity employee = exist.get();
			schoolRepo.save(school);
			return employee;
		}
		throw new RuntimeException("Employee Id Not Found " + employeeId);
	}

	@Override
	public SchoolDetails findSchoolById(Integer id) {
		Optional<SchoolDetails> existSchool = schoolRepo.findById(id);
		if (existSchool.isPresent())
			return existSchool.get();
		throw new RuntimeException("School with Id Not Found " + id);
	}

	@Override
	public String updateSchoolDetails(Integer id, SchoolDetails school) {
		Optional<SchoolDetails> existorNot = schoolRepo.findById(id);
		if (existorNot.isPresent()) {
			SchoolDetails details = existorNot.get();
			details.setId(id);
			details.setLocation(school.getLocation());
			details.setNameofInstitution(school.getNameofInstitution());
			details.setPercentage(school.getPercentage());
			details.setStudy(school.getStudy());
			details.setTotalMarks(school.getTotalMarks());
			details.setYearofPasing(school.getYearofPasing());

			schoolRepo.save(details);
		}
		throw new RuntimeException("School Vth Id " + id + " Not Present.");
	}

	@Override
	public List<SchoolDetails> getAllSchools() {
		List<SchoolDetails> list = schoolRepo.findAll();
		if (list.isEmpty())
			throw new RuntimeException("School Data is Empty / Unable to Process at this Movement");
		return list;
	}

	@Override
	public String deleteSchoolById(Integer id) {
		Optional<SchoolDetails> existorNot = schoolRepo.findById(id);
		if (existorNot.isPresent()) {
			schoolRepo.deleteById(id);
			return "Successfully Deleted Data Vth " + existorNot.get().getNameofInstitution();
		}
		return id + " is Not-Matched With Database";
	}

	// ***** College Service Implememtation ***** \\

	@Autowired
	private College_Repository clgRepo;

	@Override
	public EmployeeEntity addCollege(String employeeId, CollegeDetails clg) {
		Optional<EmployeeEntity> exist = empRepository.findByEmployeeId(employeeId);
		if (exist.isPresent()) {
			EmployeeEntity employee = exist.get();
			clgRepo.save(clg);
			return employee;
		}
		throw new RuntimeException("Employee Id Not Found " + employeeId);
	}

	@Override
	public String updateCollegeDetails(Integer id, CollegeDetails clg) {

		Optional<CollegeDetails> existorNot = clgRepo.findByClgId(id);
		if (existorNot.isPresent()) {
			CollegeDetails updatedClg = existorNot.get();
			updatedClg.setclgId(id);
			updatedClg.setLocation(clg.getLocation());
			updatedClg.setNameofInstitution(clg.getNameofInstitution());
			updatedClg.setPercentage(clg.getPercentage());
			updatedClg.setStudy(clg.getStudy());
			updatedClg.setTotalMarks(clg.getTotalMarks());
			updatedClg.setYearofPasing(clg.getYearofPasing());

			clgRepo.save(updatedClg);
		}
		throw new RuntimeException("College with Id " + id + " Not Present.");
	}

	@Override
	public List<CollegeDetails> getAllCollege() {

		List<CollegeDetails> listclg = clgRepo.findAll();
		if (listclg.isEmpty())
			throw new RuntimeException("College Data is Empty / Unable to Process at this Movement");
		return listclg;
	}

	@Override
	public String deleteCollegeById(Integer id) {
		Optional<CollegeDetails> existorNot = clgRepo.findById(id);
		if (existorNot.isPresent()) {
			clgRepo.deleteById(id);
			return "Successfully Deleted Data Vth " + existorNot.get().getNameofInstitution();
		}
		return id + " is Not-Matched With Database";
	}

	@Override
	public CollegeDetails findCollegeById(Integer id) {
		Optional<CollegeDetails> exist = clgRepo.findById(id);
		if (exist.isPresent())
			return exist.get();
		throw new RuntimeException("College with Id Not Found " + id);
	}

	// ***** University Service Implementation ***** \\

	@Autowired
	private University_Repository uniRepo;

	@Override
	public EmployeeEntity addUniversity(String employeeId, UniverisityDetails uni) {
		Optional<EmployeeEntity> empExist = empRepository.findByEmployeeId(employeeId);

		if (empExist.isPresent()) {
			EmployeeEntity emp = empExist.get();
			uni.setEmployee(emp);
			uniRepo.save(uni);
			return emp;
		} else {
			throw new RuntimeException("Employee Id Not Found: " + employeeId);
		}
	}

	@Override
	public String updateUniversityDetails(Integer id, UniverisityDetails uni) {

		Optional<UniverisityDetails> exist = uniRepo.findById(id);
		if (exist.isPresent()) {
			UniverisityDetails updated = exist.get();
			updated.setuniId(id);
			updated.setLocation(uni.getLocation());
			updated.setNameofInstitution(uni.getNameofInstitution());
			updated.setPercentage(uni.getPercentage());
			updated.setStudy(uni.getStudy());
			updated.setTotalMarks(uni.getTotalMarks());
			updated.setYearofPasing(uni.getYearofPasing());
			uniRepo.save(updated);
		}
		throw new RuntimeException("University with Id " + id + " Not Present.");
	}

	@Override
	public List<UniverisityDetails> getAllUniversitys() {
		List<UniverisityDetails> list = uniRepo.findAll();
		if (list.isEmpty())
			throw new RuntimeException("University Data is Empty / Unable to Process at this Movement");
		return list;
	}

	@Override
	public String deleteUniversityById(Integer id) {
		Optional<UniverisityDetails> existorNot = uniRepo.findById(id);
		if (existorNot.isPresent()) {
			existorNot.get().setEmployee(null);
			clgRepo.deleteById(id);
			return "Successfully Deleted Data Vth " + existorNot.get().getNameofInstitution();
		}
		return id + " is Not-Matched With Database";
	}

	@Override
	public UniverisityDetails findUniversityById(Integer id) {

		Optional<UniverisityDetails> existorNot = uniRepo.findById(id);
		if (existorNot.isPresent())
			return existorNot.get();
		throw new RuntimeException("University Data is Not Found / Unable to Process at this Movement");
	}

	// ***** Certification Service Implementation ***** \\

	@Autowired
	private Certification_Repository certiRepo;

	@Override
	public EmployeeEntity addCertificates(String employeeId, CertificationsDetails certi) {

		Optional<EmployeeEntity> empExist = empRepository.findByEmployeeId(employeeId);

		if (empExist.isPresent()) {

			EmployeeEntity emp = empExist.get();
			certi.setEmployee(emp);
			certiRepo.save(certi);
			return emp;
		}
		throw new RuntimeException("Employee Id Not Found: " + employeeId);
	}

	@Override
	public String updateCertificatesDetails(Integer id, CertificationsDetails certi) {
		Optional<CertificationsDetails> exist = certiRepo.findById(id);
		if (exist.isPresent()) {
			CertificationsDetails updated = exist.get();
			updated.setCertId(id);
			updated.setNameofCourse(certi.getNameofCourse());
			updated.setBoard(certi.getBoard());
			updated.setDurationTime(certi.getDurationTime());
			updated.setPass(certi.getPass());
			updated.setYear(certi.getYear());
			certiRepo.save(updated);
		}
		throw new RuntimeException("Certificate with Id " + id + " Not Present.");
	}

	@Override
	public List<CertificationsDetails> getAllCertificates() {
		List<CertificationsDetails> list = certiRepo.findAll();
		if (list.isEmpty())
			throw new RuntimeException("Certification Data is Empty / Unable to Process at this Movement");
		return list;
	}

	@Override
	public String deleteCertificatesById(Integer id) {
		Optional<CertificationsDetails> existorNot = certiRepo.findByCertId(id);
		if (existorNot.isPresent()) {
			CertificationsDetails certi = existorNot.get();
			certi.setEmployee(null);
			certiRepo.deleteById(id);
			return "Successfully Deleted Data with " + certi.getNameofCourse();
		}
		return id + " is Not-Matched With Database";
	}

	@Override
	public CertificationsDetails findCertificatesById(Integer id) {
		Optional<CertificationsDetails> existorNot = certiRepo.findByCertId(id);
		if (existorNot.isPresent()) {
			CertificationsDetails certi = existorNot.get();
			return certi;
		}
		throw new RuntimeException("Certificates Data is Not Found / Unable to Process at this Movement");
	}

	@Override
	public List<EmployeeEntity> getAllemployees() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public AddEmploymentEntity createEmployment(String employeeId, AddEmploymentEntity employment) {
		Optional<EmployeeEntity> empEntity = empRepository.findByEmployeeId(employeeId);
		if (empEntity.isPresent()) {
			EmployeeEntity empent = empEntity.get();
			employment.setEmployee(empent);
			addEmploymentRepo.save(employment);
			return employment;
		}
		return null;
	}

	@Override
	public JobsSave saveTheJobs(String employeeId, JobsSave js) {
		Optional<EmployeeEntity> empEntity = empRepository.findByEmployeeId(employeeId);
		if (empEntity.isPresent()) {
			EmployeeEntity employeeJobs = empEntity.get();
			js.setEmployee(employeeJobs);
			jsRepo.save(js);

			return js;

		}
		return null;

	}

	@Override
	public List<JobsSave> getJobsSaveByEmployeeId(String employeeId) {

		return jsRepo.findByEmployeeId(employeeId);

	}

	@Override
	public ApplyJobs saveTheAppliedJobs(String employeeId, ApplyJobs aJ) {
		Optional<EmployeeEntity> employee = empRepository.findByEmployeeId(employeeId);
		if (employee.isPresent()) {
			EmployeeEntity emp = employee.get();
			aJ.setEmployee(emp);
			applyJobsRepo.save(aJ);
			return aJ;
		}
		return null;
	}

	@Override
	public List<ApplyJobs> getAllAppliedJobsByEmployeeId(String EmployeeId) {
		
		return applyJobsRepo.findByEmployeeId(EmployeeId);
	}
}
