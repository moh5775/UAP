package store;

public class Item {
	public String name, id, category;
	public double price;
	public int quantity;

	public Item(String name, String id, String category, double price, int quantity) {
		this.category = category;
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public double getSalePrice(double saleAmount) {
		return price - (price * saleAmount) / 100;
	}

	public String toString() {
		return "Name: " + name + "\tID :" + id + "\tCategory: " + category + "\tPrice: " + price + "\tQuantity: "
				+ quantity;
	}
}
