package com.sisoeducation.service;

import java.util.List;
import java.util.Optional;

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

public interface EducationalService {

	public EmployeeEntity findByEmployeeId(String empId);

	public EmployeeEntity updateEmployeeDetails(String empId, EmployeeEntity employee);

	public Optional<EmployeeEntity> getByUserIdAndPassword(String empId, String password);

	public String deleteEmployeeById(String empId);

	public LoginStatus ResetPasswordInitation(ResetPassword resetPassword);

	public LoginStatus NewpasswordGeneration(ResetPassword resetPassword);

	public List<EmployeeEntity> getAllemployees();

	// ***** School Service ***** \\

	public EmployeeEntity addSchool(String employeeId, SchoolDetails school);

	public String updateSchoolDetails(Integer id, SchoolDetails school);

	public SchoolDetails findSchoolById(Integer id);

	public List<SchoolDetails> getAllSchools();

	public String deleteSchoolById(Integer id);

	// ***** Collage / Diplamo Service ***** \\

	public EmployeeEntity addCollege(String employeeId, CollegeDetails clg);

	public String updateCollegeDetails(Integer id, CollegeDetails clg);

	public List<CollegeDetails> getAllCollege();

	public String deleteCollegeById(Integer id);

	public CollegeDetails findCollegeById(Integer id);

	// ***** Collage / Diplamo Service ***** \\

	public EmployeeEntity addUniversity(String employeeId, UniverisityDetails uni);

	public String updateUniversityDetails(Integer id, UniverisityDetails uni);

	public List<UniverisityDetails> getAllUniversitys();

	public String deleteUniversityById(Integer id);

	public UniverisityDetails findUniversityById(Integer id);

	// ***** University Service ***** \\

	public EmployeeEntity addCertificates(String employeeId, CertificationsDetails certi);

	public String updateCertificatesDetails(Integer id, CertificationsDetails certi);

	public List<CertificationsDetails> getAllCertificates();

	public String deleteCertificatesById(Integer id);

	public CertificationsDetails findCertificatesById(Integer id);

	// addemploymenmtservice//
	public AddEmploymentEntity createEmployment(String employeeId, AddEmploymentEntity employment);

	// jobsSave service//
	public JobsSave saveTheJobs(String employeeId, JobsSave js);

	public List<JobsSave> getJobsSaveByEmployeeId(String employeeId);

	// applyjobsservice//
	public ApplyJobs saveTheAppliedJobs(String employeeId, ApplyJobs As);

	public List<ApplyJobs> getAllAppliedJobsByEmployeeId(String EmployeeId);


	
}
