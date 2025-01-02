package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CustomerController {
	@FXML
	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Fxml1.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Admin Home Page");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void requestOrder() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("RequestOrder.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("RequestOrder");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void PayBill() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("PayTheBill.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Bill");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void switchToCustomer(ActionEvent event) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchForItems.fxml"));
	        Parent root = loader.load();

	        // Pass the source page name
	       
	        
	        SearchForItems search= loader.getController();
	        search.setSourcePageName("Customer.fxml");
	        
	        Scene scene = new Scene(root);
	        Main.stage.setScene(scene);
	        Main.stage.show();
	        Main.stage.setTitle("Search for items");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
}
