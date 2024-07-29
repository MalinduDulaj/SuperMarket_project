package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Item;

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
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPacksize;

    @FXML
    private TableColumn<?, ?> colUnitprice;

    @FXML
    private TableColumn<?, ?> colqoh;


    @FXML
    private TableView<?> tblItem;

    public void getAllItem() throws ClassNotFoundException,SQLException{

        ///////////////////////////////
    }


    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveItemOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {

        System.out.println("Code : "+ txtCode.getText());
        System.out.println("Description : "+ txtDescription);
        System.out.println("Pack_Size :"+txtPackSize);
        System.out.println("Unit_Price :"+ txtUnitPrice);
        System.out.println("Quantaty_on_hand :"+txtQOH);

        int code = Integer.parseInt(txtCode.getText());
        String description = txtDescription.getText();
        String pack_Size = txtPackSize.getText();
        double unit_Price = Double.parseDouble(txtUnitPrice.getText());
        int quantaty_on_hand = Integer.parseInt(txtCode.getText());

        Item item = new Item(code,description,pack_Size,unit_Price,quantaty_on_hand);
        System.out.println(item);

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO Items VALUES (?,?,?,?)");

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

    }

    @FXML
    void btnUpdateItem(ActionEvent event) {

    }

    @FXML
    void btnPlaceorderOnAction(ActionEvent event) throws ClassNotFoundException,SQLException {
      getAllItem();
    }


}
