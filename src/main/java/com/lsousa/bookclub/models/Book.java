package com.lsousa.bookclub.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, message="Please enter a valid book title")
	private String title;

	@NotNull
	@Size(min=1, message="Please enter a valid author")
	private String author;

	@NotNull
	@Size(min=1, max=1000, message="Thoughts must be between 1 and 1000 characters")
	@Column(length=1000)
	private String thoughts;
	
	// ========== Data Creation Trackers ========

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// ========== Relationships =================

	// One-to-Many

	// Many
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

	// ========== Constructors ==================

	// Empty constructor
	public Book () {}

	// ========== Data Creation Event ===========

	@PrePersist
	protected void onCreate() {
	    this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdated() {
	    this.updatedAt = new Date();
	}

	// ========== Getters and Setters ===========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
