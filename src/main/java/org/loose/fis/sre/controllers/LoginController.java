package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;


public class LoginController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    @FXML
    private AnchorPane openregisterpane;


    public void loginButtonOnAction(ActionEvent event){
        String username=usernameTextField.getText();
        String password=passwordField.getText();
        loginMessageLabel.setVisible(true);
        if(username!=null && password!=null){
            validateLogin();
        }
        else{

            loginMessageLabel.setText("Please enter your username and password!");

        }
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        loginMessageLabel.setVisible(true);
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void registerButtonOnAction(ActionEvent event) throws IOException {

        AnchorPane regpane= FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        openregisterpane.getChildren().setAll(regpane);
    }
    public void validateLogin(){


    }
}
