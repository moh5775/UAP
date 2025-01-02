package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import med.lib.InvalidIOrderException;
import med.lib.InvalidItemException;
import med.lib.MedicalAccessory;

public class PayTheBill {
	@FXML
	TextField orderIdTf;
	
	
	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Customer Home Page");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void payBill() {
		
		String orderId= orderIdTf.getText();
		
		try {
			System.out.println(Main.pharma.payBill(orderId));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 
	}
	
}














