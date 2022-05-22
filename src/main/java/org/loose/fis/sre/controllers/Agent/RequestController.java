package org.loose.fis.sre.controllers.Agent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import javafx.scene.image.ImageView;

public class RequestController {

    @FXML
    private Button accept;

    @FXML
    private Button decline;

    @FXML
    private TextArea requestarea;

    @FXML
    private Button seereviews;

    @FXML
    private TextField username;

    @FXML
    private TextField username1;

    @FXML
    private Text usernametext;
    @FXML
    private Text usernametext1;
    @FXML
    private Text response;
    @FXML
    private Text response1;
    @FXML
    private ImageView image;

    private String usra;

    private String usrc;

    @FXML
    void acceptOnAction(ActionEvent event) {
        usrc=username1.getText();
        if(UserService.checkUser(usrc)==1){
            UserService.deleteProgramare(usrc);
            UserService.deleteProgramare(usra);
            UserService.setUserStatus(usrc,2);
            UserService.setUserStatus(usra,-1);
            accept.setVisible(false);
            decline.setVisible(false);
            requestarea.setVisible(false);
            response1.setVisible(false);
            username1.setVisible(false);
            response.setVisible(true);
            image.setVisible(true);


        }
        else{
            response1.setVisible(true);
        }

    }

    @FXML
    void declineOnAction(ActionEvent event) {
        usrc=username1.getText();
        if(UserService.checkUser(usrc)==1){
            UserService.deleteProgramare(usrc);
            UserService.deleteProgramare(usra);
            UserService.setUserStatus(usrc,1);
            UserService.setUserStatus(usra,-1);



        }
        else{
            response1.setVisible(true);
        }

    }

    @FXML
    void requestOnAction(ActionEvent event) {
        usra=username.getText();

        if(UserService.checkUser(usra)==1){
            requestarea.setText(UserService.getUserProgramare(usra));
            requestarea.setVisible(true);
            accept.setVisible(true);
            decline.setVisible(true);
            seereviews.setVisible(false);
            username1.setVisible(true);
            username.setVisible(false);
            usernametext.setVisible(false);
            usernametext1.setVisible(false);
        }
        else{
            usernametext1.setVisible(true);
        }

    }

}
