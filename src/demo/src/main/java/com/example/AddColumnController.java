package com.example;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import com.model.*;

public class AddColumnController {

    @FXML
    private TextField colTitle;
    @FXML
    private Button columnBack;
    @FXML
    private Button saveColumn;

    private Project currentProject;

    private OpenProjectController openProjectController;

    public void setCurrentProject(Project project) {
        this.currentProject = project;
    }

    @FXML
    private void saveNewColumn() throws IOException {
       
        currentProject.addColumns(colTitle.getText());
        ArrayList<Project> allProjects = App.getProjects();
        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.get(i).getProjectID().equals(currentProject.getProjectID())) {
                allProjects.set(i, currentProject);
                break;
            }
        }
   
        DataWriter.saveProjects(allProjects, "src/demo/src/main/java/data/json/project.json");

        App.setProjects(DataLoader.loadProjects());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/openProject.fxml"));
        Parent root = loader.load();
        OpenProjectController openProjectController = loader.getController();
        openProjectController.updateProjectDetails(currentProject);

        // Sets new scene on the current stage
        Stage stage = (Stage) colTitle.getScene().getWindow();
        stage.setScene(new Scene(root, 960, 540));

        //App.setRoot("openProject");
    }
    

}
