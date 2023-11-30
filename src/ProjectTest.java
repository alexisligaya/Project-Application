
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
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


public class ProjectTest {

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
	
//Alexis- DataWriter, User, UserList, Application



//Marietou- DataLoader, DataConstants, Columns, Tasks

//Laura- Team, Change, Dashboard 
public class ProjectTest {
    @Test
    public void tester() {
        assertTrue(true);
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

 //Change class
  @Test
    public void testGetDescription() {
        String description = "Sample change description";
        Change change = new Change(description);
        assertEquals(description, change.getDescription());
    }

      @Test
    public void testGetDate() {
        Change change = new Change("Sample change description");
        assertEquals(LocalDate.now(), change.getDate());
    }

    @Test
    public void testGetUser() {
        Change change = new Change("Sample change description");
        User user = new User("User1");
        change.setUser(user);
        assertEquals(user, change.getUser());
    }


    @Test
    public void testGetProject() {
     
        Change change = new Change("Sample change description");
        Project project = new Project("Project1", "Description1");

    
        change.setProject(project);

     
        assertEquals(project, change.getProject());
    }

    @Test
    public void testToString() {
       
        Change change = new Change("Sample change description");
        User user = new User("User1");
        Project project = new Project("Project1", "Description1");

       
        change.setUser(user);
        change.setProject(project);

       
        String expected = "Description: " + change.getDescription() +
                "\nDate: " + change.getDate() +
                "\nUser: " + change.getUser() +
                "\nProject: " + change.getProject();

   
        assertEquals(expected, change.toString());
    }
}
}
