package com.seclore.pojo;

public class Member {
	private String member_code;
	private String name;
	private String member_type;
	private int issue_capacity;
	
	public Member() {
		
	}
	public Member(String member_code, String name, String member_type) {
		super();
		this.member_code = member_code;
		this.name = name;
		this.member_type = member_type;
		if (member_type.equalsIgnoreCase("T"))
		{
			System.out.println("Hello1");
			issue_capacity=25;
		}
		else
		{
			System.out.println("Hello2");
			issue_capacity=3;
		}
	}
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public int getIssue_capacity() {
		return issue_capacity;
	}
	public void setIssue_capacity(int issue_capacity) {
		this.issue_capacity = issue_capacity;
	}
	@Override
	public String toString() {
		return "Member [member_code=" + member_code + ", name=" + name + ", member_type=" + member_type
				+ ", issue_capacity=" + issue_capacity + "]";
	}
}
