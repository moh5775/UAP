package med.lib;

import java.util.Random;

public abstract class Item {
	
	private String name , id, manufacturer ;
	private double unitPrice ;
	private int quantity;
	
	public Item(String name ,String manufacturer,double unitPrice,int quantity) {
		this.manufacturer=manufacturer;
		this.name=name;
		this.quantity=quantity;
		this.unitPrice=unitPrice;
		Random r = new Random();
		int num=r.nextInt(10000);
		this.id=String.format("%04d",num);
	}
	 protected void addPrefixCodeToId(String prefix) {
		 this.id = prefix+"-"+id;
	 }
	 public String getId(){
		 return id;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 
	 public String getManufacturer(){
		 return manufacturer;
	 }
	 
	 public double getUnitPrice(){
		 return unitPrice;
	 }
	 
	 public int getQuantity(){
		 return quantity;
	 }
	 
	 
	 
	 
	 public void setName(String name){
		 this.name=name;
	 }
	 
	 public void setManufacturer(String manufacturer){
		 this.manufacturer=manufacturer;
	 }
	 
	 public void setUnitPrice(double unitPrice){
		 this.unitPrice=unitPrice;
	 }
	 
	 public void setQuantity(int quantity){
		 this.quantity=quantity;
	 }
	 
	 public void increaseQuantity(int increasedAmt) {
		 quantity+=increasedAmt;
	 }
	 
	 public boolean decreaseQuantity(int decreasedAmt) throws InvalidOrderException{
		 if(decreasedAmt<=quantity) {
			 quantity-=decreasedAmt;
			 return true;
		 }
		 else {
			return false;
		 }
	 }
	 @Override
	 public String toString() {
		 return name+"\t"+id+"\t"+manufacturer+"\t"+unitPrice+"\t"+quantity;
	 }
	 
	 public double getBill() {
		 return getUnitPrice()*getQuantity();
	 }

}
