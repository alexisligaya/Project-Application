import java.beans.Transient;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class ProjectTest{


    @Test
    public void testing(){

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

    Project addedProject = projects.get(0);
    assertEquals(projectID, addedProject.getProjectID());
    assertEquals(name, addedProject.getName());
    assertEquals(description, addedProject.getDescription());
    assertEquals(rating, addedProject.getRating(), 0.001); // Use delta for double comparison
    assertEquals(isFinished, addedProject.getIsFinished());
    assertEquals(isPublic, addedProject.getIsPublic());
}



//Laura- Team, Change, Dashboard 
}