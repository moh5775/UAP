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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import med.lib.Item;
import med.lib.Medicine;

public class SearchForItems implements Initializable {
    @FXML
    private TableView<Item> Table1;

    @FXML
    private TableColumn<Item, String> idFx;

    @FXML
    private TableColumn<Item, String> manuFx;

    @FXML
    private TextField manuTa;

    @FXML
    private TableColumn<Item, String> modelFx;

    @FXML
    private TableColumn<Item, String> nameFx;

    @FXML
    private TextField nameTa;

    @FXML
    private TableColumn<Item, Double> priceFx;

    @FXML
    private TableColumn<Item, Integer> quantityFx;

    @FXML
    private TableColumn<Medicine, Double> doseFx;

    @FXML
    private TableColumn<Medicine, String> exp_dateFx;

    @FXML
    private TableColumn<Medicine, Double> unitFx;

    private String sourcePageName;

    public void setSourcePageName(String sourcePage) {
        this.sourcePageName = sourcePage;
    }

    public void Logout(ActionEvent event) {
        String targetPage = sourcePageName != null && sourcePageName.equals("Admin.fxml") ? "Admin.fxml" : "Customer.fxml";

        try {
            Parent root = FXMLLoader.load(getClass().getResource(targetPage));
            Scene scene = new Scene(root);

            Main.stage.setScene(scene);
            Main.stage.show();
            if (targetPage.equals("Admin.fxml"))
                Main.stage.setTitle("Admin Home Page");
            else if (targetPage.equals("Customer.fxml"))
                Main.stage.setTitle("Customer Home Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search() {
        // Get user inputs from text fields
        String name = nameTa.getText().trim();
        String manufacturer = manuTa.getText().trim();

        // Fetch matching items
        ArrayList<Item> items = Main.pharma.findItems(name, manufacturer);

        // Create an observable list
        ObservableList<Item> list = FXCollections.observableArrayList(items);

        // Bind the table columns to the item properties
        idFx.setCellValueFactory(new PropertyValueFactory<>("id"));
        manuFx.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        nameFx.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceFx.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        quantityFx.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Bind medicine-specific columns (if any medicines are in the results)
        doseFx.setCellValueFactory(new PropertyValueFactory<>("dose"));
        exp_dateFx.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        unitFx.setCellValueFactory(new PropertyValueFactory<>("unit"));
        modelFx.setCellValueFactory(new PropertyValueFactory<>("modelNo"));


        // Set the list in the table
        Table1.setItems(list);

        // Handle the case where no items are found
        if (list.isEmpty()) {
            System.out.println("No items found.");
        }
    }

    /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        // Optionally initialize the table with all items or leave it empty
        ObservableList<Item> allItems = FXCollections.observableArrayList(Main.pharma.getItems());
        Table1.setItems(allItems);
    }*/
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Retrieve all items and populate the table
        ObservableList<Item> allItems = FXCollections.observableArrayList(Main.pharma.getItems());
        idFx.setCellValueFactory(new PropertyValueFactory<>("id"));
        manuFx.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        nameFx.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceFx.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        quantityFx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        doseFx.setCellValueFactory(new PropertyValueFactory<>("dose"));
        exp_dateFx.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        unitFx.setCellValueFactory(new PropertyValueFactory<>("unit"));
        modelFx.setCellValueFactory(new PropertyValueFactory<>("modelNo"));

        // Populate the table with all items
        Table1.setItems(allItems);
    }

}
