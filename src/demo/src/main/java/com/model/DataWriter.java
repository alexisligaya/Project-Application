package com.model;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    /**
     * Saves a list of User objects as a JSON file.
     * 
     * @param users - the ArrayList of User objects to be saved as JSON.
     */
    public static void saveUsers(ArrayList<User> users, String filePath) {
        JSONArray jsonUsers = new JSONArray();

        // Creating JSON objects for each user
        for (User user : users) {
            jsonUsers.add(getUserJSON(user));
        }

        try(FileWriter file = new FileWriter(filePath)){
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        // Write JSON file
        try (FileWriter file = new FileWriter("json/user-test.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            // file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        //Create strings for each user
        StringBuilder userString = new StringBuilder();
        for(User user : users){
            userString.append(user.toString()).append("\n");
        }

        //Write users to text file
        /*try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/ScrumBoard.txt"))){
            writer.write(userString.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }*/
    }

    /**
     * Saves a list of Project objects as a JSON that organizes projects by user ID.
     * 
     * @param projects - the ArrayList of Project objects to be saved as JSON.
     */
    public static void saveProjects(ArrayList<Project> projects, String filePath) {
        JSONArray jsonProjects = new JSONArray();

        // Creating JSON objects for each user
        // projects by userID
        for (Project project : projects) {
            jsonProjects.add(getProjectJSON(project));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter(filePath)) {

            file.write(jsonProjects.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
         StringBuilder projString = new StringBuilder();

         projString.append("\nScrumBoard\n*********************\n");

         for (Project project : projects) {
             projString.append("Project ID: ").append(project.getProjectID()).append("\n");
             projString.append("Name: ").append(project.getName()).append("\n");
             projString.append("Description: ").append(project.getDescription()).append("\n");
             projString.append("Rating: ").append(project.getRating()).append("\n");
             projString.append("Is Finished: ").append(project.getIsFinished()).append("\n");
             projString.append("Is Public: ").append(project.getIsPublic()).append("\n");
     
             for (Columns column : project.getColumns()) {
                 projString.append("Columns: ").append(column.getTitle()).append("\n");
     
                 for (Tasks task : column.getTasks()) {
                     projString.append("  Task Description: ").append(task.getTaskDescription()).append("\n");
                     projString.append("  Priority: ").append(task.getPriority()).append("\n");
                     projString.append("  Hours: ").append(task.getHours()).append("\n");
                     projString.append("  Assigned User: ").append(task.getAssignedUser() != null ? task.getAssignedUser().getUserName() : "Unassigned").append("\n");
     
                     for (Comments comment : task.getComments()) {
                         projString.append("    Comment By: ").append(comment.getCommentBy().getUserName()).append(": ").append(comment.getText()).append("\n");
                     }
                 }
             }
             projString.append("*********************\n");
         }
     
         // Write formatted project information to the ScrumBoard.txt file
         /*try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/ScrumBoard.txt"))) {
             writer.write(projString.toString());
         } catch (IOException e) {
             e.printStackTrace();
         }*/

         try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/ScrumBoard.txt", true))) {
            writer.write(projString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Parsing JSON files. Converts a User object to a JSONObject representing the
     * user's information.
     * 
     * @param user - The User object to parse.
     * @return - a JSONObject containing user information
     */
    public static JSONObject getUserJSON(User user) {
        JSONObject userObject = new JSONObject();

        userObject.put(USER_ID, user.getUserID().toString());
        userObject.put(USER_FIRST_NAME, user.getfirstName());
        userObject.put(USER_LAST_NAME, user.getLastName());
        userObject.put(USER_USERNAME, user.getUserName());
        userObject.put(USER_EMAIL, user.getEmail());
        userObject.put(USER_PASSWORD, user.getPassword());

        userObject.put(USER_COMPANY, user.getCompany());
        //userObject.put(USER_DOB, user.getDateOfBirth().toString());
        //userObject.put(USER_DOB, user.getDateOfBirth().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        String formattedDate = dateFormat.format(user.getDateOfBirth());
        userObject.put(USER_DOB, formattedDate);

        return userObject;
    }

    /**
     * COME BACK TO JAVADOC THE REST
     * Parsing JSON files. Converts a Project object to a JSONObject representing the project's information.
     * 
     * @param project - the Project object to parse
     * @return a JSONObject representing the Project object parsed
     */
    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectObject = new JSONObject();

        projectObject.put(PROJECT_ID, project.getProjectID().toString());
        projectObject.put(PROJECT_NAME, project.getName());
        projectObject.put(PROJECT_DESCRIPTION, project.getDescription());
        projectObject.put(PROJECT_RATING, project.getRating());
        projectObject.put(PROJECT_IS_FINISHED, project.getIsFinished());
        projectObject.put(PROJECT_IS_PUBLIC, project.getIsPublic());
        // projectObject.put(PROJECT_COLUMNS, project.getColumns());
        // projectObject.put(PROJECT_MEMBERS, project.getMembers());

        JSONArray membersArray = new JSONArray();
        for (User member : project.getMembers()) {
            membersArray.add(member.getUserID().toString());
        }
        JSONArray columnsArray = new JSONArray();
        for (Columns column : project.getColumns()) {
            JSONObject columnObject = new JSONObject();
            columnObject.put("title", column.getTitle());

            // Create an array for tasks
            JSONArray tasksArray = new JSONArray();
            
            for (Tasks task : column.getTasks()) {
                JSONObject taskObject = new JSONObject();
                //taskObject.put("deadline", task.getDeadline().toString());

              

                taskObject.put("taskDescription", task.getTaskDescription());
                taskObject.put("priority", task.getPriority());
                taskObject.put("hours", task.getHours());

                // Create an array for comments
                JSONArray commentsArray = new JSONArray();
                for (Comments comment : task.getComments()) {
                    JSONObject commentObject = new JSONObject();
                    commentObject.put("date", comment.getDate().toString());
                    commentObject.put("text", comment.getText());
                    commentObject.put("commentBy", comment.getCommentBy().getUserName());

                    commentsArray.add(commentObject);

                }
                JSONArray changesArray = new JSONArray();
                for (Change change : task.getChanges()) {
                    JSONObject changeObject = new JSONObject();
                    changeObject.put("description", change.getDescription().toString());
                    changeObject.put("date", change.getDate().toString());
                    if(change.getUser() != null){
                        changeObject.put("user", change.getUser().toString());
                    }
                    if(change.getProject() != null){
                        changeObject.put("project", change.getProject().toString());
                    }

                    changesArray.add(changeObject);
                }

                taskObject.put("comments", commentsArray);
                taskObject.put("changes", changesArray);

                tasksArray.add(taskObject);
            }

            columnObject.put("tasks", tasksArray);
            columnsArray.add(columnObject);
        }

        projectObject.put(PROJECT_COLUMNS, columnsArray);
        return projectObject;
    }

    public static void writeChanges(String changelog) {
        /*try (FileWriter file = new FileWriter("src/ScrumBoard.txt")) {
            file.write(changelog);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileWriter file = new FileWriter("src/ScrumBoard.txt", true)) {
            file.write(changelog);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
