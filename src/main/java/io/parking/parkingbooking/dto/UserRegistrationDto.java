package io.parking.parkingbooking.dto;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegistrationDto {	
	
	@Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    private String username;
	@NotBlank(message = "Please enter your full name")
    private String fullName;
    @NotBlank(message = "Password field is required")
    private String password;
    private String confirmPassword;
    private String roles;
    private String registration_courses;
    private String giving_courses;

    
	public String getRegistration_courses() {
		return registration_courses;
	}
	public void setRegistration_courses(String registration_courses) {
		this.registration_courses = registration_courses;
	}
	public String getGiving_courses() {
		return giving_courses;
	}
	public void setGiving_courses(String giving_courses) {
		this.giving_courses = giving_courses;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public  String getRoles() {
		return roles;
	}
	public void setRoles( String roles) {
		this.roles = roles;
	}


}