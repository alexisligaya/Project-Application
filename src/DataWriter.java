import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        // User user = User.getInstance();                      (don't delete, will need later)!!!!!!!
        // ArrayList<User> users = user.getUsers();
        
        //hardcoding some users for testing purposes
        ArrayList<User> users = new ArrayList<>();
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
        
        // JSONArray tasksArray = new JSONArray();                 (don't delete, will need later)!!!!!!
        // for (Tasks task : user.getTasks()) {
        //     tasksArray.add(task.toString());
        // }
        // userObject.put(USER_TASKS, tasksArray);
        
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
        projectObject.put(PROJECT_COLUMN_LIST, project.getColumnList());
        projectObject.put(PROJECT_MEMBERS, project.getMembers());

        return projectObject;
    }

    public static void saveProjects() {
        
        //hardcode for testing
        ArrayList<User> projects = new ArrayList<>();
        // this.projectID= projectID;
        // this.name = name;
        // this.description = description;
        // this.rating= rating;
        // this.isFinished= isFinished;
        // this.isPublic = isPublic;
        // this.columnList= columnList;
        // this.members= members;
        ArrayList<Columns> columns = new ArrayList<Columns>();
        ArrayList<User> users = new ArrayList<User>();
        Project proj1 = new Project(UUID.randomUUID(),"Flappy Bird", "Developing an app made for entertainment purposes", 6.5, false, false, columns, users);
        Project proj2 = new Project(UUID.randomUUID(),"Crossy Road", "Developing an app made for entertainment purposes", 9.9, false, false, columns, users);
        projects.add(proj1);
        projects.add(proj2);

        JSONArray jsonProjects = new JSONArray();
        
        // Creating JSON objects for each user
        for (int i = 0; i < projects.size(); i++) {
            jsonProjects.add(getUserJSON(projects.get(i)));
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
    }
}
