package com.techelevator;

import java.math.BigDecimal;

public class AChip extends Item {

	public AChip(String name, BigDecimal price) {
		setName(name);
		setPrice(price);
		setConsume("Crunch Crunch, Yum!");
	}
}
