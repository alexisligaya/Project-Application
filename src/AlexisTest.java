import java.beans.Transient;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AlexisTest {
    private User testUser;
    private Team testTeam;
    private Project testProject;
    private UUID userID;
    private UserList userList;
    private Application application;
    @TempDir
    Path tempDir;
	
	@BeforeEach
	public void setup() {
		//runs before each test
        userID = UUID.randomUUID();
        testUser = new User(userID, "test", "user", "testUser","user@gmail.com", "password", "company", new Date());
        testTeam = Team.getInstance();
        testProject = new Project("name", "description");
        userList = UserList.getInstance();
        application = new Application();
	}
	
    //Alexis- DataWriter, User, UserList, Application
    
    //DataWriter tests
    @Test
    //tests that list of users saves to json file
    public void testSaveUsers(){
        ArrayList<User> testUsers = new ArrayList<>();
        testUsers.add(testUser);
        File testFile = tempDir.resolve("user-test.json").toFile();

        //saves users to file
        DataWriter.saveUsers(testUsers, testFile.getAbsolutePath());

        //checks if file exists
        assertTrue(testFile.exists());

    }

    @Test
    //tests that list of projects svae to json file
    public void testSaveProjects(){
        ArrayList<Project> testProjects = new ArrayList<>();
        testProjects.add(testProject);
        File testFile = tempDir.resolve("project-test.json").toFile();
       
        //saves projects to file
        DataWriter.saveProjects(testProjects, testFile.getAbsolutePath());

        //checks if file exists
        assertTrue(testFile.exists());
    }

    //User tests 
    @Test
    public void testJoinTeam() {
        //tests if user joins team
        testUser.joinTeam(testTeam);

        //checks if user joined list of team members
        assertTrue(testTeam.getScrumTeamMembers().contains(testUser));
    }
    
    @Test
    public void testLeaveTeam() {
        //user joins and leaves team
        testUser.joinTeam(testTeam);
        testUser.leaveTeam(testTeam);

        //checks that user is not in list of team members
        assertFalse(testTeam.getScrumTeamMembers().contains(testUser));
    }

    @Test
    public void testViewProjects(){
        //user views projects in a team 
        testUser.joinTeam(testTeam);
        testTeam.addProject(testProject);
        testProject.addMember(testUser);
        
        //project that user can view
        ArrayList<Project> projects = testUser.viewProjects();

        //check that project is in the list
        assertTrue(projects.contains(testProject));
    }

    @Test
    public void testIsOnline(){
        //sets user as online
        UUID userID = testUser.getUserID();
        UserList.getInstance().setUserOnline(userID, true);
        boolean isOnline = testUser.isOnline();
        assertTrue(isOnline);
    }

    //UserList tests
    @Test
    public void testAddUser(){
        //adds user to the user list
        assertTrue(userList.addUser("Alexis", "Peters", "APeters", "ap@gmail.com", "12345", "UofSC", new Date()));
       
       //checks that the added user is online
        UUID newUserId = userList.getUsers().get(userList.getUsers().size() - 1).getUserID();

        userList.setUserOnline(newUserId, true);
        assertTrue(userList.isUserOnline(newUserId));
    }

    @Test
    public void testSetUserOnline(){
       
        UUID userID = userList.getUsers().get(userList.getUsers().size()-1).getUserID();
        System.out.println("userID not online: " + userID);
        
        userList.setUserOnline(userID, true);
        System.out.println("userID online: " + userID);

        // print onlineUsers 
        System.out.println("Online Users: " + userList.getUserOnline());

        //checks that user is online
        assertTrue(userList.isUserOnline(userID));
    }

    //Applciation tests
    @Test
    public void testSignUp(){

        Application application = new Application();

        //test user info
        String firstName = "Alexis";
        String lastName = "Peters";
        String userName = "APeters";
        String email = "apeters@gmail.com";
        String password = "12345";
        String company = "UofSC";
        Date dateOfBirth = new Date();

        //checks for succesfull signup
        boolean signUp = application.signUp(firstName, lastName, userName, email, password, company, dateOfBirth);
        assertTrue(signUp);
    }

    @Test
    public void testDuplicateUser(){
        //creates two new users with the same username and password
        boolean user1 = userList.addUser("Alexis", "Peters", "APeters", "APeters@gmail.com", "12345", "UofSC", new Date());
        boolean user2 = userList.addUser("Alexis", "Peters", "APeters", "APeters@gmail.com", "12345", "UofSC", new Date());

        assertTrue(user1);
        assertFalse(user2);
    }

    @Test
    public void testLogin(){
        //user login info
        String userName = "APeters";
        String password = "12345";

        //checks for successfull login
        boolean login = application.login(userName, password);
        assertTrue(login);
    }

    @Test
    public void testIncorrectPasswrord(){
        //user login info
        String userName = "APeters";
        String password = "incorrect";

        //incorrect password
        boolean login = application.login(userName, password);

        //login fails
        assertFalse(login);
    }

    @Test
    public void testLogout(){
        ArrayList<User> currUsers = application.getUserList().getUsers();
        ArrayList<Project> currProjects = application.getProjectList().getProjects();
        ArrayList<User> savedUsers = application.getUserList().getUsers();
        ArrayList<Project> savedProjects = application.getProjectList().getProjects();

        //user logs out
        application.logout();

        //loads user and projects
        application.getUserList().loadUsers();
        application.getProjectList().loadProjects();

        //checks that there are no changes to user and project list
        assertEquals(currUsers, savedUsers);
        assertEquals(currProjects, savedProjects);
    }

    @Test
    public void testLoginToLogout(){
        //user logs out
        application.logout();
        //user logs in again
        boolean loginToLogout = application.login("APeters", "12345");
        assertTrue(loginToLogout);
    }

    @Test
    public void testAddProject(){
        //new project info
        Project newProject = new Project("project", "description");

        //project added 
        application.addProject(newProject);

        ArrayList<Project> projects = application.getProjectList().getProjects();

        //checks whether new project is in the list
        assertTrue(projects.contains(newProject));
    }

    @Test
    public void testRemoveProject(){
        Project newProject = new Project("project", "description");

        //adds then removes project
        application.addProject(newProject);
        boolean removed = application.removeProject("project", "description");

        //checks whether project was removed from project list
        assertTrue(removed);
        ArrayList<Project> projects = application.getProjectList().getProjects();
        assertFalse(projects.contains(newProject));
    }
}

