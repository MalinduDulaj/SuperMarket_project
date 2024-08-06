package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderController {

    @FXML
    private AnchorPane root;


    @FXML
    private TextField txtcustid;

    @FXML
    private TextField txtorderdata;

    @FXML
    private TextField txtorderid;

    @FXML
    void btnBackOrderOnAction(ActionEvent event) throws IOException {

        System.out.println("oder back to main");

        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);

    }
}
