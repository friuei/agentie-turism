package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button gobackButton;

    @FXML
    private Button loginbutton;

    @FXML
    private AnchorPane openregisterpane;

    @FXML
    private PasswordField password;

    @FXML
    private Text tryagain;

    @FXML
    private TextField username;

    @FXML
    void cancelButtonOnAction(ActionEvent event) throws IOException {
       tryagain.setVisible(true);
        Stage stage=(Stage) gobackButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void loginButtonOnAction(ActionEvent event) throws IOException {
        String usern=username.getText();
        String pass=password.getText();


        tryagain.setVisible(true);
        if(usern!=null && pass!=null){
            int k;
            k= UserService.validateLogin(usern,pass);
            if(k!=0)
            {
                if(k==1){
                    //open interface for instructors
                    Stage stage;
                    Parent root;
                    stage = (Stage) loginbutton.getScene().getWindow();
                    root= FXMLLoader.load(getClass().getClassLoader().getResource("agenthomepage.fxml"));

                    stage.setScene(new Scene(root, 1127, 680));
                    stage.show();
                }
                if(k==2){
                    //open interface for clients
                    Stage stage;
                    Parent root;
                    stage = (Stage) loginbutton.getScene().getWindow();
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("clienthomepage.fxml"));

                    stage.setScene(new Scene(root, 1127, 680));
                    stage.show();
                }

            }
            else{
                tryagain.setText("Please try again!");
            }
        }
        else{

            tryagain.setText("Please enter your username and password!");

        }
    }

    @FXML
    void registerButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane regpane= FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        openregisterpane.getChildren().setAll(regpane);
    }

}
