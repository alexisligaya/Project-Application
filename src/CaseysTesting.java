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

public class CaseysTesting{

    private User testUser;
    private Team testTeam;
    private Project testProject;
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

//Casey- Project, ProjectHistory, ProjectList, Comments, 
@Test
public void testAddTasks() {

    ProjectList projectList = ProjectList.getInstance();

    Date deadline = new Date();
    String taskDescription = "Test Task";
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
    String title = "Test Column";

    newProject.addColumns(title);
    ArrayList<Columns> columns = newProject.getColumns();
    Columns addedColumn = columns.get(1);

    assertEquals(title, addedColumn.getTitle());
}

@Test
public void testAddComments() {

    Project newProject = new Project("Flappy Bird", "Make the bird go through pipes for as long as possible");

    Date date = new Date();
    String text = "Test Comment";
    User commentBy = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());

    newProject.addComments(date, text, commentBy);
    ArrayList<Comments> comments = newProject.getColumns().get(0).getTasks().get(0).getComments(); 
    
    Comments addedComment = comments.get(0);

    assertEquals(text, addedComment.getText());
}

@Test
public void testMoveTasks() {
    
    ProjectList projectList = ProjectList.getInstance();

    Date deadline = new Date();
    String taskDescription = "Test Task";
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

    newProject.moveTasks(addedTask, 0, 1);

    assertFalse(newProject.getColumns().get(0).getTasks().contains(firstColumnTasks));
}

@Test
public void testAddChange() {

    ArrayList<Change> changes = new ArrayList<>();
    Date lastUpdate = new Date();
    ProjectHistory projectHistory = new ProjectHistory(changes, lastUpdate);

    User user = new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date());
    String description = "Change description";
    Date initialLastUpdate = projectHistory.getLastUpdate();
    projectHistory.addChange(user, description);

    Date updatedLastUpdate = projectHistory.getLastUpdate();

    assertNotEquals(initialLastUpdate, updatedLastUpdate);
}

@Test
public void testRemoveChange() {

    ArrayList<Change> changes = new ArrayList<>();
    Date lastUpdate = new Date();
    ProjectHistory projectHistory = new ProjectHistory(changes, lastUpdate);
    Change change = new Change("Changed the font of the headers");

    projectHistory.addChange(new User("Casey", "Vu", "CaseyVu", "cv10@email.sc.edu", "cv10", "Microsoft", new Date()), "Changed the font of the headers");

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

    Project newProject = new Project("Flappy Bird", "Developing an app made for entertainment purposes");
    projectList.addProject(newProject);

    String nameToRemove = newProject.getName();
    String descriptionToRemove = newProject.getDescription();
    boolean removed = projectList.removeProject(nameToRemove, descriptionToRemove);

    assertTrue(removed);
}

}