package com.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.model.Project;
import com.model.ProjectList;

public class DashboardController {
    @FXML
    private VBox projectContainer;

    @FXML
    private StackPane containerStackPane;

    @FXML
    private VBox projectList;

    @FXML
    private void newProject() throws IOException {
        App.setRoot("newProject");
    }

    public void initialize() {
        projectContainer.setAlignment(Pos.CENTER);
        displayProjects();
    }

    private void displayProjects() {
        double buttonWidth = 0.8 * Screen.getPrimary().getVisualBounds().getWidth();
        
        ArrayList<Project> projectList = ProjectList.getInstance().getProjects();
        int index = 0;
        for (Project project : projectList) {
            Label label = new Label(project.getName());
            label.setStyle("-fx-text-fill: #000000; -fx-font-size: 16px; -fx-font-weight: bold;");
            label.setMinWidth(buttonWidth);
            label.setAlignment(Pos.CENTER_LEFT); 
            label.setMaxWidth(Double.MAX_VALUE); 

            Button button = new Button();
            button.setGraphic(label);
            button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(20), null);
            button.setBackground(new Background(backgroundFill));
            
            BorderStroke borderStroke = new BorderStroke(
                Color.web("#EFEFEF"),
                BorderStrokeStyle.SOLID, 
                new CornerRadii(20),
                new BorderWidths(1), 
                new Insets(5)
            );
            button.setBorder(new Border(borderStroke));
            
            VBox.setMargin(button, new Insets(10, 0, 0, 0));

            String buttonId = "projectButton" + index;
            button.setId(buttonId);
            VBox.setVgrow(button, Priority.ALWAYS);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    try {
                        loadProjectView(project);
                    } catch (Exception ex) {
                        System.out.println("Can't open project: " + ex.getMessage());
                    }
                }
            });

            projectContainer.getChildren().add(button);
            index++;
        }
    }

    private void loadProjectView(Project project) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/openProject.fxml"));
        Parent root = loader.load();

        OpenProjectController controller = loader.getController();
        controller.updateProjectDetails(project);

        Scene scene = new Scene(root, 960, 540);
        Stage stage = (Stage) projectContainer.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}