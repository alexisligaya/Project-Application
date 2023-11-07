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

        testTeam = new Team();
        testProject = new Project("name", "description");
	}
	
    //Alexis- DataWriter, User, UserList, Application
    
   public void testJoinTeam() {
        testUser.joinTeam(testTeam);
        assertTrue(testTeam.contains(testUser));
   }
    
    public void testLeaveTeam() {
        testUser.joinTeam(testTeam);
        testUser.leaveTeam(testTeam);
    }

    public void testViewProjects(){
        testTeam.addProject(testProject);
        testProject.addMember(testUser);
        testUser.joinTeam(testTeam);

        ArrayList<Project> projects = testUser.viewProjects();
    }

    public void testIsOnline(){

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
//Team class
@Test
public void testRemoveScrumTeamMember(){
    ArrayList<User> members = new ArrayList<>();
    User productOwner = new User("ProductOwner");
    User scrumMaster = new User("ScrumMaster");
    User existingScrumMember = new User ("ExistingScrumMember");
    ArrayList<User> scrumTeamMembers = new ArrayList<>();
    scrumTeamMembers.add(existingScrumMember);
    ArrayList<Project> projects = new ArrayList<>();
    Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);

    boolean isRemoved = team.removeScrumTeamMember(existingScrumMember);

    assertTrue(isRemoved);
    assertFalse(team.getScrumTeammembers().contains(existingScrumMember));

    }

     @Test
    public void testAddScrumTeamMember() {
        ArrayList<User> members = new ArrayList<>();
        User productOwner = new User("ProductOwner");
        User scrumMaster = new User("ScrumMaster");
        ArrayList<User> scrumTeamMembers = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);
        
        User newUser = new User("NewScrumMember");

        team.addScrumTeamMember(newUser);

        assertTrue(team.getScrumTeamMembers().contains(newUser));
    }

     @Test
    public void testToString() {
        ArrayList<User> members = new ArrayList<>();
        User productOwner = new User("ProductOwner");
        User scrumMaster = new User("ScrumMaster");
        ArrayList<User> scrumTeamMembers = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);

        
        String expected = "Members: " + members + "\nProduct Owner: " + productOwner
                + "\nScrum Master: " + scrumMaster + "\nScrum Team Members: " + scrumTeamMembers + "\nProjects: " + projects;

        assertEquals(expected, team.toString());
    }

    @Test
    public void testGetMembers() {
        ArrayList<User> members = new ArrayList<>();
        members.add(new User("Member1"));
        members.add(new User("Member2"));
        User productOwner = new User("ProductOwner");
        User scrumMaster = new User("ScrumMaster");
        ArrayList<User> scrumTeamMembers = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);

     
        assertEquals(members, team.getMembers());
    }

     @Test
    public void testGetProductOwner() {
        ArrayList<User> members = new ArrayList<>();
        User productOwner = new User("ProductOwner");
        User scrumMaster = new User("ScrumMaster");
        ArrayList<User> scrumTeamMembers = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);

        assertEquals(productOwner, team.getProductOwner());
    }

}