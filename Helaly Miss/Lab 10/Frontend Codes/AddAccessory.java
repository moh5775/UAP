package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import med.lib.DataHandler;

public class AddAccessory {
	@FXML
	TextField nameTf;
	@FXML
	TextField manTf;
	@FXML
	TextField modelTf;
	@FXML
	TextField priceTf;
	@FXML
	TextField quantityTf;

	public void addAccessory(ActionEvent event) {
		String name=nameTf.getText();
		String manufacture=manTf.getText();
		String model=modelTf.getText();
		double price=Double.parseDouble(priceTf.getText());
		int quantity=Integer.parseInt(quantityTf.getText());
		String id = Main.pharma.addItem(name, manufacture, model, price, quantity);
		System.out.println("Id: "+id);
		try {
			DataHandler.saveData(Main.pharma);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
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
