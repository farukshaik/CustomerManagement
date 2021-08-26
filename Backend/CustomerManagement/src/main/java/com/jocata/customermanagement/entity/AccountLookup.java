package com.jocata.customermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="tbl_look_up")
public class AccountLookup {
	
	@Id
	@Column(name="lookup_id")
	private int lookupId;
	
	@Column(name="lookup_type")
	private String lookupType;
	
	@Column(name="lookup_code")
	private String lookupCode;
	
	@Column(name="lookup_value")
	private String lookupValue;

	public int getLookupId() {
		return lookupId;
	}

	public void setLookupId(int lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}
	
	

}
