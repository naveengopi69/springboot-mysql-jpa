package com.rs.fer.updateuser;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

@Column
	private String firstName;
@Column
	private String middleName;
@Column
	private String lastName;
@Column
	private String email;
@Column
	private String username;
@Column
	private String password;
@Column
	private String mobile;

public User() {

}

public User(int userId, String firstName,String middleName,String lastName,String email,String username,String password,String mobile) {
	this.userId = userId;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.username = username;
	this.password = password;
	this.mobile = mobile;
}
	
	

	@OneToMany(cascade = CascadeType.ALL,targetEntity = Expense.class,fetch = FetchType.EAGER)
	@JoinColumn(name="uId",referencedColumnName ="userId")
	
	private Set<Expense> expenses;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}


	@OneToOne(cascade = CascadeType.ALL,targetEntity = Address.class)
	@JoinColumn(name="addrId",referencedColumnName ="addressId")
	private Address address;

	public int getId() {
		return userId; 
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Address getAddress() {
		return address;
	}
	

	public void setAddress(Address address) {
		this.address=address;
		
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ",email=\" + email + \", username=\" + username + \", password=\" + password + \", mobile=\" + mobile + \",]";
	}
}


