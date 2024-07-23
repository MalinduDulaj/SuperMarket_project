package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Customer;

public class CustomerController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtCustName;

    @FXML
    private TextField txtsalary;

    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) throws ClassNotFoundException, SQLException  {

        System.out.println("save customer Btn");
        int id = Integer.parseInt(txtCustId.getText());
        String name = txtCustName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtsalary.getText());

        System.out.println("ID: " + id);
        System.out.println("Name: "+name);
        System.out.println("Address: " + address);
        System.out.println("Salary: " + salary);

        Customer customer = new Customer(id,name,address, salary);
        System.out.println(customer);

        

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
        statement.setObject(1, customer.getCustomerID());
        statement.setObject(2, customer.getCustomerName());
        statement.setObject(3, customer.getAddress());
        statement.setObject(4, customer.getSalary());

        int rows = statement.executeUpdate();
        if(rows > 0){
            System.out.println("Customer saved successfully");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer saved successfully!!!").show();
        }else{
            System.out.println("Erroe while savins customer");
            new Alert(Alert.AlertType.ERROR,"Error while saving customer!!!").show();
        }

    }

}
