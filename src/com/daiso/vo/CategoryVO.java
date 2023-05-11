package com.daiso.vo;

public class CategoryVO {
	private String ct;		//카테고리 대분류 코드 - 카테고리코드(cate)의 앞 두 자리
	private String categroup; //카테고리 그룹명
	private String cate; //카테고리 중분류 코드 - 4자리
	private String catename; //중분류 카테고리명
	private String pcode;	//상품코드
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getCategroup() {
		return categroup;
	}
	public void setCategroup(String categroup) {
		this.categroup = categroup;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
}