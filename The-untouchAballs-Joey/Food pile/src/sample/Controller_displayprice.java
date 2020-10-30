package sample;
;
import Client.main.Client;
import common.requests.Funct.DisplayPrice;
import common.requests.Request;
import common.responses.Funct.DisplayPriceResponse;
import common.responses.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Controller_displayprice {
    public Label headLabel;
    public Button backButton;
    public Button logoutButton;
    public TextArea displayArea;

    Socket socket = null;

    {
        try {
            socket = new Socket("localhost", 5400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backListener(ActionEvent actionEvent) {
        Parent root = null;
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("homepage.fxml"));
        try {

            root = fxmlLoader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


    }
    public void logoutListener(ActionEvent actionEvent) {
        Main.logout();
    }
}
