package med.app;

import java.util.Scanner;

import med.lib.Item;
import med.lib.Pharma;

public class PharmaApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name:");
		String name=input.nextLine();
		Pharma pharma = new Pharma(name);
		while(true) {
			System.out.println("1: display all the items\n2: display the information of a specific item.\n3: stock-in new item.\n4: sell an item.\n5: update the price to an item\n0: exit\n");
			System.out.print("Enter your choice: ");
			int option = input.nextInt();
			input.nextLine();
			switch(option) {
			case 1:
				for(int i=0;i<pharma.items.size();i++) {
					System.out.print(pharma.items.get(i));
				}
				break;
			case 2:
				System.out.print("Enter Id: ");
				String id = input.nextLine();
				Item item = pharma.findItem(id);
				System.out.print(item);
				break;
			case 3:
				System.out.print("Name: ");
				String n = input.nextLine();
				System.out.print("Id: ");
				String Id = input.nextLine();
				System.out.print("Manufacturer: ");
				String manufacturer = input.nextLine();
				System.out.print("Dose: ");
				float dose = input.nextFloat();
				System.out.print("Price: ");
				double unitPrice=input.nextDouble();
				System.out.print("Quantity: ");
				int quantity=input.nextInt();
				pharma.stockIn(n, Id, manufacturer,dose, unitPrice, quantity);
				
				break;
			case 4:
				System.out.print("Id: ");
				String ID = input.nextLine();
				System.out.print("Quantity: ");
				int Quantity=input.nextInt();
				System.out.print(pharma.sell(ID, Quantity));
				break;
			case 5:
				System.out.print("Id: ");
				String iD = input.nextLine();
				System.out.print("Price: ");
				double Price=input.nextDouble();
				System.out.print(pharma.updatePrice(iD, Price));
				break;
			case 0:
				break;
			}
		}
	}
}
