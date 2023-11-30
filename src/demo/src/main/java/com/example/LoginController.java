package com.example;

import java.io.IOException;

import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("dashboard");
    }
}
