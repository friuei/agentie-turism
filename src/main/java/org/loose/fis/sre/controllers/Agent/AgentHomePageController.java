package org.loose.fis.sre.controllers.Agent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AgentHomePageController {

    @FXML
    private Button addoffers;

    @FXML
    private AnchorPane ancortochange;

    @FXML
    private AnchorPane change;

    @FXML
    private Button deleteoffers;

    @FXML
    private Button homePage;

    @FXML
    private AnchorPane homepageanc;

    @FXML
    private Button logout;

    @FXML
    private Button requests;

    @FXML
    private Button reviews;

    @FXML
    void addOffersOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("addoffers.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void deleteOffersOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("deleteoffers.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void homePageOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("agenthomepage.fxml"));
        ancortochange.getChildren().setAll(pane);
    }

    @FXML
    void logOutOnAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) logout.getScene().getWindow();
        root= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }

    @FXML
    void requestsOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("requests.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    void reviewsOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("reviews.fxml"));
        change.getChildren().setAll(pane);
    }

}
