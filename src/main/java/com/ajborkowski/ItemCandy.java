package com.ajborkowski;

import java.math.BigDecimal;

public class ItemCandy extends Item {

	public ItemCandy(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Munch Munch, Yum!");
	}
}
