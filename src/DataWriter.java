import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

    public static void main(String[] args){
        saveUsers();
    }
}
