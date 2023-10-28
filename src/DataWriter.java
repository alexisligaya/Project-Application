import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        //hardcoding some users for testing purposes
        ArrayList<User> users = new ArrayList<>();
        //JSONObject columnList = 
        User user1 = new User( "John", "Doe", "JohnnyD", "JD101@gmail.com", "JD10101", new Date());
        User user2 = new User( "Jane", "Doe", "JaneDoe123", "Doe123@gmail.com", "JaneLovesCats", new Date());
        User user3 = new User( "Casey", "Vu", "CaseyVuDoo", "Vu001@gmail.com", "Casey123@", new Date());
        users.add(user1);
        users.add(user2);
        users.add(user3);

        JSONArray jsonUsers = new JSONArray();
        
        // Creating JSON objects for each user
        for (int i = 0; i < users.size(); i++) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }
        
        // Write JSON file
        try (FileWriter file = new FileWriter("json/user-test.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JSONObject getUserJSON(User user) {
        JSONObject userObject = new JSONObject();

        userObject.put(USER_ID, user.getUserID().toString());
        userObject.put(USER_FIRST_NAME, user.getfirstName());
        userObject.put(USER_LAST_NAME, user.getLastName());
        userObject.put(USER_USERNAME, user.getUserName());
        userObject.put(USER_EMAIL, user.getEmail());
        userObject.put(USER_PASSWORD, user.getPassword());
        userObject.put(USER_DOB, user.getDateOfBirth().toString());
        
        return userObject;
    }

    public static JSONObject getProjectJSON(Project project) {
        JSONObject projectObject = new JSONObject();

        projectObject.put(PROJECT_ID, project.getProjectID().toString());
        projectObject.put(PROJECT_NAME, project.getName());
        projectObject.put(PROJECT_DESCRIPTION, project.getDescription());
        projectObject.put(PROJECT_RATING, project.getRating());
        projectObject.put(PROJECT_IS_FINISHED, project.getIsFinished());
        projectObject.put(PROJECT_IS_PUBLIC, project.getIsPublic());
        projectObject.put(PROJECT_COLUMNS, project.getColumns());
        projectObject.put(PROJECT_MEMBERS, project.getMembers());

         //here

        return projectObject;
    }

    public static void saveProjects() {
        
        //hardcode for testing
        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Columns> columns = new ArrayList<Columns>();
        ArrayList<User> users = new ArrayList<User>();

        Project proj1 = new Project(UUID.randomUUID(),"Flappy Bird", "Developing an app made for entertainment purposes", 6.5, false, false, columns, users);
        Project proj2 = new Project(UUID.randomUUID(),"Crossy Road", "Developing an app made for entertainment purposes", 9.9, false, false, columns, users);
        projects.add(proj1);
        projects.add(proj2);

        JSONArray jsonProjects = new JSONArray();
        
        // Creating JSON objects for each user
        for (int i = 0; i < projects.size(); i++) {
           // jsonProjects.add(getProjectJSON(projects.get(i)));
            JSONObject projectObject = new JSONObject();
            projectObject.put("projectID", projects.get(i).getProjectID());
            projectObject.put("name", projects.get(i).getName());
            projectObject.put("description", projects.get(i).getDescription());
            projectObject.put("rating", projects.get(i).getRating());
            projectObject.put("public", projects.get(i).getIsPublic());
            projectObject.put("isFinished", projects.get(i).getIsFinished());

            JSONArray membersArray = new JSONArray();
            for(User member : projects.get(i).getMembers()){
                membersArray.add(member.getUserID());
            }
            

    
            JSONArray columnsArray = new JSONArray();
            for (Columns column : projects.get(i).getColumns()) {
                JSONObject columnObject = new JSONObject();
                columnObject.put("title", column.getTitle());

                // Create an array for tasks
                JSONArray tasksArray = new JSONArray();
                for (Tasks task : column.getTasks()) {
                    JSONObject taskObject = new JSONObject();
                    taskObject.put("deadline", task.getDeadline().toString());
                    taskObject.put("taskDescription", task.getTaskDescription());
                    taskObject.put("priority", task.getPriority());
                    taskObject.put("hours", task.getHours());

                    // Create an array for comments
                    JSONArray commentsArray = new JSONArray();
                    for (Comments comment : task.getComments()) {
                        JSONObject commentObject = new JSONObject();
                        commentObject.put("date", comment.getDate().toString());
                        commentObject.put("text", comment.getText());
                        commentObject.put("commentBy", comment.getCommentBy());

                        commentsArray.add(commentObject);

                    }
                    JSONArray changesArray = new JSONArray();
                    for(Change change : task.getChanges()){
                        JSONObject changeObject = new JSONObject();
                        changeObject.put("description", change.getDescription().toString());
                        changeObject.put("date", change.getDate());
                        changeObject.put("user", change.getUser());
                        changeObject.put("project", change.getProject());

                        changesArray.add(changeObject);
                    }

                    taskObject.put("comments", commentsArray);
                    taskObject.put("changes", changesArray);
                    
                    tasksArray.add(taskObject);
                }

                columnObject.put("tasks", tasksArray);
                columnsArray.add(columnObject);
            }
            projectObject.put("members", membersArray);
            projectObject.put("columnList", columnsArray);
            jsonProjects.add(projectObject);
        }
    

        // Write JSON file
        try (FileWriter file = new FileWriter("json/project.json")) {
            file.write(jsonProjects.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        saveUsers();
        saveProjects();
    }
}

