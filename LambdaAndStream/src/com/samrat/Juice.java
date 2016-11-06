package com.samrat;

public class Juice {

	String color;
	Integer qty;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Juice [color=" + color + ", qty=" + qty + "]";
	}
}
