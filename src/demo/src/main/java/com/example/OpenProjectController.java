package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.model.Project;
import com.model.Tasks;
import com.model.Columns;

public class OpenProjectController {

    @FXML
    private HBox columnContainer;

    @FXML
    private Label projID;

    @FXML
    private Button addColumnBtn;

    private Project currentProject;

    public void updateProjectDetails(Project project) {
        this.currentProject = project;
        projID.setText(project.getName());
        displayColumns();
    }

    @FXML
    private void initialize() {
        addColumnBtn.setStyle(
        "-fx-background-color: white; " +
        "-fx-text-fill: black; " +
        "-fx-font-size: 24px; " +
        "-fx-padding: 10; " +
        "-fx-border-radius: 50%; " +
        "-fx-background-radius: 50%;" +
        "-fx-min-width: 50px; " + 
        "-fx-min-height: 50px; " + 
        "-fx-max-width: 50px; " + 
        "-fx-max-height: 50px;"   
        );

        HBox.setHgrow(columnContainer, Priority.ALWAYS);
    
    }

    @FXML
    private void addColumn() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/addColumn.fxml"));
            Parent root = loader.load();

            AddColumnController controller = loader.getController();
            controller.setCurrentProject(currentProject);

            // Get the current stage from an existing component (like projID)
            Stage stage = (Stage) projID.getScene().getWindow();
            
            // Set the new scene on the current stage
            Scene scene = new Scene(root, 960, 540);
            stage.setScene(scene);

        } catch (IOException ex) {
            System.out.println("Error loading Add Column view: " + ex.getMessage());
            // Handle the error appropriately
        }
    }

    private void loadAddColumnView(Project project) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/addColumn.fxml")); // Adjust the path
        Parent root = loader.load();
    
        AddColumnController controller = loader.getController();
        controller.setCurrentProject(project);
    
        Scene scene = new Scene(root, 960, 540);
        Stage stage = new Stage(); // Create a new stage if it's a new window or use existing stage
        stage.setScene(scene);
        stage.show();
    }

    private void loadAddTaskView(Columns column) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/addTask.fxml"));
            Parent root = loader.load();

            AddTaskController controller = loader.getController();
            controller.setCurrentColumn(column);
            controller.setCurrentProject(currentProject);

            Scene scene = addColumnBtn.getScene(); // Assuming addColumnBtn is within the same scene
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayColumns() {
       //columnContainer.getChildren().clear(); //Clear existing content
       double colWidth = 0.05 * Screen.getPrimary().getVisualBounds().getWidth();
       double colHeight = 0.8 * Screen.getPrimary().getVisualBounds().getHeight();

        columnContainer.setAlignment(Pos.CENTER); // Center children horizontally
        columnContainer.setSpacing(20); // Set spacing between columns
        HBox.setHgrow(columnContainer, Priority.ALWAYS); // Grow horizontally as needed

       for (Columns column : currentProject.getColumns()) {
        // Create an AnchorPane for each column
        AnchorPane columnPane = new AnchorPane();
        columnPane.setPrefSize(colWidth, colHeight); // Adjust size as needed
        columnPane.setStyle("-fx-background-color: white; -fx-background-radius: 10px; -fx-padding: 10;");

        HBox.setHgrow(columnPane, Priority.ALWAYS); // Allow each column to grow as needed

        // Create an AnchorPane for the title area
        AnchorPane titleArea = new AnchorPane();
        titleArea.setPrefWidth(colWidth); // Same width as the column
        titleArea.setStyle("-fx-background-color: white; -fx-background-radius: 10px 10px 0 0;");
        AnchorPane.setTopAnchor(titleArea, 0.0); // Set top anchor for the title area
        AnchorPane.setLeftAnchor(titleArea, 0.0); // Set left anchor for the title area
        columnPane.getChildren().add(titleArea);

        // Add a label for the column title
        Label columnTitle = new Label(column.getTitle());
        columnTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        AnchorPane.setTopAnchor(columnTitle, 5.0); // Set top anchor for the title label
        AnchorPane.setLeftAnchor(columnTitle, 15.0); // Set left anchor for the title label
        titleArea.getChildren().add(columnTitle);

        // Add tasks to the column
        double taskPositionY = 40.0; // Starting Y position for the first task
        for (Tasks task : column.getTasks()) {
            Label taskLabel = new Label(task.getTaskDescription());
            AnchorPane.setTopAnchor(taskLabel, taskPositionY); // Position each task label
            AnchorPane.setLeftAnchor(taskLabel, 5.0);
            taskPositionY += 20.0; // Increment Y position for the next task
            columnPane.getChildren().add(taskLabel);
        }

        // Add "Add Task" button to the bottom right of the column
        Button addTaskButton = new Button("Add Task");
        addTaskButton.setStyle(
            "-fx-background-color: #EDEDED; " +
            "-fx-text-fill: black; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 5px 10px; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px;"
        );

        addTaskButton.setOnAction(e -> {
            try {
                loadAddTaskView(column); // Assuming loadAddTaskView is implemented
            } catch (IOException ex) {
                ex.printStackTrace(); // Handle exception appropriately
            }
        });

        AnchorPane.setBottomAnchor(addTaskButton, 10.0); // Adjust the position as needed
        AnchorPane.setRightAnchor(addTaskButton, 10.0); // Adjust the position as needed
        columnPane.getChildren().add(addTaskButton);
        columnContainer.getChildren().add(columnPane);
    }
}

}