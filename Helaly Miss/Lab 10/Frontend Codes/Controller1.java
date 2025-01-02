package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Controller1 {
	@FXML
	TextField idTf;
	public void login() {
		String id=idTf.getText();
		if(id.equals("1234")) {
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
		else {
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
	}
}
