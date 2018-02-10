package com.techelevator;

import java.math.BigDecimal;

public class CCola  extends Item {

	public CCola(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Glug Glug, Yum!");
	}
}
