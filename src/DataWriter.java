import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
        User user = User.getInstance();
        ArrayList<User> users = user.getUsers();
        JSONArray jsonUsers = new JSONArray();
        
        // Creating JSON objects for each user
        for (int i = 0; i < users.size(); i++) {
            jsonUsers.add(getUserJSON(users.get(i));
        }
        
        // Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE)) {
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
        
        JSONArray tasksArray = new JSONArray();
        for (Tasks task : user.getTasks()) {
            tasksArray.add(task.toString());
        }
        userObject.put(USER_TASKS, tasksArray);
        
        return userObject;
    }
}
