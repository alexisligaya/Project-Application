package com.model;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

	/**
	 * Loads a list of User objects from a JSON file
	 * 
	 * @return an ArrayList of User objects
	 */
	public static ArrayList<User> loadUsers() {

		ArrayList<User> users = new ArrayList<User>();

		try (FileReader reader = new FileReader("src/demo/src/main/java/data/json/user-test.json")) {
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray) parser.parse(reader);

			for (int i = 0; i < usersJSON.size(); i++) {
				JSONObject personJSON = (JSONObject) usersJSON.get(i);
				UUID userID = UUID.fromString((String) personJSON.get(USER_ID));
				String firstName = (String) personJSON.get(USER_FIRST_NAME);
				String lastName = (String) personJSON.get(USER_LAST_NAME);
				String username = (String) personJSON.get(USER_USERNAME);
				String email = (String) personJSON.get(USER_EMAIL);
				String password = (String) personJSON.get(USER_PASSWORD);
				String company = (String) personJSON.get(USER_COMPANY);
				Date dob = stringToDate((String) personJSON.get(USER_DOB));

				users.add(new User(userID, firstName, lastName, username, email, password, company, dob));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		return users;
	}

	/**
	 * Parses a string representation of a date and returns a Date object
	 * 
	 * @param dateText - a string representing a date
	 * @return a Date object representing the parsed date, or null if parsing fails
	 */
	public static Date stringToDate(String dateText) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Corrected the date format pattern
		try {
			Date date = dateFormat.parse(dateText);
			return date;
		} catch (ParseException e) {
			e.printStackTrace(); // Handle parsing errors by printing or logging the exception
			return null;
		}
	}

	/**
	 * Loads a list of Project objects from a JSON file
	 * 
	 * @return an ArrayList of Project objects
	 */
	public static ArrayList<Project> loadProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();

		try {
			FileReader reader = new FileReader("src/demo/src/main/java/data/json/project.json");
			JSONParser parser = new JSONParser();
			JSONArray projectJSON = (JSONArray) new JSONParser().parse(reader);

			// convert string projectID to uuid
			for (int i = 0; i < projectJSON.size(); i++) {
				JSONObject projectDataa = (JSONObject) projectJSON.get(i);
				UUID projectID = UUID.fromString((String) projectDataa.get(PROJECT_ID));
				String name = (String) projectDataa.get(PROJECT_NAME);
				String description = (String) projectDataa.get(PROJECT_DESCRIPTION);
				double rating = (double) projectDataa.get(PROJECT_RATING);
				boolean isFinished = (boolean) projectDataa.get(PROJECT_IS_FINISHED);
				boolean isPublic = (boolean) projectDataa.get(PROJECT_IS_PUBLIC);
				
				JSONArray columnsJSON = (JSONArray)projectDataa.get(PROJECT_COLUMNS);
				ArrayList<Columns> columns = new ArrayList<>();
				if (columnsJSON != null) {
					for (Object columnObj : columnsJSON) {
						JSONObject columnJSON = (JSONObject) columnObj;
						String title = (String) columnJSON.get("title"); // Assuming "title" is the key in your JSON
						// Assuming no tasks for now or tasks can be handled similarly
						//columns.add(new Columns(title));

						JSONArray tasksJSON = (JSONArray) columnJSON.get("tasks");
						ArrayList<Tasks> tasks = new ArrayList<>();
						if (tasksJSON != null) {
                        for (Object taskObj : tasksJSON) {
                            JSONObject taskJSON = (JSONObject) taskObj;
                            String taskDescription = (String) taskJSON.get("taskDescription"); // Assuming the key in your JSON
                            tasks.add(new Tasks(taskDescription)); // Create and add tasks to the column
                        	}
                    	}

						columns.add(new Columns(title, tasks)); 
					}
				}

				ArrayList<User> members = new ArrayList<>();
				Project testProj = new Project(projectID, name, description, rating, isFinished, isPublic, columns, members);
				projects.add(testProj);
				
			}

			return projects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		ArrayList<User> users = loadUsers();
		for (User user : users) {
			System.out.println(user);
		}

		// same thing
		ArrayList<Project> projects = loadProjects();
		for (Project project : projects) {
			System.out.println(project);
		}
	}
}