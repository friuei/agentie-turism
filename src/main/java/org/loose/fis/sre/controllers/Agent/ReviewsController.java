package org.loose.fis.sre.controllers.Agent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.UserService;

public class ReviewsController {

    @FXML
    private TextArea reviews;

    @FXML
    private Button seereviews;

    @FXML
    private TextField username;

    @FXML
    private Text usernametext;
    private String usr;

    @FXML
    void reviewsOnAction(ActionEvent event) {
        usr=username.getText();
        String review= UserService.getUserReview(usr);
        reviews.setVisible(true);
        username.setVisible(false);
        usernametext.setVisible(false);
        seereviews.setVisible(false);

        if(review!=null){
            if(review.equals("")) {
                reviews.setText(review);
            }
            else{
                reviews.setText("Nu ai nici un reeview");
            }
        }
        else{
            reviews.setText("Username gresit");
        }


    }

}
