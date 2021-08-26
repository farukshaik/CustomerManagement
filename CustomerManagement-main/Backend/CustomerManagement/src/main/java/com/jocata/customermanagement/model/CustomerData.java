package com.jocata.customermanagement.model;

import java.sql.Date;

public class CustomerData {

	// customer details
	private Integer customerId;
	private Integer cifNumber;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String emailId;
	private String maritalStatus;
	private String fatherName;
	private String motherName;
	private String aadharNumber;
	private String PanNumber;
	private String customerMobileNumber;

	// customer address
	private String customerCountry;
	private String customerState;
	private Integer customerPinCode;
	private String permanentAddress;
	private String currentAddress;

	// customer occupation
	private Integer employeeId;
	private String employmentNature;
	private String companyName;
	private String designation;
	private Integer experience;
	private String address;
	private String state;
	private String country;
	private Integer pinCode;

	// customer nominee
	private String nomineeName;
	private String relationship;
	private String mobileNumber;

	// account details
	private String productType;
	private String accountStatus;
	private String branch;
	private String riskLevel;
	private Integer accountBalance;
	private Integer accountTurnOver;
	private Integer cashTurnOver;
	private String purposeOfAccount;
	private Long accountNumber;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Integer getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Integer getAccountTurnOver() {
		return accountTurnOver;
	}

	public void setAccountTurnOver(Integer accountTurnOver) {
		this.accountTurnOver = accountTurnOver;
	}

	public Integer getCashTurnOver() {
		return cashTurnOver;
	}

	public void setCashTurnOver(Integer cashTurnOver) {
		this.cashTurnOver = cashTurnOver;
	}

	public String getPurposeOfAccount() {
		return purposeOfAccount;
	}

	public void setPurposeOfAccount(String purposeOfAccount) {
		this.purposeOfAccount = purposeOfAccount;
	}

	

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public Integer getPinCode() {
		return pinCode;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMartialStatus() {
		return maritalStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.maritalStatus = martialStatus;
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
	
	
	
	
	

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return PanNumber;
	}

	public void setPanNumber(String panNumber) {
		PanNumber = panNumber;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public Integer getCustomerPinCode() {
		return customerPinCode;
	}

	public void setCustomerPinCode(Integer customerPinCode) {
		this.customerPinCode = customerPinCode;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmploymentNature() {
		return employmentNature;
	}

	public void setEmploymentNature(String employmentNature) {
		this.employmentNature = employmentNature;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
