package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Item;
import tm.ItemTM;

public class ItemController {
    
     @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQOH;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TableColumn<ItemTM, String> colCode;

    @FXML
    private TableColumn<ItemTM,String> colDescription;

    @FXML
    private TableColumn<ItemTM,String> colPacksize;

    @FXML
    private TableColumn<ItemTM, Double> colUnitprice;

    @FXML
    private TableColumn<ItemTM,Integer> colqoh;


    @FXML
    private TableView<?> tblItem;

    public void initialize() throws ClassNotFoundException, SQLException {
        colCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPacksize.setCellValueFactory(new PropertyValueFactory<>("Pack_Size"));
        colUnitprice.setCellValueFactory(new PropertyValueFactory<>("Unit_Price"));
        colqoh.setCellValueFactory(new PropertyValueFactory<>("Quantaty_on_hand"));
        
        //getAllItem();

    }



    public void getAllItem() throws ClassNotFoundException,SQLException{
        
            PreparedStatement statement = DBConnection.getInstance().getConnection()
                .prepareStatement("SELECT * FROM  Items");
        ResultSet itemSet = statement.executeQuery();

        ArrayList<Item> itemList = new ArrayList<Item>();

        while (itemSet.next()) {
            Item item = new Item(itemSet.getString("Code"),
              itemSet.getString("Description"),
              itemSet.getString("Pack_Size"), 
              itemSet.getDouble("Unit_Price"), 
              itemSet.getInt("Quantaty_on_hand"));

            System.out.println(item); 
            itemList.add(item);
        }

        System.out.println("ItemList :"+itemList);

        /////////////////////////////////////////////////////////////////

        ObservableList<ItemTM>itemTMList = FXCollections.observableArrayList();

        for (Item item : itemList) {
            ItemTM itemTM = new ItemTM(
                    item.getCode(),
                    item.getDescription(),
                    item.getPack_Size(),
                    item.getUnit_Price(),
                    item.getQuantaty_on_hand());

            itemTMList.add(itemTM);
        }
        System.out.println(itemTMList);

        tblItem.setItems((ObservableList<?>) itemTMList);

        
        }
        
    

    


    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {
        System.out.println("Delete Button Clicked");

    }

    @FXML
    void btnSaveItemOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {

        // System.out.println("Code : "+ txtCode.getText());
        // System.out.println("Description : "+ txtDescription);
        // System.out.println("Pack_Size :"+txtPackSize);
        // System.out.println("Unit_Price :"+ txtUnitPrice);
        // System.out.println("Quantaty_on_hand :"+txtQOH);

        String code = txtCode.getText();
        String description = txtDescription.getText();
        String pack_Size = txtPackSize.getText();
        double unit_Price = Double.parseDouble(txtUnitPrice.getText());
        int quantaty_on_hand = Integer.parseInt(txtCode.getText());

        Item item = new Item(code,description,pack_Size,unit_Price,quantaty_on_hand);
        //System.out.println(item);

        try {
            Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO Items VALUES (?,?,?,?,?)");

        statement.setObject(1,item.getCode());
        statement.setObject(2,item.getDescription());
        statement.setObject(3,item.getPack_Size());
        statement.setObject(4,item.getUnit_Price());
        statement.setObject(5,item.getQuantaty_on_hand());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Item Saved Successfully!!!");
            new Alert(Alert.AlertType.CONFIRMATION, "Item Saved Successfully!!!").show();
        } else {
            System.out.println("Error While Saving Item");
            new Alert(Alert.AlertType.ERROR, "Error While Saving Item").show();
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        


    }

    @FXML
    void btnUpdateItem(ActionEvent event) {
        System.out.println("Update Button Clicked");

    }

    @FXML
    void btnPlaceorderOnAction(ActionEvent event) throws ClassNotFoundException,SQLException {

      getAllItem();
    }


    @FXML
    void btnItemBackOnAction(ActionEvent event) throws IOException {
        System.out.println("Back to main Button Click");

        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);

    }


}
