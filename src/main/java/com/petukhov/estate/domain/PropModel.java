package com.petukhov.estate.domain;

public class PropModel {
	private String propAddress;
	private String propDescription;
	private String propFee;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPropAddress() {
		return propAddress;
	}
	public void setPropAddress(String propAddress) {
		this.propAddress = propAddress;
	}
	public String getPropDescription() {
		return propDescription;
	}
	public void setPropDescription(String propDescription) {
		this.propDescription = propDescription;
	}
	public String getPropFee() {
		return propFee;
	}
	public void setPropFee(String propFee) {
		this.propFee = propFee;
	}

}
