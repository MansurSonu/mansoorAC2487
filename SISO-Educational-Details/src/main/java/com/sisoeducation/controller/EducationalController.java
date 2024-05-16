package com.sisoeducation.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sisoeducation.pojo.AddEmploymentEntity;
import com.sisoeducation.pojo.ApplyJobs;
import com.sisoeducation.pojo.CertificationsDetails;
import com.sisoeducation.pojo.CollegeDetails;
import com.sisoeducation.pojo.EmployeeEntity;
import com.sisoeducation.pojo.JobsSave;
import com.sisoeducation.pojo.LoginEmail;
import com.sisoeducation.pojo.LoginStatus;
import com.sisoeducation.pojo.ResetPassword;
import com.sisoeducation.pojo.SchoolDetails;
import com.sisoeducation.pojo.UniverisityDetails;
import com.sisoeducation.repository.Employee_Repository;
import com.sisoeducation.service.EducationalService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/siso")
public class EducationalController {

	@Autowired
	private EducationalService service;

	@Autowired
	private Employee_Repository repo;

	@Autowired
	private JavaMailSender javaMailSender;

//	    @PostMapping("/employee/register")
//	    public ResponseEntity<EmployeeEntity> registerEmployee(@RequestBody EmployeeEntity employee) {
//	        EmployeeEntity registeredEmployee = service.registerEmployee(employee);
//	        if (registeredEmployee != null) 
//	            return new ResponseEntity<>(registeredEmployee, HttpStatus.CREATED);
//	         else 
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);     
//	    }

	@PostMapping("/getotp/{email}/{userName}")
	public String saveOTP(@PathVariable String email, @PathVariable String userName) {
		Optional<EmployeeEntity> empEnt = repo.findByEmail(email);
		if (empEnt.isPresent()) {
			return "User Already Exists";
		}

		else {
			EmployeeEntity e = new EmployeeEntity();
			e.setUserName(userName);
			e.setEmail(email);
			String OTP = generateRandomOTP();
			e.setEmailOtp(OTP);
			sendEmail(email, OTP);

			repo.save(e);

			return "email ok";
		}
	}

	private String generateRandomOTP() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	private void sendEmail(String email, String emailOtp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for verification is: " + emailOtp);
		javaMailSender.send(message);
	}

	@PostMapping("/createuser")
	public ResponseEntity<String> createEmployee(

			@RequestParam("resume") MultipartFile resume, @RequestParam("phone") String phone,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("jobRole") String jobRole, @RequestParam("workStatus") String workStatus,
			@RequestParam("registerAs") String registerAs,
			@RequestParam(name = "years", required = false) Integer years,
			@RequestParam(name = "months", required = false) Integer months) throws IOException {

		// Optional<EmployeeEntity> e = repo.findByEmail(email);
		Optional<EmployeeEntity> e = repo.findByEmail(email);

		if (e.isPresent()) {

			EmployeeEntity employee = e.get();

			employee.setWorkStatus(workStatus);

			employee.setWorkStatus(workStatus);
			employee.setPhone(phone);
			employee.setPassword(password);
			employee.setJobRole(jobRole);
			employee.setRegisterAs(registerAs);

			employee.setYears(workStatus.equalsIgnoreCase("fresher") ? null : years);
			employee.setMonths(workStatus.equalsIgnoreCase("fresher") ? null : months);
			employee.setResume(resume.getBytes());

			repo.save(employee);

			return ResponseEntity.ok(" user Registered");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");

	}

	@PostMapping("/verify/{email}/{enteredOTP}")
	@Transactional
	public boolean verifyOTP(@PathVariable String email, @PathVariable String enteredOTP) {
		Optional<EmployeeEntity> empEntOptional = repo.findByEmail(email);
		if (empEntOptional.isPresent()) {
			EmployeeEntity empEnt = empEntOptional.get();
			String storedOTP = empEnt.getEmailOtp();
			if (storedOTP != null && storedOTP.equals(enteredOTP)) {
				empEnt.setEmailOtp(null);
				repo.save(empEnt);
				return true;
			}
		}
		return false;
	}

	@PostMapping("/login")
	public String loginUser(@RequestBody LoginEmail request) {
		Optional<EmployeeEntity> e = repo.findByEmail(request.getEmail());
		EmployeeEntity emp1 = e.get();
		if (e.isPresent() && emp1.getPassword().equals(request.getPassword())) {
			return "login successfull";

		}

		return "check your credentials";

	}

	@PostMapping("/passwordreset/{email}")
	public ResponseEntity<String> otpForPasswordReset(@PathVariable String email) {

		try {
			Optional<EmployeeEntity> empEnt = repo.findByEmail(email);
			if (empEnt.isPresent()) {
				EmployeeEntity emp = empEnt.get();
				// empEnt.setPassword(newPassword);

				// empEnt.setNewPassword(null);

				String OTP = randomOTPForPassword();
				emp.setEmailOtp(OTP);

				sendEmail(email, OTP);

				repo.save(emp);

				return ResponseEntity.ok("otp sent to the registered email");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no email found");

	}

	private String randomOTPForPassword() {
		Random random = new Random();
		return String.format("%06d", random.nextInt(10000));
	}

	private void sendEmailForPasswordReset(String email, String emailOtp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for passwordReset is: " + emailOtp);
		javaMailSender.send(message);
	}

	@PostMapping("/verifyotpfornewpassword/{email}/{enteredOTP}/{newPassword}/{confirmNewPassword}")
	public ResponseEntity<String> verifyOTPForNewPassword(@PathVariable String email, @PathVariable String enteredOTP,
			@PathVariable String newPassword) {

		try {
			Optional<EmployeeEntity> empEnt = repo.findByEmail(email);
			EmployeeEntity emp = empEnt.get();
			if (empEnt != null && emp.getEmailOtp() != null && emp.getEmailOtp().equals(enteredOTP)) {

				emp.setPassword(newPassword);
				emp.setNewPassword(null);
				emp.setEmailOtp(null);
				repo.save(emp);
				return ResponseEntity.ok("password Reset succesfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");

	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable String empId) {
		try {
			EmployeeEntity employee = service.findByEmployeeId(empId);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/employee/{empId}")
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(@PathVariable String empId,
			@RequestBody EmployeeEntity employee) {
		try {
			EmployeeEntity updatedEmployee = service.updateEmployeeDetails(empId, employee);
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable String empId) {
		String message = service.deleteEmployeeById(empId);
		if (message.equals("Successfully Employee Data Deleted")) {
			return new ResponseEntity<>(message, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * @PostMapping("/login") public String loginUser(@RequestBody EmployeeEntity
	 * empEnt) { Optional<EmployeeEntity> e =
	 * repo.findByEmployeeIdAndPassword(empEnt.getEmployeeId(),
	 * empEnt.getPassword()); if (e != null) { return "login successfull"; }
	 * 
	 * return "check your credentials";
	 * 
	 * }
	 */

//	@PostMapping("/employee/login")
//	public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
//		String empId = loginRequest.get("employeeId");
//		String password = loginRequest.get("password");
//
//		if (empId != null && password != null) {
//			Optional<EmployeeEntity> emp = service.getByUserIdAndPassword(empId, password);
//			if (emp.isPresent())
//				return ResponseEntity.ok("Login Successful");
//			else {
//				if (repo.existsById(empId))
//					return ResponseEntity.ok("Login Failed Due to Incorrect Employee-Id.");
//				else
//					return ResponseEntity.ok("Login Failed Due to Incorrect Password.");
//			}
//		}
//		return ResponseEntity.ok("Employee-Id and Password are Not Empty.");
//	}

	@PostMapping("/employee/reset")
	public LoginStatus resetPassword(@RequestBody ResetPassword resetPassword) {
		LoginStatus msg = service.ResetPasswordInitation(resetPassword);
		return msg;
	}

	@PutMapping("/employee/newpassword")
	public LoginStatus newpassword(@RequestBody ResetPassword resetPassword) {
		LoginStatus msg = service.NewpasswordGeneration(resetPassword);
		return msg;
	}

	@GetMapping("/getallemployees")
	public List<EmployeeEntity> getAllemployees() {

		return service.getAllemployees();
	}

	@PostMapping("/school/add/{employeeId}")
	public ResponseEntity<EmployeeEntity> addSchool(@PathVariable String employeeId,
			@RequestBody SchoolDetails school) {
		EmployeeEntity updatedEmployee = service.addSchool(employeeId, school);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/school/{id}")
	public ResponseEntity<SchoolDetails> findSchoolById(@PathVariable Integer id) {
		SchoolDetails school = service.findSchoolById(id);
		return ResponseEntity.ok(school);
	}

	@PutMapping("/school/{id}")
	public ResponseEntity<String> updateSchoolDetails(@PathVariable Integer id, @RequestBody SchoolDetails school) {
		String message = service.updateSchoolDetails(id, school);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/school/all")
	public ResponseEntity<List<SchoolDetails>> getAllSchools() {
		List<SchoolDetails> schools = service.getAllSchools();
		return ResponseEntity.ok(schools);
	}

	@DeleteMapping("/school/{id}")
	public ResponseEntity<String> deleteSchoolById(@PathVariable Integer id) {
		String message = service.deleteSchoolById(id);
		return ResponseEntity.ok(message);
	}

	@PostMapping("/college/add/{employeeId}")
	public ResponseEntity<EmployeeEntity> addCollege(@PathVariable String employeeId,
			@RequestBody CollegeDetails college) {
		EmployeeEntity updatedEmployee = service.addCollege(employeeId, college);
		return ResponseEntity.ok(updatedEmployee);
	}

	@PutMapping("/college/{clgId}")
	public ResponseEntity<String> updateCollegeDetails(@PathVariable Integer id, @RequestBody CollegeDetails college) {
		String message = service.updateCollegeDetails(id, college);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/college/all")
	public ResponseEntity<List<CollegeDetails>> getAllColleges() {
		List<CollegeDetails> colleges = service.getAllCollege();
		return ResponseEntity.ok(colleges);
	}

	@DeleteMapping("/college/{clgId}")
	public ResponseEntity<String> deleteCollegeById(@PathVariable Integer id) {
		String message = service.deleteCollegeById(id);
		return ResponseEntity.ok(message);
	}

	@GetMapping("/college/{clgId}")
	public ResponseEntity<CollegeDetails> findCollegeById(@PathVariable Integer id) {
		CollegeDetails college = service.findCollegeById(id);
		return ResponseEntity.ok(college);
	}

	@PostMapping("/university/add/{employeeId}")
	public EmployeeEntity addUniversity(@PathVariable String employeeId, @RequestBody UniverisityDetails uni) {
		return service.addUniversity(employeeId, uni);
	}

	@PutMapping("/university/{uniId}")
	public String updateUniversityDetails(@PathVariable Integer uniId, @RequestBody UniverisityDetails uni) {
		return service.updateUniversityDetails(uniId, uni);
	}

	@GetMapping("/universities")
	public List<UniverisityDetails> getAllUniversities() {
		return service.getAllUniversitys();
	}

	@DeleteMapping("/university/{uniId}")
	public String deleteUniversityById(@PathVariable Integer uniId) {
		return service.deleteUniversityById(uniId);
	}

	@GetMapping("/university/{uniId}")
	public UniverisityDetails findUniversityById(@PathVariable Integer uniId) {
		return service.findUniversityById(uniId);
	}

	@PostMapping("/certificates/add/{employeeId}")
	public EmployeeEntity addCertificates(@PathVariable String employeeId, @RequestBody CertificationsDetails certi) {
		return service.addCertificates(employeeId, certi);
	}

	@PutMapping("/certificates/{certId}")
	public String updateCertificatesDetails(@PathVariable Integer certId, @RequestBody CertificationsDetails certi) {
		return service.updateCertificatesDetails(certId, certi);
	}

	@GetMapping("/certificates")
	public List<CertificationsDetails> getAllCertificates() {
		return service.getAllCertificates();
	}

	@DeleteMapping("/certificates/{certId}")
	public String deleteCertificatesById(@PathVariable Integer certId) {
		return service.deleteCertificatesById(certId);
	}

	@GetMapping("/certificates/{certId}")
	public CertificationsDetails findCertificatesById(@PathVariable Integer certId) {
		return service.findCertificatesById(certId);
	}

	// add employment controller//

	@PostMapping(value = "/addemployement/{employeeId}")
	public AddEmploymentEntity createEmployment(@PathVariable String employeeId,
			@RequestBody AddEmploymentEntity employement) {
		return service.createEmployment(employeeId, employement);
	}

	@PostMapping("/save/{employeeId}")
	public JobsSave saveTheJobs(@PathVariable String employeeId, @RequestBody JobsSave js) {
		return service.saveTheJobs(employeeId, js);

	}

	@GetMapping("/savedJobs/{employeeId}")
	public List<JobsSave> getJobsSaveByEmployeeId(@PathVariable String employeeId) {
		return service.getJobsSaveByEmployeeId(employeeId);

	}

	@PostMapping("/applyjob/{employeeId}")
	public ResponseEntity<String> saveTheAppliedJobs(@PathVariable String employeeId, @RequestBody ApplyJobs aJ) {
		service.saveTheAppliedJobs(employeeId, aJ);
		return ResponseEntity.ok("applied");
	}

	@GetMapping("/appliedJobs/{employeeId}")
	public List<ApplyJobs> getAppliedJobsByEmployeeId(@PathVariable String employeeId) {
		return service.getAllAppliedJobsByEmployeeId(employeeId);

	}

	
}