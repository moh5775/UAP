package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdminController {
	@FXML
	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Fxml1.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Home Page");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void AddMedicine() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Add Medicine");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void AddAccessory() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddAccessory.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Add Accessory");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void viewOrderRequest() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ViewOrderRequest.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle(" View Order Request");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void acceptOrder() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AcceptAnOrder.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle(" View Order Request");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void FindExpiredMedicine() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FindExpiredMedicines.fxml"));
			Scene scene = new Scene(root,700,400);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Find Expired Medicine");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public void searchItem() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SearchForItems.fxml"));
			Scene scene = new Scene(root);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Item List");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	public void switchToAdmin(ActionEvent event) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchForItems.fxml"));
	        Parent root = loader.load();

	        // Pass the source page name
	        SearchForItems search= loader.getController();
	        search.setSourcePageName("Admin.fxml");
	        Scene scene = new Scene(root);
	        Main.stage.setScene(scene);
	        Main.stage.show();
	        Main.stage.setTitle("Search for items");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
