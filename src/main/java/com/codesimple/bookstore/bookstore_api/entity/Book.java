package com.codesimple.bookstore.bookstore_api.entity;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.joda.time.DateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.ToString;
//import jakarta.persistence.Table;

@Entity
@Table(name="book") // if it different table name in the data base
public class Book {
	@Id  // to mark primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Hibernate will check   // here GenerationType.AUTO might caused some error sometimes
	/*
	 * AUTO lets Hibernate decide the best generation strategy based on the dialect.
	 * In MySQL, this can sometimes cause issues (sequence tables not supported properly
	 */
	private Long id;
	private String name;
	private String des;
	private int yearOfPublication;
	private String bookType;
	@Column(updatable = false)
	@JdbcTypeCode(SqlTypes.TIMESTAMP)
	private LocalDateTime createdAt;
	@JdbcTypeCode(SqlTypes.TIMESTAMP)
    private LocalDateTime updatedAt;
	
	/*
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "book_author", // join table name
		joinColumns = @JoinColumn(name = "book_id"), // FK to book
		inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();
	*/
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "book_author",
			joinColumns = @JoinColumn(
					name = "book_id",
					foreignKey = @ForeignKey(
							name = "fk_book_author__book_id",
							foreignKeyDefinition = "FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE")
					),
			inverseJoinColumns = @JoinColumn(
					name = "author_id",
					foreignKey = @ForeignKey(
							name = "fk_book_author__author_id",
							foreignKeyDefinition = "FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE ON UPDATE CASCADE")),
			uniqueConstraints = @UniqueConstraint(columnNames = {"book_id", "author_id"})) // to make combination of both foreign keys as primary key
		private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}
	
	
	
	public Book(Long id, String name, String des, int yearOfPublication, String bookType, LocalDateTime createdAt,
			LocalDateTime updatedAt, Set<Author> authors) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.yearOfPublication = yearOfPublication;
		this.bookType = bookType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.authors = authors;
	}



	// Automatically set timestamps
	@PrePersist
	protected void onCreate() {
	    if (this.createdAt == null) {   // only set if null
	        this.createdAt = LocalDateTime.now();
	    }
	    this.updatedAt = this.createdAt;
	}

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
