package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OpenProjectController {

    @FXML
    private Button button;

    @FXML
    private void switchToInviteCollab() throws IOException {
        App.setRoot("inviteCollab");
    }
}