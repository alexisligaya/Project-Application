package com.example;

import java.io.IOException;

import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    private void switchToOpenProject() throws IOException {
        App.setRoot("openProject");
    }

}