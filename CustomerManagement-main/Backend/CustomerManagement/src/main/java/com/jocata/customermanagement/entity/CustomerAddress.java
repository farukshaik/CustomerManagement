package com.jocata.customermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer_address")
public class CustomerAddress {

	@Id
	// @SequenceGenerator(sequenceName = "cust_id", allocationSize = 1, name =
	// "CUST_SEQ1")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name="cust_id")
	private Integer custId;

	@Column(name = "country")
	private String customerCountry;
	@Column(name = "state_")
	private String customerState;
	@Column(name = "pin_code")
	private Integer customerPinCode;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "current_address")
	private String currentAddress;

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	
	

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

}
