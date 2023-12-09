package com.example;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;
import com.model.User;
import com.model.UserList;
import com.model.Application;
import com.model.Project;

public class NewProjectController {
    @FXML
    private TextField projTitle;
    @FXML
    private TextField projDesc;
    @FXML
    private CheckBox isPublic;
    @FXML
    private CheckBox isFinished;
    @FXML
    private ChoiceBox<String> addCollaborator;


    @FXML
    private void initialize() {
        populateUserChoiceBox();
    }

    private void populateUserChoiceBox() {
        ArrayList<User> users = UserList.getInstance().getUsers();
        ObservableList<String> usernames = FXCollections.observableArrayList();

        for (User user : users) {
            usernames.add(user.getUserName());
        }

        addCollaborator.setItems(usernames);
    }

    @FXML
    private void saveNewProject() throws IOException {
        Application application = Application.getInstance();
        Project project = new Project(projTitle.getText(), projDesc.getText());
        project.setPublic(isPublic.isSelected()); 
        project.setFinished(isFinished.isSelected());
        application.addProject(project);

        App.setRoot("dashboard");
    }


}
