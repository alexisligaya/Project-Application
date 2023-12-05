package com.example;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;
import com.model.*;

public class NewColumnController {
    
    @FXML
    private TextField colTitle;

    @FXML
    private void saveNewColumn() throws IOException {
        //how to link to existing proj instead of making a new one
        Application application = Application.getInstance();
        Project project = new Project(projTitle.getText(), projDesc.getText());

        Columns columns = new Columns(colTitle.getText());

        project.addColumns(columns.getTitle());
    }

}
