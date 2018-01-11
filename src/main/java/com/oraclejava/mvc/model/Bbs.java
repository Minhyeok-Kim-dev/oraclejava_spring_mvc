package com.oraclejava.mvc.model;

import java.util.Date;

public class Bbs {
	int bbsno;
	String title;
	String uploader;
	String content;
	int readcount;
	Date regdate;
	
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Bbs [bbsno=" + bbsno + ", title=" + title + ", uploader=" + uploader + ", content=" + content
				+ ", readcount=" + readcount + ", regdate=" + regdate + "]";
	}
}
