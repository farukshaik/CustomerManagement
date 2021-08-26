package com.jocata.customermanagement.model;

public class CustomerAddressPojo {

	private Integer customerId;
	private Integer custId;
	private String customerCountry;
	private String customerState;
	private Integer customerPinCode;
	private String permanentAddress;
	private String currentAddress;

	

	

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
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

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
