package com.seclore.pojo;

public class Book {
private String book_code;
private String title;
private String author;
private String issue_book;
private int quantity;

public Book ()
{
	
}


public Book(String book_code, String title, String author, String issue_book, int quantity) {
	super();
	this.book_code = book_code;
	this.title = title;
	this.author = author;
	this.issue_book = issue_book;
	this.quantity = quantity;
}


public String getBook_code() {
	return book_code;
}
public void setBook_code(String book_code) {
	this.book_code = book_code;
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
public String getIssue_book() {
	return issue_book;
}
public void setIssue_book(String issue_book) {
	this.issue_book = issue_book;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Book [book_code=" + book_code + ", title=" + title + ", author=" + author + ", issue_book=" + issue_book
			+ ", quantity=" + quantity + "]";
}
}
