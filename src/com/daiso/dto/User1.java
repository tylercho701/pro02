package com.daiso.dto;

public class User1 {
	private	String id;
	private	String pw;
	private	String hpw;
	private	String uname;
	private	String utel;
	private	String uaddr;
	private	String uemail;
	private	String regdate;
	private int point;
	private int visited;
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getPw() {
		return pw;
	}
	public final void setPw(String pw) {
		this.pw = pw;
	}
	public String getHpw() {
		return hpw;
	}
	public void setHpw(String hpw) {
		this.hpw = hpw;
	}
	public final String getUname() {
		return uname;
	}
	public final void setUname(String uname) {
		this.uname = uname;
	}
	public final String getUtel() {
		return utel;
	}
	public final void setUtel(String utel) {
		this.utel = utel;
	}
	public final String getUaddr() {
		return uaddr;
	}
	public final void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public final String getUemail() {
		return uemail;
	}
	public final void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public final String getRegdate() {
		return regdate;
	}
	public final void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public final int getPoint() {
		return point;
	}
	public final void setPoint(int point) {
		this.point = point;
	}
	public final int getVisited() {
		return visited;
	}
	public final void setVisited(int visited) {
		this.visited = visited;
	}
}