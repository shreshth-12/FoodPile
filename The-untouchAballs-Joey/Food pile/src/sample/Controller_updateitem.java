package sample;
import Client.main.Client;
import common.requests.Funct.UpdateItems;
import common.requests.Request;
import common.responses.Funct.UpdateItemsResponse;
import common.responses.Response;

import common.responses.ResponseCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Controller_updateitem {
    public Label headLabel;
    public Label usernameLabel;
    public Label quantityLabel;
    public Label productidLabel;
    public Button submitButton;
    public TextField usernameTextField;
    public TextField quantityTextField;
    public TextField productidTextField;

    public void submitListener(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        String username = this.usernameTextField.getText();
        int quantity = Integer.parseInt(this.quantityTextField.getText());
        String productID = this.productidTextField.getText();
        Socket socket = new Socket("localhost", 5470);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Request req = new UpdateItems(username, productID, quantity);
        objectOutputStream.writeObject(req);
        objectOutputStream.flush();
        Response res = (UpdateItemsResponse) objectInputStream.readObject();
        if (res.getCode() == ResponseCode.SUCCESS) {
            Parent root = null;
            Stage primaryStage = (Stage) submitButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("success.fxml"));
            try {

                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();


        } else {
            Parent root = null;
            Stage primaryStage = (Stage) submitButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Error.fxml"));
            try {

                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();

        }
    }

}
