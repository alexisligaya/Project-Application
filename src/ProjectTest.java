import java.beans.Transient;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectTest{


    @Test
    public void testing(){

    }

    @BeforeClass
	public static void oneTimeSetup() {
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}



//Alexis- DataWriter, User, UserList, Application
    class UserTest{
        User user;
        Team team;
        Date dateOfBirth;
        UUID userID;


    @Test
    void setUp(){
        dateOfBirth = new Date();
        userID = UUID.randomUUID();
        user = new User(userID, "Test", "user", "testuser", "test@email.com", "password", "company", dateOfBirth);

        team = new Team();
    }
    }


//Marietou- DataLoader, DataConstants, Columns, Tasks



//Casey- Project, ProjectHistory, ProjectList, Comments, 
public void testAddProject() {
    ProjectList projectList = ProjectList.getInstance();

    // Testing information
    UUID projectID = UUID.randomUUID();
    String name = "Test Project";
    String description = "This is a test project";
    double rating = 0.0;
    boolean isFinished = false;
    boolean isPublic = true;
    ArrayList<Columns> columns = new ArrayList<>(); // Empty
    ArrayList<User> members = new ArrayList<>();

    // Create a new project
    Project newProject = new Project(projectID, name, description, rating, isFinished, isPublic, columns, members);
    projectList.addProject(newProject);

    // Retrieve the list of projects
    ArrayList<Project> projects = projectList.getProjects();

    // Assertions
    assertEquals(1, projects.size());
}



//Laura- Team, Change, Dashboard 
}