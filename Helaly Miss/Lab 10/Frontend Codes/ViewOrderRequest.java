package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import javafx.scene.control.cell.PropertyValueFactory;
import med.lib.Order;

public class ViewOrderRequest implements Initializable{
	  @FXML
	    private TableView<Order> TableFx;

	    @FXML
	    private TableColumn<Order, String> deliveryDateFx;

	    @FXML
	    private TableColumn<Order, String> itemIdFx;

	    @FXML
	    private TableColumn<Order, String> orderByFx;

	    @FXML
	    private TableColumn<Order, String> orderDateFx;

	    @FXML
	    private TableColumn<Order, String> orderIdFx;

	    @FXML
	    private TableColumn<Order, Integer> quantityFx;

	    @FXML
	    private TableColumn<Order, String> statusFx;

	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Admin Home Page");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	ObservableList<Order> list = FXCollections.observableArrayList( Main.pharma.getOrders());
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (!list.isEmpty()) {
			
			
			deliveryDateFx.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
			itemIdFx.setCellValueFactory(new PropertyValueFactory<>("itemId"));
			orderByFx.setCellValueFactory(new PropertyValueFactory<>("orderBy"));
			orderDateFx.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
			
			
			
			orderIdFx.setCellValueFactory(new PropertyValueFactory<>("orderId"));
			quantityFx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			statusFx.setCellValueFactory(new PropertyValueFactory<>("status"));
			TableFx.setItems(list);
		} else {

			JOptionPane.showMessageDialog(null, "No pending order.");
		}
		
		
		
	}
}


