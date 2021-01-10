package com.bezkoder.spring.datajpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adressId;
	@Column
	private String lineOne;
	@Column
	private String linetwo;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String poastalCode;
	@Column
	private String country;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "uId", referencedColumnName = "userId")

	private User user;

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLinetwo() {
		return linetwo;
	}

	public void setLinetwo(String linetwo) {
		this.linetwo = linetwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPoastalCode() {
		return poastalCode;
	}

	public void setPoastalCode(String poastalCode) {
		this.poastalCode = poastalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
