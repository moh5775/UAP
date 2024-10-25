package med.lib;

import java.util.ArrayList;

public class Pharma {
	public String name;
	public ArrayList<Item> items;
	public Pharma(String name) {
		this.name=name;
		this.items=new ArrayList<>();
	}
	public Item findItem(String id) {
		for(Item p:items) {
			if(p.id.equals(id)) {
				return p;
			}
		}
		return null;
	}
	public void stockIn(String name, String id, String manufacturer ,float dose, double
			unitPrice, int quantity) {
		Item item = findItem(id);
		if(item!=null) {
			item.increaseQuantity(quantity);
		}
		else {
			Item i = new Item(name,id,manufacturer,dose,unitPrice, quantity) ;
			items.add(i);
			
		}
	}
	public boolean sell (String id, int quantity) {
		Item item = findItem(id);
		if(item!=null) {
			boolean b = item.decreaseQuantity(quantity);
			return b;
		}
		else {
			System.out.println("Not found");
			return false;
		}
	}
	public boolean updatePrice(String id, double newPrice) {
		Item item = findItem(id);
		if(findItem(id)!=null) {
			item.updatePrice(newPrice);
			return true;
			
		}
		else {
			return false;
		}
	}
}
