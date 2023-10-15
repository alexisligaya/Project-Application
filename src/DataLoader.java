import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
    public static ArrayList<User> loadPeople() {
		ArrayList<User> user = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE);
			JSONParser parser = new JSONParser();
			JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < userJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)userJSON.get(i);
				String userID = (String)userJSON.get(USER_ID);
				String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String username = (String)userJSON.get(USER_USERNAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String password = (String)userJSON.get(USER_PASSWORD);
                Date dob = (Date)userJSON.get(USER_DOB);
                ArrayList<Tasks> userTasks = (ArrayList<Tasks>)userJSON.get(USER_TASKS);

				
				user.add(new User(userID, firstName, lastName, username, email, password, dob, userTasks));
			}
			
			return people;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}