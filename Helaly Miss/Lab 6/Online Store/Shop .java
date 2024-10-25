package store;

import java.util.ArrayList;

public class Shop {
	String name;
	ArrayList<Item> items;

	public Shop(String name) {
		this.name = name;
		this.items = new ArrayList<>();
	}

	public Item findItem(String id) {
		for (Item p : items) {
			if (p.id.equals(id)) {
				return p;
			}
		}
		return null;
	}

	public void addItem(String name, String id, String category, double price, int count) {
		Item item = findItem(id);
		if (findItem(id) != null) {
			item.quantity += count;
		} else {
			item = new Item(name, id, category, price, count);
			items.add(item);
		}
	}

	public void viewItem(String id) {
		Item item = findItem(id);
		if (findItem(id) != null) {
			System.out.println(item.toString());
		}
	}

	public void viewItems() {
		for (Item p : items) {
			System.out.println(p.toString());
		}
	}

	public void sellAnItem(String id, int quantity) {
		Item item = findItem(id);
		if (findItem(id) != null) {
			item.quantity -= quantity;
		} else {
			System.out.println("Item not found");
		}
	}

	public double getSalePriceOfAnItem(String id, double saleAmount) {
		Item item = findItem(id);
		if (findItem(id) != null) {
			return item.getSalePrice(saleAmount);
		} else {
			System.out.println("Item not found");
			return -1.0;
		}

	}
}
