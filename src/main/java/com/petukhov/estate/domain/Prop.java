package com.petukhov.estate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "prop")
public class Prop {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "address", nullable = false, length = 128)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String address;

	@Column(name = "description", nullable = false, length = 256)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String description;

	@Column(name = "fee", nullable = false, length = 64)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String fee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
}
