package com.rs.fer.updateuser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int expenseId;
	
	@Column
	private String type;
	@Column
	private String date;
	@Column
	private String price;
	@Column
	private String numberOfItems;
	@Column
	private String total;
	@Column
	private String byWhom;
	
	public Expense(String type, String date,String price,String numberOfItems,String total,String byWhom) {
		this.type = type;
		this.date = date;
		this.price = price;
		this.numberOfItems = numberOfItems;
		this.total = total;
		this.byWhom = byWhom;
	}
	
	public int getId() {
		return expenseId;
	}
	public void setId(int id) {
		this.expenseId = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(String numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getByWhom() {
		return byWhom;
	}
	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	@Override
	public String toString() {
		return "Expense [type=" + type + ", date=" + date + ", price=" + price + ", numberOfItems=" + numberOfItems + ",total=\" + total + \", byWhom=\" + byWhom + \",]";
	}
	
}
