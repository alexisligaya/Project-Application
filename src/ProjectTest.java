import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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


//Marietou- DataLoader, DataConstants, Columns, Tasks



//Casey- Project, ProjectHistory, ProjectList, Comments, 
public void testAddTasks() {

    Date deadline = new Date();
    String taskDescription = "Sample Task";
    int priority = 1;
    double hours = 2.5;
    User assignedUser = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "wow101", "Microsoft", new Date());
    ArrayList<Change> changes = new ArrayList<>();
    ArrayList<Comments> comments = new ArrayList<>();

    // Call the addTasks method
    Project.addTasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);

    // Retrieve the first column's tasks and verify the added task
    ArrayList<Tasks> firstColumnTasks = Project.getColumns().get(0).getTasks();
    Tasks addedTask = firstColumnTasks.get(0);

    // Assert that the added task has the same properties as expected
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
    ArrayList<Columns> columns = new ArrayList<>(); // Empty
    ArrayList<User> members = new ArrayList<>();

    Project newProject = new Project(projectID, name, description, rating, isFinished, isPublic, columns, members);
    projectList.addProject(newProject);

    ArrayList<Project> projects = projectList.getProjects();

    // Assertion
    assertEquals(1, projects.size());
}




//Laura- Team, Change, Dashboard 
}