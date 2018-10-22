package sample.fxcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class LoginController {

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    TextField inputEmail;
    @FXML
    PasswordField inputPassword;


    @FXML
    public void onLoginButtonClicked() throws IOException {
        login();
    }

    public void onCancelButtonClicked() {
        System.exit(0);
    }

    private void login() throws IOException {
        String userEmail = inputEmail.getText();
        String userPass = inputPassword.getText();

        if (userEmail.equals("test") && userPass.equals("123")) {

            stage = (Stage) inputPassword.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/admin.fxml"));
            stage = (Stage) inputEmail.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } else {
            JOptionPane.showMessageDialog(null, "failed to verify user");
        }
    }



}