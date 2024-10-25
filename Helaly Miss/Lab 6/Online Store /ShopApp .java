package store.app;

import java.util.Scanner;

import store.Shop;

public class ShopApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Store name: ");
		String name = input.nextLine();
		Shop shop = new Shop(name);
		while (true) {
			System.out.println(
					"1: view all\n2: view a specific item\n3: add item\n4: sell item\n5: see sale price of an item\n0: exit\n");
			System.out.print("Enter your choice: ");
			int option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1:
				shop.viewItems();
				break;
			case 2:
				System.out.print("Enter ID: ");
				String iD = input.nextLine();
				shop.viewItem(iD);
				break;
			case 3:
				System.out.print("Enter Name: ");
				String Name = input.nextLine();
				System.out.print("Enter ID: ");
				String Id = input.nextLine();
				System.out.print("Enter Catagory: ");
				String category = input.nextLine();
				System.out.print("Enter Price: ");
				double price = input.nextDouble();
				System.out.print("Enter Count: ");
				int Count = input.nextInt();

				shop.addItem(Name, Id, category, price, Count);
				break;
			case 4:
				System.out.print("Enter ID: ");
				String ID = input.nextLine();
				System.out.print("Enter Quantity: ");
				int quantity = input.nextInt();
				shop.sellAnItem(ID, quantity);
				break;
			case 5:
				System.out.print("Enter ID: ");
				String id = input.nextLine();
				System.out.print("Enter Sale Amount: ");
				double amount = input.nextDouble();
				System.out.println("Sale price: " + shop.getSalePriceOfAnItem(id, amount));
				break;
			case 0:
				break;
			}
		}
	}
}
