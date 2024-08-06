package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

     @FXML
    private AnchorPane root;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {

            System.out.println("Customer Button Clicked");

        
            // URL resource = this.getClass().getResource("/view/Customer.fxml");
            // Parent node = FXMLLoader.load(resource);
            // Stage stage = new Stage();
            // stage.setScene(new Scene(node));
            // stage.show();
            // stage.setTitle("Customer Form");
        

        //Load to existing stage
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Customer.fxml"));
        this.root.getChildren().add(node);



    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {

        System.out.println("Item Button Clicked");

        //Load to existin stage
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Item.fxml"));
        this.root.getChildren().add(node);


    }

    // @FXML
    // void btnOrderOnAction(ActionEvent event) throws IOException {

    //     System.out.println("Order Button Clicked");

    //     this.root.getChildren().clear();
    //     Parent node = FXMLLoader.load(this.getClass().getResource("/view/Order.fxml"));
    //     this.root.getChildren().add(node);

    // }

    @FXML
    private void btnOrderOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Order.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
