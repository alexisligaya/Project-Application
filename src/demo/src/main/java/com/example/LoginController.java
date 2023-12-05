package com.example;

import java.io.IOException;
import com.model.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class LoginController {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;

    @FXML
    private void login() throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        Application application = Application.getInstance();

        if (!application.login(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }

        App.setRoot("dashboard");
    }
    @FXML
    private void goSignUp() throws IOException {
        App.setRoot("signUp");
    }
}
