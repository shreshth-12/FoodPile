package sample;

import common.requests.Request;
import common.requests.auth.SignupRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_signup {
    public Label headLabel;
    public Label firstnameLabel;
    public Label lastnameLabel;
    public Label usernameLabel;
    public Label passwordLabel;
    public TextField firstnameTextField;
    public TextField lastnameTextField;
    public TextField usernameTextField;
    public PasswordField passwordField;
    public Button signupButton;


    public void signupListener(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String username = this.usernameTextField.getText();
        String password = this.passwordField.getText();
        String fname = this.firstnameTextField.getText();
        String lname = this.lastnameTextField.getText();
        Request req = new SignupRequest(fname, lname, username, password);
        Parent root = null;
        Stage primaryStage = (Stage) signupButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        try {

            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


    }
}
