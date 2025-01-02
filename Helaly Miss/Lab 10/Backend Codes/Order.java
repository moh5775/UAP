package med.lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Order {
	private String orderId , itemId , orderBy , status ;
	private int	quantity ;
	private LocalDate orderDate,deliveryDate;
	public Order(String itemId,String orderBy,int  quantity) {
		
		this.itemId=itemId;
		this.orderBy=orderBy;
		this.quantity=quantity;
		this.orderDate=LocalDate.now();
		this.status="New";
		Random r = new Random();
		int num=r.nextInt(10000);
		this.orderId = "O-" + String.format("%04d", num);
	}
	
	public String getOrderId() {
		return orderId; 
	}

	public String getItemId() {
		return itemId; 
	}
	
	public String getOrderBy() {
		return orderBy; 
	}

	public String getStatus() {
		return status; 
	}

	public int getQuantity() {
		return quantity; 
	}

	public LocalDate getorderDate() {
		return orderDate; 
	}

	public LocalDate getdeliveryDate() {
		return deliveryDate; 
	}
	
	public void setStatus(String status) {
		this.status = status; 
	}
	
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatted_OrderDate=orderDate.format(formatter);
		String formatted_DeliveryDate="";
		if( deliveryDate!=null)
		 formatted_DeliveryDate= deliveryDate.format(formatter);
		return orderId +"\t"+ itemId +"\t"+ orderBy +"\t"+ status +"\t"+quantity+"\t"+formatted_OrderDate+"\t"+formatted_DeliveryDate;
		
	}
	
	public void complateOrder() {
		this.status="complete";
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		this.deliveryDate=LocalDate.parse(currentDate.format(formatter), formatter);
		System.out.println(deliveryDate);
	}
}
