package com.jocata.customermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer_personal_details")
public class FetchCustomerDetailsEntity {

	@Column(name = "first_name")
	private String firstName;

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_cif_code")
	private int cifNumber;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private String date_of_birth;

	@Column(name = "aadhar")
	private String aadharNumber;

	@Column(name = "pan")
	private String panNumber;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	

	public int getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(int cifNumber) {
		this.cifNumber = cifNumber;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
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

	public String getAccountCreatedDate() {
		return accountCreationDate;
	}

	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreationDate = accountCreatedDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Column(name = "email")
	private String emailId;

	@Column(name = "martial_status")
	private String martialStatus;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "account_created_date")
	private String accountCreationDate;

	@Column(name = "account_status")
	private String accountStatus;

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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(String accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

}