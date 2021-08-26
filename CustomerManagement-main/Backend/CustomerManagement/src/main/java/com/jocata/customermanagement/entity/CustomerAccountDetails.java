package com.jocata.customermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="tbl_account_details")
public class CustomerAccountDetails {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="cust_id")
	private int custId;
	
	
	
	

	@Column(name="account_number")
	private long accountNumber;
	
	@Column(name="account_status")
	private int accountStatus;
	
	@Column(name="product_type")
	private int productType;
	
	@Column(name="account_balance")
	private int accountBalance;
	
	@Column(name="branch")
	private int branch;
	
	@Column(name="risk_level")
	private int riskLevel;
	
	@Column(name="purpose_of_account")
	private String purposeOfAccount;
	
	@Column(name="account_turn_over")
	private int accountTurnOver;
	
	@Column(name="cash_turn_over")
	private int cashTurnOver;

	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPurposeOfAccount() {
		return purposeOfAccount;
	}

	public void setPurposeOfAccount(String purposeOfAccount) {
		this.purposeOfAccount = purposeOfAccount;
	}

	public int getAccountTurnOver() {
		return accountTurnOver;
	}

	public void setAccountTurnOver(int accountTurnOver) {
		this.accountTurnOver = accountTurnOver;
	}

	public int getCashTurnOver() {
		return cashTurnOver;
	}

	public void setCashTurnOver(int cashTurnOver) {
		this.cashTurnOver = cashTurnOver;
	}
	
	

}
