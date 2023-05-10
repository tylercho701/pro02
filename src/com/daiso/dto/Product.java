package com.daiso.dto;

public class Product {
	private	String	pcode;
	private	String	pname;
	private	String	pmeas;
	private	int	price;
	private	String	pcom;
	private	int	amount;
	private	String	pic1;
	private	String	pic2;
	private	String	pic3;
	private String category;
	
	public final String getCategory() {
		return category;
	}
	public final void setCategory(String category) {
		this.category = category;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPmeas() {
		return pmeas;
	}
	public void setPmeas(String pmeas) {
		this.pmeas = pmeas;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcom() {
		return pcom;
	}
	public void setPcom(String pcom) {
		this.pcom = pcom;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

}