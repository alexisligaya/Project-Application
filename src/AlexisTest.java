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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;

public class AlexisTest {
    private User testUser;
    private Team testTeam;
    private Project testProject;
    private UUID userID;
    private UserList userList;

    @Test
    public static void testing(){

    }
	
	@BeforeEach
	public void setup() {
		//runs before each test
        userID = UUID.randomUUID();
        testUser = new User(userID, "test", "user", "testUser","user@gmail.com", "password", "company", new Date());
        testTeam = Team.getInstance();
        testProject = new Project("name", "description");
	}
	
    //Alexis- DataWriter, User, UserList, Application
    
    //DataWriter tests
    static Path tempDir;
    
    @Test
    public void testSaveUsers(){
        ArrayList<User> testUsers = new ArrayList<>();
        testUsers.add(testUser);
        File testFile = tempDir.resolve("user-test.json").toFile();

        DataWriter.saveUsers(testUsers);
        assertTrue(testFile.exists());
    }

    @Test
    public void testSaveProjects(){
        ArrayList<Project> testProjects = new ArrayList<>();
        testProjects.add(testProject);
        File testFile = tempDir.resolve("project-test.json").toFile();

        DataWriter.saveProjects(testProjects);
        assertTrue(testFile.exists());
    }

    //User tests 
    @Test
    public void testJoinTeam() {
        testUser.joinTeam(testTeam);
        assertTrue(testTeam.getScrumTeamMembers().contains(testUser));
    }
    
    @Test
    public void testLeaveTeam() {
        testUser.joinTeam(testTeam);
        testUser.leaveTeam(testTeam);
        assertFalse(testTeam.getScrumTeamMembers().contains(testUser));
    }

    @Test
    public void testViewProjects(){
        testUser.joinTeam(testTeam);
        testTeam.addProject(testProject);
        testProject.addMember(testUser);
        
        ArrayList<Project> projects = testUser.viewProjects();
        assertTrue(projects.contains(testProject));
    }

    @Test
    public void testIsOnline(){
        UUID userID = testUser.getUserID();
        UserList.getInstance().setUserOnline(userID, true);
        boolean isOnline = testUser.isOnline();
        assertTrue(isOnline);
    }

    //UserList tests
    @Test
    public void testAddUser(){
        assertTrue(userList.addUser("Alexis", "Peters", "APeters", "ap@gmail.com", "12345", "UofSC", new Date()));
        assertTrue(userList.isUserOnline(userList.getUsers().get(0).getUserID()));
    }

    public void testSetUserOnline(){
        assertTrue(userList.addUser("Alexis", "Peters", "APeters", "ap@gmail.com", "12345", "UofSC", new Date()));
        UUID userID = userList.getUsers().get(0).getUserID();
        userList.setUserOnline(userID, true);
        assertTrue(userList.isUserOnline(userID));
    }

    //Applciation tests
    

}
