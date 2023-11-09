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
    private Application application;
    static Path tempDir;
	
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

    @Test
    public void testSetUserOnline(){
        assertTrue(userList.addUser("Alexis", "Peters", "APeters", "ap@gmail.com", "12345", "UofSC", new Date()));
        UUID userID = userList.getUsers().get(0).getUserID();
        userList.setUserOnline(userID, true);
        assertTrue(userList.isUserOnline(userID));
    }

    //Applciation tests
    @Test
    public void testSignUp(){
        String firstName = "Alexis";
        String lastName = "Peters";
        String userName = "APeters";
        String email = "apeters@gmail.com";
        String password = "12345";
        String company = "UofSC";
        Date dateOfBirth = new Date();

        boolean signUp = application.signUp(firstName, lastName, userName, email, password, company, dateOfBirth);
        assertTrue(signUp);
    }

    @Test
    public void testLogin(){
        String userName = "APeters";
        String password = "12345";

        boolean login = application.login(userName, password);
        assertTrue(login);
    }

    @Test
    public void testLogout(){
        ArrayList<User> currUsers = application.getUserList().getUsers();
        ArrayList<Project> currProjects = application.getProjectList().getProjects();
        ArrayList<User> savedUsers = application.getUserList().getUsers();
        ArrayList<Project> savedProjects = application.getProjectList().getProjects();


        application.logout();

        application.getUserList().loadUsers();
        application.getProjectList().loadProjects();
        assertEquals(currUsers, savedUsers);
        assertEquals(currProjects, savedProjects);
    }

    @Test
    public void testAddProject(){
        Project newProject = new Project("project", "description");

        application.addProject(newProject);

        ArrayList<Project> projects = application.getProjectList().getProjects();
        assertTrue(projects.contains(newProject));
    }

    @Test
    public void testRemoveProject(){
        Project newProject = new Project("project", "description");

        application.addProject(newProject);

        boolean removed = application.removeProject("project", "description");

        assertTrue(removed);

        ArrayList<Project> projects = application.getProjectList().getProjects();
        assertFalse(projects.contains(newProject));
    }
}
