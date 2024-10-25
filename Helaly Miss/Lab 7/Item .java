package med.lib;

public class Item {
	public String name,id, manufacturer ;
	public float dose;
	public double unitPrice;
	public int quantity;
	public Item(String name,String id,String manufacturer, float dose,double unitPrice,int quantity) {
		this.dose=dose;
		this.id=id;
		this.manufacturer=manufacturer;
		this.name=name;
		this.quantity=quantity;
		this.unitPrice=unitPrice;
	}
	public void increaseQuantity(int incQuantity) {
		quantity+=incQuantity;
	}
	public boolean decreaseQuantity(int decQuantity) {
		if(decQuantity<=quantity) {
			quantity-=decQuantity;
			return true;
		}
		else {
			return false;
		}
	}
	public void updatePrice (double newPrice) {
		unitPrice=newPrice;
	}
	public String toString() {
		return name+"\t"+id+"\t"+manufacturer+"\t"+dose+"\t"+unitPrice+"\t"+quantity;
	}
}
