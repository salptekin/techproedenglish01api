package techproedenglish01.techproedenglish01api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoPractice {
	
	@SerializedName("employee_name")
	@Expose
	private String employeeName;
	@SerializedName("employee_salary")
	@Expose
	private String employeeSalary;
	@SerializedName("employee_age")
	@Expose
	private String employeeAge;
	@SerializedName("profile_image")
	@Expose
	private String profileImage;
	
	public String getEmployeeName() {
	return employeeName;
	}
	public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
	}
	public String getEmployeeSalary() {
	return employeeSalary;
	}
	public void setEmployeeSalary(String employeeSalary) {
	this.employeeSalary = employeeSalary;
	}
	public String getEmployeeAge() {
	return employeeAge;
	}
	public void setEmployeeAge(String employeeAge) {
	this.employeeAge = employeeAge;
	}
	public String getProfileImage() {
	return profileImage;
	}
	public void setProfileImage(String profileImage) {
	this.profileImage = profileImage;
	}

}