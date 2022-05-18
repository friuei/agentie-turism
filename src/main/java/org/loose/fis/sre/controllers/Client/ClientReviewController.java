package org.loose.fis.sre.controllers.Client;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import org.w3c.dom.Text;
import org.loose.fis.sre.services.UserService;
import java.io.IOException;


public class ClientReviewController {

    @FXML
    private ComboBox cb1;
    @FXML
    private ComboBox cb2;
    private ObservableList<String> items1 = FXCollections.observableArrayList();


    @FXML
    private void buttonOneOnAction(ActionEvent event)throws IOException{
        UserService.getAgents(items1);
        cb1.getItems().addAll(items1);
        cb2.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
    }

    @FXML
    private void buttonTwoOnAction(ActionEvent event)throws IOException{
        if(cb1.getSelectionModel().getSelectedItem()!=null&&cb2.getSelectionModel().getSelectedItem()!=null){
            String i=cb1.getSelectionModel().getSelectedItem().toString();
            String g=cb2.getSelectionModel().getSelectedItem().toString();

            UserService.modifyUserReview(i,g);


        }


    }
}
