package org.loose.fis.sre.controllers.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button bookanoffer;
    @FXML    
    private AnchorPane ancortochange;
    @FXML
    private AnchorPane change;

    @FXML
    private Button homepage;

    @FXML
    private AnchorPane homepageanc;

    @FXML
    private Button logout;

    @FXML
    private Button review;

    @FXML
    private Button seeRequest;

    @FXML
    private Button seeoffers;

    @FXML
    void bookAnOfferOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("book_an_offer.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void homePageOnAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getClassLoader().getResource("clienthomepage.fxml"));
        ancortochange.getChildren().setAll(pane);
    }

    @FXML
    void logOutOnAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) logout.getScene().getWindow();
        root=FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }

    @FXML
    void reviewAnAgency(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("review_client.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void seeOffersOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("seeoffers.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void seeRequestOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("client_requests.fxml"));
        change.getChildren().setAll(pane);
    }

}
