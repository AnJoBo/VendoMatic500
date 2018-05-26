package com.ajborkowski;

import java.math.BigDecimal;

public class ItemChip extends Item {

	public ItemChip(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Crunch Crunch, Yum!");
	}
}
