package com.jocata.customermanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer_personal_details")
public class CustomerDetails {
	
	//@SequenceGenerator(sequenceName = "cust_account_number", allocationSize = 1, name = "ACT_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACT_SEQ")
	@Column(name = "customer_cif_code")
	private Integer cifNumber;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(sequenceName = "cust_id", allocationSize = 1, name =
	// "CUST_SEQ2")
	@Column(name = "customer_id")
	private Integer customerId;

	
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String emailId;
	@Column(name = "martial_status")
	private String maritalStatus;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "aadhar")
	private String aadharNumber;
	@Column(name = "pan")
	private String panNumber;
	@Column(name = "mobile_number")
	private String customerMobileNumber;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	

	public Integer getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(Integer cifNumber) {
		this.cifNumber = cifNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
}