package med.lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicine extends Item{
	private double dose;
	private String unit;
	private LocalDate expirationDate;
	
	public Medicine(String name, String manufacturer, double dose, String unit,  double unitPrice, int quantity, LocalDate expirationDate) {
		super(name,manufacturer,unitPrice,quantity);
		this.dose=dose;
		this.expirationDate=expirationDate;
		this.unit=unit;
		super.addPrefixCodeToId("M");
	}
	
	public Medicine(String name, String manufacturer, double dose, String unit,  double unitPrice, int quantity, String expirationDate) {
		 this(name, manufacturer, dose, unit, unitPrice, quantity, LocalDate.parse(expirationDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	
	public double getDose() {
		return dose;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	 public boolean hasExpired() {
		 return LocalDate.now().compareTo(getExpirationDate())>0;
	 }
	 @Override
	 public String toString() {
		 DateTimeFormatter format =DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		 String expDate = expirationDate.format(format);
		 return super.toString()+"\t"+dose+"\t"+unit+"\t"+expDate;
	 }
}
