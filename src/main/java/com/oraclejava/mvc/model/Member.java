package com.oraclejava.mvc.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String passwd;
	private String email;
	private String usertype;
	private String active;
	private Date regdate;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", passwd=" + passwd + ", email=" + email + ", usertype=" + usertype
				+ ", active=" + active + ", regdate=" + regdate + "]";
	}
}
