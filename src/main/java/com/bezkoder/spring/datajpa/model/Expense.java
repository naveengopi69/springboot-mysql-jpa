package com.bezkoder.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expense")
public class Expense {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int expenseId;
	@Column
	private String expensetype;
	@Column
	private String date;
	@Column
	private float price;
	@Column
	private int noOfItems;
	@Column
	private float total;
	@Column
	private String bywhom;
	
	public Expense(int expenseId,String expensetype,String date,float price,int noOfItems,float total,String bywhom){ 
		this.expenseId=expenseId;
		this.expensetype=expensetype;
		this.date=date;
		this.price=price;
		this.noOfItems=noOfItems;
		this.total=total;
		this.bywhom=bywhom;
		
		
		
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}

	public String getexpenseType() {
		return expensetype;
	}

	public void setexpenseType(String type) {
		this.expensetype = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

	@Override
	public String toString() {
		
		return "Expense [expenseId=" + expenseId + ", expensetype=" + expensetype + ", date=" + date + ", price=" + price + ",noOfItems=\" + noOfItems + \", total=\" + total + \", bywhom=\" + bywhom + \",]";
	}
	
	
	

}
