package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AcceptAnOrder {
	@FXML
	TextField idTF;
	public void acceptOrder() {
		String id = idTF.getText();
		try {
			if (Main.pharma.acceptOrderRequest(id)) {
				System.out.println("Order accepted / completed ");
			} else {
				System.out.println("Order not found ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
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
}
