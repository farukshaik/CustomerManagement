package com.jocata.customermanagement.model;

public class AccountDetails {
	
	private int custId;

	private int accountStatus;
	private int productType;
	private int accountBalance;
	private int branch;
	private int riskLevel;
	private String purposeOfAccount;
	private int accountTurnOver;
	private int cashTurnOver;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getPurposeOfAccount() {
		return purposeOfAccount;
	}
	public void setPurposeOfAccount(String purposeOfAccount) {
		this.purposeOfAccount = purposeOfAccount;
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
