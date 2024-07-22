package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void btnSaveCustomerOnAction(ActionEvent event) {

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


    }

}
