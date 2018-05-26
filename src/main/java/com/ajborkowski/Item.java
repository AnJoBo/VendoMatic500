package com.ajborkowski;

import java.math.BigDecimal;

public abstract class Item {

	private String name;
	private BigDecimal price;
	private String consume;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setConsume(String consume) {
		this.consume = consume;
	}
	public String getConsume() {
		return consume;
	}
}
