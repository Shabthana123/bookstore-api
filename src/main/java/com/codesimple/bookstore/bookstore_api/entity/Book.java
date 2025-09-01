package com.codesimple.bookstore.bookstore_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
//@Table(name="book") // if it different table name in the data base
public class Book {
	@Id  // to mark primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Hibernate will check   // here GenerationType.AUTO might caused some error sometimes
	/*
	 * AUTO lets Hibernate decide the best generation strategy based on the dialect.
	 * In MySQL, this can sometimes cause issues (sequence tables not supported properly
	 */
	private int id;
	private String name;
	private String des;
	private int yearOfPublication;
	private String bookType;
	
	public Book() {
		
	}
	
	public Book(int id, String name, String des, int yearOfPublication, String bookType) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.yearOfPublication = yearOfPublication;
		this.bookType = bookType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	
	
}
