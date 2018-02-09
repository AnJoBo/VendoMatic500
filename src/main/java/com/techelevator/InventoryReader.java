package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryReader {

	public Map<String, Queue<Item>> generateInventory() {

		Map<String, Queue<Item>> inventory = new TreeMap<>();
		String filePath = "/Users/bethanywarner/workspace/capstone/java-module1-capstone-team5/vendingmachine.csv";
		File inventoryFile = new File(filePath);

		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split("\\|");
				Queue<Item> queue = new LinkedList<>();
				for (int i = 0; i < 5; i++) {
					if (data[0].startsWith("A")) {
						queue.add(new AChip(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("B")) {
						queue.add(new BCandy(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("C")) {
						queue.add(new CCola(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("D")) {
						queue.add(new DGum(data[1], new BigDecimal(data[2])));
					} else {
						// [throw exception]
					}
				}
				inventory.put(data[0], queue);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}

}