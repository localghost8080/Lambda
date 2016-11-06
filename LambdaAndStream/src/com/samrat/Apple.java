package com.samrat;

public class Apple implements Fruit {

	private Integer weight;
	private Color color;
	private Juice juice;
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Juice getJuice() {
		return juice;
	}
	public void setJuice(Juice juice) {
		this.juice = juice;
	}
	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}
	
}
