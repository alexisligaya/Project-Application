package com.example;

import java.io.IOException;

import javafx.fxml.FXML;

public class OpenProjectController {

    @FXML
    private void switchToInviteCollaborator() throws IOException {
        App.setRoot("invite");
    }
}