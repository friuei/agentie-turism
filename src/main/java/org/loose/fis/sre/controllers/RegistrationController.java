package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private AnchorPane gobacktologin;
    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;

    public RegistrationController() {
    }

    @FXML
    public void initialize() {
        this.role.getItems().addAll(new Object[]{"Client", "Agent"});
    }

    @FXML
    public void registerButtonOnAction() {
        try {
            UserService.addUser(this.usernameField.getText(), this.passwordField.getText(), (String)this.role.getValue());
            this.registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException var2) {
            this.registrationMessage.setText(var2.getMessage());
        }

    }

    @FXML
    public void closeButtonOnAction(ActionEvent event){

        Stage stage=(Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBackButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane logpane= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        gobacktologin.getChildren().setAll(logpane);
    }
    public void onAction(){

    }

}

