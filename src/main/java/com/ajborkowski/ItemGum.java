package com.ajborkowski;

import java.math.BigDecimal;

public class ItemGum extends Item {

	public ItemGum(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Chew Chew, Yum!");
	}
}
