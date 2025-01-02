package med.app;

import java.util.ArrayList;
import java.util.Scanner;

import med.lib.InvalidItemException;
import med.lib.InvalidOrderException;
import med.lib.Item;
import med.lib.MedPharma;
import med.lib.MedicalAccessory;
import med.lib.Medicine;
import med.lib.Order;

public class PharmaApp {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Name: ");
		String name = input.nextLine();
		MedPharma pharma = new MedPharma(name);
		Order o = new Order("", "", 1);
		o.complateOrder();
		while (true) {
			System.out.println("\n1: login as employee\n2: login as customer\n3: switch role\n0: exit");
			System.out.println("Choose Option: ");
			int menu = input.nextInt();
			input.nextLine();
			switch (menu) {
			case 1:
				System.out.println("Logged in as employee.\nSelect....");
				System.out.println("\n1: add a medicine.\n");
				System.out.println("2: add an accessory.\n");
				System.out.println("3: to view order requests.\n");
				System.out.println("4: to accept an order.\n");
				System.out.println("5: search for items (medicines, accessories, both)\n");
				System.out.println("6: to find expired medicines. \n");
				System.out.println("0: to logout.\n");
				System.out.println("Choose Employee Menu: ");
				int option = input.nextInt();
				input.nextLine();
				switch (option) {
				case 1:// add a medicine
					System.out.println("Name: ");
					String Name = input.nextLine();
					System.out.println("manufacturer: ");
					String manufacturer = input.nextLine();
					System.out.println("dose: ");
					double dose = input.nextDouble();
					input.nextLine();
					System.out.println("Unit: ");
					String unit = input.nextLine();

					System.out.println("Unit Price: ");
					double unitPrice = input.nextDouble();
					input.nextLine();
					System.out.println("Quantity: ");
					int quantity = input.nextInt();
					input.nextLine();
					System.out.println("ExpirationDate: ");
					String expirationDate = input.nextLine();
					System.out.println("Id of added medicine: "
							+ pharma.addItem(Name, manufacturer, dose, unit, unitPrice, quantity, expirationDate));
					break;
				case 2:// add an accessory
					System.out.println("Name: ");
					String n = input.nextLine();

					System.out.println("manufacturer: ");
					String m = input.nextLine();

					System.out.println("Model no: ");
					String model = input.nextLine();

					System.out.println("Unit Price: ");
					double Price = input.nextDouble();

					System.out.println("Quantity: ");
					int Quantity = input.nextInt();
					System.out.println("Id of added accessory: " + pharma.addItem(n, m, model, Price, Quantity));
					break;
				case 3:
					ArrayList<Order> newOrders = pharma.getNewOrders();
					if (newOrders.isEmpty()) {
						System.out.println("No new orders available.");
					} else {
						System.out.println("New Orders:");
						for (Order order : newOrders) {
							System.out.println(order);
						}
					}
					break;
				case 4:
					try {
						System.out.println("Order id: ");
						String id = input.nextLine();

						if (pharma.acceptOrderRequest(id)) {
							System.out.println("Order accepted / completed ");
						} else {
							System.out.println("Order rejected/ Order not found ");
						}
					} catch (InvalidItemException e) {
						System.out.println("Ex: " + e);
					} catch (InvalidOrderException e) {
						System.out.println("Ex: " + e);
					}

					break;
				case 5:
					System.out.println("search for : medicines/ accessories/ both ??: ");
					String type = input.nextLine();
					System.out.println("Name: ");
					String N = input.nextLine();
					System.out.println("Manufacturer: ");
					String Manufacturer = input.nextLine();
					ArrayList<Item> y = pharma.findItems(N, Manufacturer);
					if (type.equalsIgnoreCase("medicines")) {

						if (y != null)
							System.out.println("Medicine details: " + y);
						else {
							System.out.println("Not found");
						}

					}

					else if (type.equalsIgnoreCase("accessories")) {
						if (y != null)
							System.out.println("Medical accessory details: " + y);
						else
							System.out.println("Not found");
					}

					else if (type.equalsIgnoreCase("both")) {

						if (y != null)
							System.out.println("Item details: " + y);
						else {
							System.out.println("Item not found");
						}
					}

					break;
				case 6:
					System.out.println("Expired Medicines: ");
					ArrayList<Medicine> meds = pharma.findExpiredMeds();
					if (meds != null) {
						for (Medicine x : meds) {
							System.out.println(x);
						}
					} else {
						System.out.println("No expired medicines found.");
					}
					break;
				case 0:
					System.out.println("Logged Out");
					break;
				}
				break;
			case 2:
				System.out.println("Logged in as customer.\nSelect....");
				System.out.println("\n1: request an order\n");
				System.out.println("2: search for items.\n");
				System.out.println("3: view details of their order\n");
				System.out.println("4: pay the bill\n");
				System.out.println("0: logout\n");
				int Option = input.nextInt();
				input.nextLine();
				switch (Option) {
				case 1:
					System.out.println("Med_ID: ");
					String medId = input.nextLine();
					System.out.println("Contact No: ");
					String customerContact = input.nextLine();
					System.out.println("Quantity: ");
					int Q = input.nextInt();
					String x = null;
					try {
						x = pharma.orderItem(medId, customerContact, Q);
					} catch (InvalidItemException e) {
						System.out.println("Ex: " + e);
					}

					System.out.println("Successfully ordered. Requested order's id: " + x);

					break;
				case 2:
					System.out.println("search for : medicines/ accessories/ both ??: ");
					String type = input.nextLine();
					System.out.println("Name: ");
					String N = input.nextLine();
					System.out.println("Manufacturer: ");
					String Manufacturer = input.nextLine();
					ArrayList<Item> y = pharma.findItems(N, Manufacturer);
					if (type.equalsIgnoreCase("medicines")) {

						if (y != null)
							System.out.println("Medicine details: " + y);
						else {
							System.out.println("Not found");
						}

					}

					else if (type.equalsIgnoreCase("accessories")) {
						if (y != null)
							System.out.println("Medical accessory details: " + y);
						else
							System.out.println("Not found");
					}

					else if (type.equalsIgnoreCase("both")) {

						if (y != null)
							System.out.println("Item details: " + y);
						else {
							System.out.println("Item not found");
						}
					}
					break;
				case 3:
					System.out.println("Contact number: ");
					String Contact = input.nextLine();
					ArrayList<Order> orders = pharma.getMyOrder(Contact);
					for (Order order : orders) {
						if (order != null) {
							System.out.println(order);
						}

					}
					break;
				case 4:
					System.out.println("Name: ");
					String n = input.nextLine();
					System.out.println("Manufacture: ");
					String m = input.nextLine();
					System.out.println("Model no: ");
					String model = input.nextLine();
					System.out.println("Unit Price: ");
					double unitPrice = input.nextDouble();
					System.out.println("Quantity: ");
					int quantity = input.nextInt();
					MedicalAccessory accessory = new MedicalAccessory(n, m, model, unitPrice, quantity);
					System.out.println("has discount ? true / false: ");
					boolean b = input.nextBoolean();
					accessory.setHasDiscount(b);
					System.out.println(accessory.getBill());
					break;

				}
				break;
			case 0:
				System.out.println("Logged Out");
				break;
			}
			input.close();
		}
		
	}
}
