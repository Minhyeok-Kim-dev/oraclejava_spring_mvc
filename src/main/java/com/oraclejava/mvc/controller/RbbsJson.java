package com.oraclejava.mvc.controller;

import java.util.List;

import com.oraclejava.mvc.model.Rbbs;

public class RbbsJson {
	private List<Rbbs> logs;
	private String msg;
	private int id;
	
	public List<Rbbs> getLogs() {
		return logs;
	}
	public void setLogs(List<Rbbs> logs) {
		this.logs = logs;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RbbsJson [logs=" + logs + ", msg=" + msg + ", id=" + id + "]";
	}
}
