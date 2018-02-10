package com.techelevator;

import java.math.BigDecimal;

public class BCandy extends Item {

	public BCandy(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Munch Munch, Yum!");
	}
}
