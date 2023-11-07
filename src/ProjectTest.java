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
import org.junit.jupiter.api.SetUp;

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
    
    //User
    @SetUp
    public static void setUp() {
        User user;
        Team team;
        Date dateOfBirth;
        UUID userID;

        dateOfBirth = new Date();
        userID = UUID.randomUUID();
        user = new User(userID, "Test", "user", "testuser", "test@email.com", "password", "company", dateOfBirth);

        team = new Team();
    }
    


//Marietou- DataLoader, DataConstants, Columns, Tasks



//Casey- Project, ProjectHistory, ProjectList, Comments, 
@Test
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
    
    newProject.addTasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);

    ArrayList<Tasks> firstColumnTasks = newProject.getColumns().get(0).getTasks();
    Tasks addedTask = firstColumnTasks.get(0);

    assertEquals(taskDescription, addedTask.getTaskDescription());
}

@Test
public void testAddMember() {

    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");
    User user = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());

    newProject.addMember(user);

    newProject.addMember(user); //do it again to test for dupes

    ArrayList<User> members = newProject.getMembers();

    assertEquals(1, members.size());
}

@Test
public void testAddColumns() {

    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");
    String title = "Sample Column";

    newProject.addColumns(title);
    ArrayList<Columns> columns = newProject.getColumns();
    Columns addedColumn = columns.get(0);

    assertEquals(title, addedColumn.getTitle());
}

@Test
public void testAddComments() {

    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");

    Date date = new Date();
    String text = "Sample Comment";
    User commentBy = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());

    newProject.addComments(date, text, commentBy);
    ArrayList<Comments> comments = newProject.getTasks.getComments(); //how do i access get comments thats found
                                                                     //within my tasks within projects? 
    
    Comments addedComment = comments.get(0);

    assertEquals(text, addedComment.getText());
}

@Test
public void testMoveTasks() {
    
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
    
    newProject.addTasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);

    ArrayList<Tasks> firstColumnTasks = newProject.getColumns().get(0).getTasks();
    Tasks addedTask = firstColumnTasks.get(0);

    newProject.moveTasks(firstColumnTasks, 0, 1);

    assertFalse(newProject.getColumns().get(0).getTasks().contains(firstColumnTasks));
}

@Test
public void testAddChange() {

    ProjectList projectList = ProjectList.getInstance();
    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");
    projectList.addProject(newProject);

    User user = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());
    String description = "Change description";
    Date initialLastUpdate = projectHistory.getLastUpdate();
    projectHistory.addChange(user, description);

    Date updatedLastUpdate = projectHistory.getLastUpdate();

    assertNotEquals(initialLastUpdate, updatedLastUpdate);
}

@Test
public void testRemoveChange() {

    User user = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());
    String description = "Sample change description";
    Change change = new Change("Changed the font of the headers");

    projectHistory.getAllChanges().add(change);

    boolean removed = projectHistory.removeChange(change);

    assertFalse(projectHistory.getAllChanges().contains(change));
}

@Test
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

@Test
public void testRemoveProject() {
    
    ProjectList projectList = ProjectList.getInstance();

    String nameToRemove = "Project1";
    String descriptionToRemove = "Description1";
    boolean removed = projectList.removeProject(nameToRemove, descriptionToRemove);

    assertTrue(removed);
}





//Laura- Team, Change, Dashboard 
}