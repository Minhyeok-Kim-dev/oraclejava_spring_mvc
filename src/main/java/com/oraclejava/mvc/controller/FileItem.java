package com.oraclejava.mvc.controller;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

// 현재 전송되는 파일 개수 제한없으므로 직렬화하는게 효율적
public class FileItem implements Serializable{

	private static final long serialVersionUID = -4150942787243023946L;
	
	private String savedfilename;
	private String userfilename;
	private MultipartFile file;
	private int bbsfileno;
	private int downloadcount;
	
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getBbsfileno() {
		return bbsfileno;
	}
	public void setBbsfileno(int bbsfileno) {
		this.bbsfileno = bbsfileno;
	}
	public int getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}
	
	@Override
	public String toString() {
		return "FileItem [savedfilename=" + savedfilename + ", userfilename=" + userfilename + ", file=" + file
				+ ", bbsfileno=" + bbsfileno + ", downloadcount=" + downloadcount + "]";
	}
}
