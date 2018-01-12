package com.oraclejava.mvc.model;

import java.util.Date;

public class Rbbs {
	private int bbsno;
	private String name;
	private String body;
	private Date regdate;
	
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Rbbs [bbsno=" + bbsno + ", name=" + name + ", body=" + body + ", regdate=" + regdate + "]";
	}
}
