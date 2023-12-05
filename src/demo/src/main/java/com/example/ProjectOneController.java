package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.model.*;

import javafx.fxml.FXML;

public class ProjectOneController {

    @FXML
    private void newProject() throws IOException {
        App.setRoot("newColumn");
    }
}
