package com.example;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ArrayList;

import com.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class AddTaskController {
    private Columns currentColumn;
    private Project currentProject; // To hold the current project

    @FXML
    private TextField taskDesc;
    @FXML
    private TextField taskDeadline;
    @FXML
    private ChoiceBox<String> assignedChoiceBox;
    @FXML
    private ChoiceBox<Integer> priorityChoiceBox;

    @FXML
    private VBox taskContainer;

    @FXML
    private VBox cardContainer;

    public void setCurrentColumn(Columns column) {
        this.currentColumn = column;
    } 

    public void setCurrentProject(Project project) {
        this.currentProject = project;
    }

    @FXML
    private void initialize() {
        populateUserChoiceBox();
        populatePriorityChoiceBox();
    }

    private void populateUserChoiceBox() {
        ArrayList<User> users = UserList.getInstance().getUsers();
        ObservableList<String> usernames = FXCollections.observableArrayList();

        for (User user : users) {
            usernames.add(user.getUserName());
        }

        assignedChoiceBox.setItems(usernames);
    }

    private void populatePriorityChoiceBox() {
        ObservableList<Integer> priorities = FXCollections.observableArrayList(1, 2, 3);
        priorityChoiceBox.setItems(priorities);
    }

    @FXML
    private void saveTask() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date deadline = null;
        try {   
            deadline = dateFormat.parse(taskDeadline.getText());
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }

        Tasks task = new Tasks(deadline, taskDesc.getText(), priorityChoiceBox.getValue(), 0, UserList.getInstance().getUser(assignedChoiceBox.getValue()), new ArrayList<>(), new ArrayList<>());

        currentColumn.addTask(task);

        // Updates project in the project list
        ArrayList<Project> allProjects = App.getProjects();
        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.get(i).getProjectID().equals(currentProject.getProjectID())) {
                allProjects.set(i, currentProject);
                break;
            }
        }

        DataWriter.saveProjects(allProjects, "src/demo/src/main/java/data/json/project.json");

        // Reloads projects and navigate back
        App.setProjects(DataLoader.loadProjects());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/openProject.fxml"));
        Parent root = loader.load();
        OpenProjectController openProjectController = loader.getController();
        openProjectController.updateProjectDetails(currentProject);

        Stage stage = (Stage) taskDesc.getScene().getWindow();
        stage.setScene(new Scene(root, 960, 540));
    }
}
