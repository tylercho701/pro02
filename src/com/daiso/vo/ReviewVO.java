package com.daiso.vo;

public class ReviewVO {
	private String rnum;
	private String id;
	private String onum;
	private String writtendate;
	private String rcom;
	private String pcode;
	private String pname;
	private int rpoint;
	private String odate;
	private String dstatus;
	
	public final int getRpoint() {
		return rpoint;
	}
	public final void setRpoint(int rpoint) {
		this.rpoint = rpoint;
	}
	public final String getRnum() {
		return rnum;
	}
	public final void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getOnum() {
		return onum;
	}
	public final void setOnum(String onum) {
		this.onum = onum;
	}
	public final String getWrittendate() {
		return writtendate;
	}
	public final void setWrittendate(String writtendate) {
		this.writtendate = writtendate;
	}
	public final String getRcom() {
		return rcom;
	}
	public final void setRcom(String rcom) {
		this.rcom = rcom;
	}
	public final String getPcode() {
		return pcode;
	}
	public final void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public final String getPname() {
		return pname;
	}
	public final void setPname(String pname) {
		this.pname = pname;
	}
	public final String getOdate() {
		return odate;
	}
	public final void setOdate(String odate) {
		this.odate = odate;
	}
	public final String getDstatus() {
		return dstatus;
	}
	public final void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}
}
