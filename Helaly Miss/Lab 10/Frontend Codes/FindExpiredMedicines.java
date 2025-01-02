package application;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import med.lib.Medicine;

public class FindExpiredMedicines implements Initializable {
	@FXML
	private TableView<Medicine> TableFx;

	@FXML
	private TableColumn<Medicine, String> dateFx;

	@FXML
	private TableColumn<Medicine, Double> doseFx;

	@FXML
	private TableColumn<Medicine, String> manuFx;

	@FXML
	private TableColumn<Medicine, String> nameFx;

	@FXML
	private TableColumn<Medicine, Double> priceFx;

	@FXML
	private TableColumn<Medicine, Integer> quantityFx;

	@FXML
	private TableColumn<Medicine, String> unitFx;

	public void Logout(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
			Scene scene = new Scene(root);

			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Admin Home Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	ObservableList<Medicine> list = FXCollections.observableArrayList(Main.pharma.findExpiredMeds());
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (!list.isEmpty()) {
			
			dateFx.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
			
			doseFx.setCellValueFactory(new PropertyValueFactory<>("dose"));
			manuFx.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
			nameFx.setCellValueFactory(new PropertyValueFactory<>("name"));
			priceFx.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
			quantityFx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			unitFx.setCellValueFactory(new PropertyValueFactory<>("unit"));
			TableFx.setItems(list);
		} else {
			System.out.println("No expired medicines found.");
		}
	}

}



		
		
		
		
		
		
		
		