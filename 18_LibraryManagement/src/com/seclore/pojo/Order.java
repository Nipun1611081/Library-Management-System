package com.seclore.pojo;

public class Order {
	//private static int counter=101;
	private int order_id=0;
	private Member member;
	private Book book;
	private java.sql.Date issue_date;
	private java.sql.Date due_date;
	private String status;
	
	public Order() {
		
	}
	public Order(Member member, Book book, java.sql.Date issue_date, java.sql.Date due_date, String status) {
		super();
		//counter++;
		//this.order_id=counter;
		this.member = member;
		this.book = book;
		this.issue_date = issue_date;
		this.due_date = due_date;
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public java.sql.Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(java.sql.Date issue_date) {
		this.issue_date = issue_date;
	}
	public java.sql.Date getDue_date() {
		return due_date;
	}
	public void setDue_date(java.sql.Date due_date) {
		this.due_date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", member=" + member + ", book=" + book + ", issue_date=" + issue_date
				+ ", due_date=" + due_date + ", status=" + status + "]";
	}
}
