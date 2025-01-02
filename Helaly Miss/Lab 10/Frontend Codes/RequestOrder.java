package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import med.lib.DataHandler;
import med.lib.Medicine;
import med.lib.Order;

public class RequestOrder implements Initializable {
	@FXML
	private TableView<Order> TableFx;

	@FXML
	private TextField customerContactTf;

	@FXML
	private TableColumn<Order, String> deliveryDateFx;

	@FXML
	private TableColumn<Order, String> itemIdFx;

	@FXML
	private TextField medIdTf;

	@FXML
	private TableColumn<Order, String> orderDateFx;

	@FXML
	private TableColumn<Order, String> orderIdFx;

	@FXML
	private TableColumn<Order, String> orderedByFx;

	@FXML
	private TableColumn<Order, Integer> quantityFx;

	@FXML
	private TextField quantityTf;

	@FXML
	private TableColumn<Order, String> statusFx;

	public void requestOrder() {

		String medId = medIdTf.getText();

		String customerContact = customerContactTf.getText();

		int quantity = Integer.parseInt(quantityTf.getText());

		String x = null;
		try {
			x = Main.pharma.orderItem(medId, customerContact, quantity);
			DataHandler.saveData(Main.pharma);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Successfully ordered. Requested order's id: " + x);

	}

	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(root);

			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Customer Home Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewOrders() {
		String customerContact = customerContactTf.getText();
		ObservableList<Order> list = FXCollections.observableArrayList(Main.pharma.getMyOrder(customerContact));
		if (!list.isEmpty()) {

			deliveryDateFx.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));

			itemIdFx.setCellValueFactory(new PropertyValueFactory<>("itemId"));
			orderDateFx.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
			orderIdFx.setCellValueFactory(new PropertyValueFactory<>("orderId"));
			orderedByFx.setCellValueFactory(new PropertyValueFactory<>("orderBy"));
			quantityFx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			statusFx.setCellValueFactory(new PropertyValueFactory<>("status"));
			TableFx.setItems(list);
		} else {
			System.out.println("No requested order.");
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	

}
