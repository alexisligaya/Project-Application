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

//Marietou- DataLoader, DataConstants, Columns, Tasks

public class MarietouTest {

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


    @Test
    public void testLoadUsers() {
        ArrayList<User> users = DataLoader.loadUsers();
        assertNotNull(users, "user list is not null");
        assertTrue(users.size() > 0, "user list not empty");
        
        for (User user : users) {
            assertNotNull(user.getfirstName(), "first name not null");
            assertNotNull(user.getLastName(), "last name should not null");
            assertNotNull(user.getPassword(), "password not null");
            assertNotNull(user.getDateOfBirth(), "dob not null");
            assertNotNull(user.getCompany(), "company not null");
            assertNotNull(user.getUserID(), "user ID not null");
            assertNotNull(user.getUserName(), "username is not null");
            assertNotNull(user.getEmail(), "email is not null");
    
            if (user.getfirstName().equals("test")) {
                assertEquals(user.getLastName(), "user", "user test");
            }
        }
    }

    @Test
    public void testLoadProjects(){
        ArrayList<Project> projects = DataLoader.loadProjects();
        File testFile = new File("json/project.json");
        assertTrue(testFile.exists(), "project json file does not exist");
        assertNotNull(projects, "project list should not be null");
        
        for (Project project : projects) {
            assertNotNull(project.getProjectID(), "projectID not null");
            assertNotNull(project.getName(), "name not null");
            assertNotNull(project.getDescription(), "description not null");
            assertNotNull(project.getRating(), "rating not null");
            assertNotNull(project.getIsFinished(), "finished status not null");
            assertNotNull(project.getIsPublic(), "public status not null");
            assertNotNull(project.getColumns(), "columns not null");
            assertNotNull(project.getMembers(), "members not null");
            
            if (project.getName().equals("name")) {
                assertEquals(project.getName(), "name");
            }
        }

        /*assertEquals(projects.get(0).getProjectID(), "4cdc573d-7c06-4932-a356-7e0654b45db6");
        assertEquals(projects.get(1).getName(), "Electric Missiles");
        assertEquals(projects.get(2).getDescription(), "boom");
        assertEquals(projects.get(3).getRating(), "0.0");
        assertEquals(projects.get(4).getIsFinished(), false);
        assertEquals(projects.get(5).getIsPublic(), false);
        assertEquals(projects.get(6).getColumns(), "[]");
        assertEquals(projects.get(7).getMembers(), "[]");
        */
        
    }

    //Columns
    @Test
    public void testAddTasks(){
        
        Columns columns = new Columns("new tasks", new ArrayList<Tasks>());
        Tasks newTask = new Tasks(null, null, 0, 0, testUser, null, null);
        columns.addTask(newTask);
        assertEquals(columns.getTasks().size(), 1);

    }

    @Test
    public void testRemoveTasks(){

        Columns columns = new Columns("remove tasks", new ArrayList<>(1));
        Tasks first = columns.getTasks().get(0);
        columns.removeTask(first);
        assertEquals(columns.getTasks().size(), 0);

    }


    //Tasks
    @Test
    public void testAssignUser(){
        Tasks tasks = new Tasks(new Date(), "Initialize super algorithm to detonate at warp speed", 0, 0, testUser, new ArrayList<Change>(), new ArrayList<Comments>());
        User user = new User("Jeff", "Goldblum", "JGold", "JGold12@gmail.com", "123", "Code Mission Possible", null);
        tasks.assignUser(user);
        assertEquals(user, tasks.getAssignedUser());
    }

    @Test
    public void testAddComment(){
        Tasks taskComment = new Tasks(new Date(), "Initialize super algorithm to detonate at warp speed", 0, 0, testUser, new ArrayList<Change>(), new ArrayList<Comments>());
        Comments comment = new Comments("Avoid Civilians", testUser);

        taskComment.addComment(comment);
        assertEquals(1, taskComment.getComments().size());
        assertEquals("Avoid Civilians", taskComment.getChanges().get(0));
    }

    @Test
    public void testAddChanges(){
        Tasks taskChange = new Tasks(new Date(), "Initialize super algorithm to detonate at warp speed", 0, 0, testUser, new ArrayList<Change>(), new ArrayList<Comments>());
        String description = "This is a change description";
        taskChange.addChanges(description);
        assertEquals(1, taskChange.getChanges().size());
        assertEquals(description, taskChange.getChanges().get(0).getDescription());
    }
    
} 