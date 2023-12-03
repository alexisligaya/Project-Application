package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardController {


    @FXML
    private void switchToOpenProject() throws IOException {
        App.setRoot("openProject");
    }

}