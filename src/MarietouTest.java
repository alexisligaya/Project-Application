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
    public void testLoadUsers(){
        ArrayList<User> users = DataLoader.loadUsers();
        File testFile = new File("user-test.json");
        assertEquals(users.get(0).getfirstName(), "Atticus");
        assertEquals(users.get(1).getLastName(), "Madden");
        assertEquals(users.get(2).getPassword(), "123");
        assertEquals(users.get(3).getDateOfBirth(), "08/02/2023");
        assertEquals(users.get(4).getCompany(), "Code Mission Possible");
        assertEquals(users.get(5).getUserID(), "efab0770-bad5-485b-b6ce-019c1492a49c");
        assertEquals(users.get(6).getUserName(), "AMadden");
        assertEquals(users.get(7).getEmail(), "AMadden12@gmail.com");

        
    }

    @Test
    public void testLoadProjects(){
        ArrayList<Project> projects = DataLoader.loadProjects();
        File testFile = new File("project.json");
        assertEquals(projects.get(0).getProjectID(), "4cdc573d-7c06-4932-a356-7e0654b45db6");
        assertEquals(projects.get(1).getName(), "Electric Missiles");
        assertEquals(projects.get(2).getDescription(), "boom");
        assertEquals(projects.get(3).getRating(), "0.0");
        assertEquals(projects.get(4).getIsFinished(), false);
        assertEquals(projects.get(5).getIsPublic(), false);
        assertEquals(projects.get(6).getColumns(), "[]");
        assertEquals(projects.get(7).getMembers(), "[]");

        
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
        User oldUser = new User("Atticus", "Finch", "AFinch", "AF12@gmail.com", "123", "None", null);
        User newUser = new User("Jeff", "Goldblum", "JGold", "JGold12@gmail.com", "123", "Code Mission Possible", null);
        tasks.assignUser(oldUser);
        assertEquals("old user", tasks.getAssignedUser());

        tasks.assignUser(newUser);
        assertEquals("new user", tasks.getAssignedUser());

    }

    @Test
    public void testAddComment(){
        Tasks taskComment = new Tasks(new Date(), "Initialize super algorithm to detonate at warp speed", 0, 0, testUser, new ArrayList<Change>(), new ArrayList<Comments>());
        Comments comment = new Comments("Avoid Civilians", testUser);

        taskComment.addComment(comment);
        assertEquals(1, taskComment.getComments().size());
        assertEquals("User123: This is a comment", taskComment.getChanges().get(0));
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