package application;
	


import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import med.lib.DataHandler;
import med.lib.MedPharma;
import med.lib.Order;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	static Stage stage;
	static MedPharma pharma= new MedPharma("Alaska");
	static Order order = new Order("","",0);
	
	@Override
	public void start(Stage primaryStage) {
		stage=primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Fxml1.fxml"));
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
			stage.setTitle("Login Page");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			pharma=DataHandler.loadData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 
		launch(args);
	}
}
