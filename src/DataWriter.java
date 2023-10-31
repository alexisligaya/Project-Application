import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers(ArrayList<User> users) {
        JSONArray jsonUsers = new JSONArray();
        
        // Creating JSON objects for each user
        for (User user : users) {
            jsonUsers.add(getUserJSON(user));
        }
        
        // Write JSON file
        try (FileWriter file = new FileWriter("json/user-test.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveProjects(ArrayList<Project> projects) {
        JSONArray jsonProjects = new JSONArray();
        
        //Creating JSON objects for each user
        for (Project project : projects) {
            jsonProjects.add(getProjectJSON(project));
        }

        // Write JSON file
        try (FileWriter file = new FileWriter("json/project.json")) {
            file.write(jsonProjects.toJSONString());
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
        //projectObject.put(PROJECT_COLUMNS, project.getColumns());
        //projectObject.put(PROJECT_MEMBERS, project.getMembers());

        JSONArray membersArray = new JSONArray();
        for(User member : project.getMembers()){
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
                        commentObject.put("commentBy", comment.getCommentBy().getUserName());

                        commentsArray.add(commentObject);

                    }
                    JSONArray changesArray = new JSONArray();
                    for(Change change : task.getChanges()){
                        JSONObject changeObject = new JSONObject();
                        changeObject.put("description", change.getDescription().toString());
                        changeObject.put("date", change.getDate().toString());
                        changeObject.put("user", change.getUser().toString());
                        changeObject.put("project", change.getProject().toString());

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

            return projectObject;
    }

    public static void main(String[] args) {
        // Hardcode user
        ArrayList<User> users = UserList.getInstance().getUsers();
        User user1 = new User( 
            UUID.randomUUID(),
            "Johnasd", 
            "Doe", 
            "JohnnyD", 
            "JD101@gmail.com",
            "JD10101", 
            new Date());
        users.add(user1);
        saveUsers(users);
    
        // Hardcode project
        ArrayList<Project> projects = ProjectList.getInstance().getProjects();
    
        boolean projectExists = false;
        String newProjectName = "Flappy Birds"; // Change this to the desired new project name
    
        for (Project project : projects) {
            if (project.getName().equals(newProjectName)) {
                projectExists = true;
                break;
            }
        }
    
        if (!projectExists) {
            // Create a new project only if a project with the given name doesn't exist
            ArrayList<User> projectUsers = new ArrayList<>();
            projectUsers.add(user1);
            
            ArrayList<Columns> columns = new ArrayList<>();
            // Other project setup steps...
    
            Project newProject = new Project(
                UUID.randomUUID(),
                newProjectName,
                "Description of the new project", // Add description here
                7.5, // Rating or other project details
                false,
                false,
                columns,
                projectUsers
            );
    
            projects.add(newProject);
            saveProjects(projects);
        }
    }
    
    
}

