package com.ajborkowski;

import java.math.BigDecimal;

public class ItemCola extends Item {

	public ItemCola(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Glug Glug, Yum!");
	}
}
