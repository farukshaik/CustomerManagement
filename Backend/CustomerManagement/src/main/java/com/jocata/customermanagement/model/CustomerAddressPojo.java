package com.jocata.customermanagement.model;

public class CustomerAddressPojo {
	
	private String customerCountry;
	private String customerState;
	private Integer customerPinCode;
	private String permanentAddress;
	private String currentAddress;
	
	
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
	
	

}
