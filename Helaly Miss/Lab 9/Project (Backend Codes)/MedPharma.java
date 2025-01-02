package med.lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MedPharma {
	public String name;
	ArrayList<Item> items = new ArrayList<>();
	ArrayList<Order> requestedItems = new ArrayList<>();

	public MedPharma(String name) {
		this.name = name;
	}

	public Item findItem(String id) throws InvalidItemException {
		for (Item x : items) {
			if (x.getId().equals(id))
				return x;
		}
		throw new InvalidItemException("Item with ID " + id + " not found.");
	}

	public Order findOrder(String orderId) throws InvalidOrderException {
		for (Order x : requestedItems) {
			if (x.getOrderId().equals(orderId))
				return x;
		}
		throw new InvalidOrderException("Order with ID " + orderId + " is invalid or not found.");
	}

	public ArrayList<Medicine> findItems(String name, String manufacturer, double dose, String unit, double unitPrice,
			String expirationDate) {
		ArrayList<Medicine> medicines = new ArrayList<>();
		for (Item x : items) {
			if (x instanceof Medicine) {
				Medicine medicine = (Medicine) x;
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate expDate = LocalDate.parse(expirationDate, format);

				if (medicine.getName().equals(name) && medicine.getManufacturer().equals(manufacturer)
						&& medicine.getDose() == dose && medicine.getUnit().equals(unit)
						&& medicine.getUnitPrice() == unitPrice && medicine.getExpirationDate().equals(expDate)) {
					medicines.add(medicine);
				}
			}
		}
		return medicines;
	}

	public ArrayList<Medicine> findExpiredMeds() {
		ArrayList<Medicine> expired_medicines = new ArrayList<>();
		for (Item x : items) {
			if (x instanceof Medicine) {
				Medicine exp_medicine = (Medicine) x;
				if (exp_medicine.hasExpired()) {
					expired_medicines.add(exp_medicine);
				}
			}

		}
		return expired_medicines;
	}

	public ArrayList<MedicalAccessory> findItems(String name, String manufacturer, String modelNo, double unitPrice) {
		ArrayList<MedicalAccessory> accessories = new ArrayList<>();
		for (Item x : items) {
			if (x instanceof MedicalAccessory) {
				MedicalAccessory accessory = (MedicalAccessory) x;
				if (accessory.getName().equals(name) && accessory.getManufacturer().equals(manufacturer)
						&& accessory.getModelNo().equals(modelNo) && accessory.getUnitPrice() == unitPrice) {
					accessories.add(accessory);
				}
			}
		}
		return accessories;
	}

	public ArrayList<Item> findItems(String name, String manufacturer) {
		ArrayList<Item> Items = new ArrayList<>();
		for (Item x : items) {
			if (x.getName().equals(name) && x.getManufacturer().equals(manufacturer)) {
				Items.add(x);
			}
		}
		return Items;
	}

	public String addItem(String name, String manufacturer, double dose, String unit, double unitPrice, int quantity,
			String expirationDate) {
		for (Item x : items) {
			if (x instanceof Medicine) {
				Medicine medicine = (Medicine) x;
				if (medicine.getName().equals(name) && medicine.getManufacturer().equals(manufacturer)) {
					medicine.increaseQuantity(quantity);
					return medicine.getId();
				}

			}
		}
		Medicine newMedicine = new Medicine(name, manufacturer, dose, unit, unitPrice, quantity, expirationDate);
		items.add(newMedicine);
		return newMedicine.getId();
	}

	public String addItem(String name, String manufacturer, String modelNo, double unitPrice, int quantity) {
		for (Item x : items) {
			if (x instanceof MedicalAccessory) {
				MedicalAccessory acessory = (MedicalAccessory) x;
				if (acessory.getName().equals(name) && acessory.getManufacturer().equals(manufacturer)) {
					acessory.increaseQuantity(quantity);
					return acessory.getId();
				}
			}
		}
		MedicalAccessory Accessory = new MedicalAccessory(name, manufacturer, modelNo, unitPrice, quantity);

		items.add(Accessory);
		return Accessory.getId();
	}

	public boolean acceptOrderRequest(String orderId) throws InvalidItemException, InvalidOrderException {
		Order order = findOrder(orderId);

		if (order == null) {
			throw new InvalidOrderException(orderId);
		} else {
			Item item = findItem(order.getItemId());
			if (item == null) {
				throw new InvalidItemException(orderId);
			} else {

				boolean b = item.decreaseQuantity(order.getQuantity());
				if (b) {
					order.complateOrder();
					return true;
				}
			}

		}
		return false;
	}

	public String orderItem(String medId, String customerContact, int quantity) throws InvalidItemException {
		Item item = findItem(medId);
		if (item == null) {
			throw new InvalidItemException(medId);
		} else {
			Order order = new Order(medId, customerContact, quantity);
			requestedItems.add(order);
			return order.getOrderId();
		}
	}

	public ArrayList<Order> getMyOrder(String customerContact) {
		ArrayList<Order> orders = new ArrayList<>();
		for (Order x : requestedItems) {
			if (x.getOrderBy().equals(customerContact)) {
				orders.add(x);
			}
		}
		return orders;
	}

	public ArrayList<Order> getNewOrders() {
		ArrayList<Order> orders = new ArrayList<>();
		for (Order x : requestedItems) {
			if (x.getStatus().equals("New")) {
				orders.add(x);
			}
		}
		return orders;
	}

}
