package com.oraclejava.mvc.model;

public class BbsFile {
	int bbsfileno;
	String savedfilename;
	String userfilename;
	int downloadcount;
	int bbsno;
	
	public int getBbsfileno() {
		return bbsfileno;
	}
	public void setBbsfileno(int bbsfileno) {
		this.bbsfileno = bbsfileno;
	}
	public String getSavedfilename() {
		return savedfilename;
	}
	public void setSavedfilename(String savedfilename) {
		this.savedfilename = savedfilename;
	}
	public String getUserfilename() {
		return userfilename;
	}
	public void setUserfilename(String userfilename) {
		this.userfilename = userfilename;
	}
	public int getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	
	@Override
	public String toString() {
		return "BbsFile [bbsfileno=" + bbsfileno + ", savedfilename=" + savedfilename + ", userfilename=" + userfilename
				+ ", downloadcount=" + downloadcount + ", bbsno=" + bbsno + "]";
	}
	
	
}
