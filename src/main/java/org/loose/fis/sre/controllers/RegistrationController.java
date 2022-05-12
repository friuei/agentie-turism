package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Button goBackButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Text registrationMessage;

    @FXML
    private TextField usernameField;
    @FXML
    private AnchorPane regpane;
    @FXML
    private ChoiceBox<String> role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Agent");
    }
    @FXML
    void goBackButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane regpane1= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        regpane.getChildren().setAll(regpane1);
    }

    @FXML
    void registerButtonOnAction(ActionEvent event) {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }

    }
    }




