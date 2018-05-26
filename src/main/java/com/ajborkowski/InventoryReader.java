package com.ajborkowski;

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
		String filePath = "vendingmachine.csv";
		File inventoryFile = new File(filePath);

		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] data = line.split("\\|");
				Queue<Item> queue = new LinkedList<>();
				for (int i = 0; i < 5; i++) {
					//TODO: Refactor this and CSV to give each item a category and sort/assign accordingly (maybe)
					if (data[0].startsWith("A")) {
						queue.add(new ItemChip(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("B")) {
						queue.add(new ItemCandy(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("C")) {
						queue.add(new ItemCola(data[1], new BigDecimal(data[2])));
					} else if (data[0].startsWith("D")) {
						queue.add(new ItemGum(data[1], new BigDecimal(data[2])));
					} else {
						// [throw exception]
					}
				}
				inventory.put(data[0], queue);
			}
		} catch (FileNotFoundException e) {
			//TODO: Perhaps let ONLY CLI use SysOut
			System.out.println();
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Check InventoryReader.java");
		}
		return inventory;
	}
}