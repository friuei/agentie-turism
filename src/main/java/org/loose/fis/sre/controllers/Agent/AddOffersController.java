package org.loose.fis.sre.controllers.Agent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.loose.fis.sre.services.UserService;
import javafx.scene.image.ImageView;
public class AddOffersController {

    @FXML
    private Button addoffer;

    @FXML
    private Button authbutton;

    @FXML
    private TextArea descriere;

    @FXML
    private Text logintext;

    @FXML
    private Text logintext1;

    @FXML
    private Text offertext;

    @FXML
    private TextField oras;

    @FXML
    private PasswordField passfield;

    @FXML
    private TextField pret;

    @FXML
    private Text submitedtext;

    @FXML
    private TextField tara;

    @FXML
    private TextField usernamefield;
     private String usr;
    @FXML
    private ImageView submitimage;


    @FXML
    void authOnACtion(ActionEvent event) {
            usr=usernamefield.getText();
            String pass=passfield.getText();
            int k;
            k= UserService.validateLogin(usr,pass);
            if(usr!=null&&pass!=null) {
                if (k == 1) {
                    authbutton.setVisible(false);
                    logintext.setVisible(false);
                    logintext1.setVisible(false);
                    passfield.setVisible(false);
                    usernamefield.setVisible(false);
                    pret.setVisible(true);
                    tara.setVisible(true);
                    oras.setVisible(true);
                    descriere.setVisible(true);
                    addoffer.setVisible(true);
                }
                else{
                    logintext1.setVisible(true);


                }
            }
            else{
                logintext1.setVisible(true);


            }
    }
    @FXML
    void addOfferOnAction(ActionEvent event)  {
        String t=tara.getText();
        String o=oras.getText();
        String p=pret.getText();
        String d=descriere.getText();
        String Offer="Agent:"+usr+"\nTara:"+t+"\nOras:"+o+"\nPret:"+p+"Lei"+"\nDescriere:"+d+"\n";

        if(t!=null||o!=null||p!=null){
            if(UserService.addOffer(Offer,usr)>0) {
                pret.setVisible(false);
                tara.setVisible(false);
                oras.setVisible(false);
                descriere.setVisible(false);
                addoffer.setVisible(false);
                submitedtext.setVisible(true);
                submitimage.setVisible(true);
            }
            else{
                offertext.setText("You have already an offer ");
                offertext.setVisible(true);
            }
        }
        else {
            offertext.setVisible(true);
        }
    }




}
