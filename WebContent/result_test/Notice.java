package com.daiso.dto;

public class Notice {
	private int idx;
	private String title;
	private String content;
	private String author;
	private String file1;
	private String resdate;
	private int readcnt;
	
	public final int getIdx() {
		return idx;
	}
	public final void setIdx(int idx) {
		this.idx = idx;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getAuthor() {
		return author;
	}
	public final void setAuthor(String author) {
		this.author = author;
	}
	public final String getFile1() {
		return file1;
	}
	public final void setFile1(String file1) {
		this.file1 = file1;
	}
	public final String getResdate() {
		return resdate;
	}
	public final void setResdate(String resdate) {
		this.resdate = resdate;
	}
	public final int getReadcnt() {
		return readcnt;
	}
	public final void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
}