package com.petukhov.estate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HIRE")
public class Hire {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "FEE")
    private Integer fee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

    
}
