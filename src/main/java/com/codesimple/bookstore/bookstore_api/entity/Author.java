package com.codesimple.bookstore.bookstore_api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.joda.time.DateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(nullable = true)
	private String gender;
	@JdbcTypeCode(SqlTypes.TIMESTAMP)
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@JdbcTypeCode(SqlTypes.TIMESTAMP)
	private LocalDateTime updatedAt;
	
	/* this can create a join table automatically with requirements
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
//	@ManyToMany(mappedBy = "authors", cascade = CascadeType.PERSIST)
	@ManyToMany(mappedBy = "authors")
	private Set <Book> books = new HashSet<Book>();
	
	*/
	
	public Author() {
		
	}

	public Author(Long id, String name, String gender, LocalDateTime createdAt, LocalDateTime updatedAt,
			Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
//		this.books = books;
	}
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
