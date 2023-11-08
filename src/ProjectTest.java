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


public class ProjectTest{

    private User testUser;
    private Team testTeam;
    private Project testProject;
    private Date testDateOfBirth;
    private UUID userID;

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
    
    public void testSaveUsers(){
        ArrayList<User> testUsers = new ArrayList<>();
        testUsers.add(testUser);
        File testFile = tempDir.resolve("user-test.json").toFile();

        DataWriter.saveUsers(testUsers);
        assertTrue(testFile.exists());
    }

    public void testSaveProjects(){
        ArrayList<Project> testProjects = new ArrayList<>();
        testProjects.add(testProject);
        File testFile = tempDir.resolve("project-test.json").toFile();

        DataWriter.saveProjects(testProjects);
        assertTrue(testFile.exists());
    }

    //User tests 
   public void testJoinTeam() {
        testUser.joinTeam(testTeam);
        assertTrue(testTeam.getScrumTeamMembers().contains(testUser));
   }
    
    public void testLeaveTeam() {
        testUser.joinTeam(testTeam);
        testUser.leaveTeam(testTeam);
        assertFalse(testTeam.getScrumTeamMembers().contains(testUser));
    }

    public void testViewProjects(){
        testUser.joinTeam(testTeam);
        testTeam.addProject(testProject);
        testProject.addMember(testUser);
        
        ArrayList<Project> projects = testUser.viewProjects();
        assertTrue(projects.contains(testProject));
    }

    public void testIsOnline(){
        UUID userID = testUser.getUserID();
        UserList.getInstance().setUserOnline(userID, true);
        boolean isOnline = testUser.isOnline();
        assertTrue(isOnline);
    }

    //UserList tests

    //Applciation tests


//Marietou- DataLoader, DataConstants, Columns, Tasks



//Casey- Project, ProjectHistory, ProjectList, Comments, 
public void testAddTasks() {

    ProjectList projectList = ProjectList.getInstance();

    Date deadline = new Date();
    String taskDescription = "Sample Task";
    int priority = 1;
    double hours = 2.5;
    User assignedUser = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());
    ArrayList<Change> changes = new ArrayList<>();
    ArrayList<Comments> comments = new ArrayList<>();

    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");
    projectList.addProject(newProject);
    
    ArrayList<Project> projects = projectList.getProjects();

    newProject.addTasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);

    ArrayList<Tasks> firstColumnTasks = newProject.getColumns().get(0).getTasks();
    Tasks addedTask = firstColumnTasks.get(0);

    assertEquals(taskDescription, addedTask.getTaskDescription());
    assertEquals(assignedUser, addedTask.getAssignedUser());
}

public void testAddProject() {
    
    ProjectList projectList = ProjectList.getInstance();

    UUID projectID = UUID.randomUUID();
    String name = "Test Project";
    String description = "This is a test project";
    double rating = 0.0;
    boolean isFinished = false;
    boolean isPublic = true;
    ArrayList<Columns> columns = new ArrayList<>();
    ArrayList<User> members = new ArrayList<>();

    Project newProject = new Project(projectID, name, description, rating, isFinished, isPublic, columns, members);
    projectList.addProject(newProject);

    ArrayList<Project> projects = projectList.getProjects();

    assertEquals(1, projects.size());
}



//Laura- Team, Change, Dashboard 
}