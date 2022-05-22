package org.loose.fis.sre.controllers.Agent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.UserService;

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
    private Text usernametext;
    private String usr;

    @FXML
    void requestOnAction(ActionEvent event) {
                usr=usernametext.getText();
                String programare;
                if(UserService.checkUser(usr)==1){
                     programare=UserService.getUserProgramare(usr);
                     requestarea.setText(programare);
                     requestarea.setVisible(true);
                }
    }

}
