import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
    public static ArrayList<User> loadUsers() {
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
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Project> loadProjects(){
		ArrayList<Project> projects = new ArrayList<Project>();

		try{
			FileReader reader = new FileReader("json/project.json");
			JSONParser parser = new JSONParser();
			JSONArray projectJSON = new JSONParsers();

			for(int i = 0; i < projectJSON.size(); i++){
				JSONObject projectDataa = (JSONObject) projectJSON.get(i);
				String projectID = (String)projectJSON.get(PROJECT_ID);
				String name = (String)projectJSON.get(PROJECT_NAME);
				String description= (String)projectJSON.get(PROJECT_DESCRIPTION);
				float rating = (float)projectJSON.get(PROJECT_RATING);
				boolean isFinished = (boolean)projectJSON.get(PROJECT_IS_FINISHED);
				boolean isPublic = (boolean)projectJSON.get(PROJECT_IS_PUBLIC);
				JSONArray columnList = (JSONArray)projectJSON.get(PROJECT_COLUMN_LIST);
				
				projects.add(new Project(projectID, name, description, rating, isFinished, isPublic, columnList));
			}
			return projects;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}