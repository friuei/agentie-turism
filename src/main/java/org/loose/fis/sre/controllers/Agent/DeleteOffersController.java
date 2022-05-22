package org.loose.fis.sre.controllers.Agent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.UserService;

public class DeleteOffersController {

    @FXML
    private Button delete;

    @FXML
    private Text deletetext;

    @FXML
    private Text deletetext1;

    @FXML
    private Button login;
    @FXML
    private TextArea offer;

    @FXML
    private Text logintext;

    @FXML
    private Text logintext1;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private ImageView succes;

    @FXML
    private TextField usernamefield;
    private String username;


    @FXML
    void loginOnAction(ActionEvent event) {
        username=usernamefield.getText();
        String password=passwordfield.getText();
        String oferta="";
        int k;
        k= UserService.validateLogin(username,password);
                if(k==1){
                    logintext.setVisible(false);
                    logintext1.setVisible(false);
                    usernamefield.setVisible(false);
                    passwordfield.setVisible(false);
                    login.setVisible(false);
                    oferta =UserService.getOffers(username);
                    delete.setVisible(true);
                    offer.setVisible(true);
                    deletetext.setVisible(true);
                    if(!oferta.equals("e")){

                        offer.setText(oferta);

                    }
                    else {
                        delete.setDisable(true);
                        offer.setText("Nu ai nici o oferta de sters");
                    }

                }
                else{
                    logintext1.setVisible(true);
                }
    }
    @FXML
    void deleteOnAction(ActionEvent event) {
        UserService.deleteOffers(username);
        delete.setVisible(false);
        deletetext.setVisible(false);
        offer.setVisible(false);
        deletetext1.setVisible(true);
        succes.setVisible(true);

    }

}

