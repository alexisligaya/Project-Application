//Laura- Team, Change, Dashboard 
//Team class
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDate;

public class LauraTest{
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
    @Test
    public void testGetListOfProjects() {
        
     ArrayList<Project> projects = new ArrayList<>();
     projects.add(new Project("Project1", "Description1"));
     projects.add(new Project("Project2", "Description2"));
     Dashboard dashboard = new Dashboard(projects);

        
     assertEquals(projects, dashboard.getListOfProjects());
    }

     @Test
    public void testViewProjects() {
        
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(new Project("Project1", "Description1"));
        projects.add(new Project("Project2", "Description2"));
        Dashboard dashboard = new Dashboard(projects);

        
        assertEquals(projects, dashboard.viewProjects());
    }

    @Test
    public void testSearchProject() {
     
        ArrayList<Project> projects = new ArrayList<>();
        UUID project1ID = UUID.randomUUID();
        UUID project2ID = UUID.randomUUID();
        projects.add(new Project("Project1", "Description1", project1ID));
        projects.add(new Project("Project2", "Description2", project2ID));
        Dashboard dashboard = new Dashboard(projects);

        
        Project foundProject = dashboard.searchProject(project1ID);

        
        assertEquals("Project1", foundProject.getName()); 
        assertEquals("Description1", foundProject.getDescription()); 
    }

    @Test
public void testToString() {
   
    ArrayList<Project> projects = new ArrayList<>();
    projects.add(new Project("Project1", "Description1"));
    projects.add(new Project("Project2", "Description2"));
    Dashboard dashboard = new Dashboard(projects);

   
    String expected = "List of Projects: " + projects;

    
    assertEquals(expected, dashboard.toString());
}


    @Test
public void testToString() {
    ArrayList<User> members = new ArrayList<>();
    User productOwner = new User("John Doe");
    User scrumMaster = new User("Jane Smith");
    ArrayList<User> scrumTeamMembers = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();
    Team team = new Team(members, productOwner, scrumMaster, scrumTeamMembers, projects);

    members.add(new User("Alice Johnson"));
    members.add(new User("Bob Smith"));
    members.add(new User("Laura Nolan"));

  
    projects.add(new Project("Project A", "Description A"));

    String expected = "Members: " + members + "\nProduct Owner: " + productOwner
            + "\nScrum Master: " + scrumMaster + "\nScrum Team Members: " + scrumTeamMembers + "\nProjects: " + projects;

    assertEquals(expected, team.toString());
}

    
  @Test
public void testSortProjectsByDate() {
   
    ArrayList<Project> projects = new ArrayList<>();

   
    String date1 = "2023-02-15";
    String date2 = "2023-01-10";
    String date3 = "2023-03-20";

    Project project1 = new Project("Project 1", "Description 1", date1);
    Project project2 = new Project("Project 2", "Description 2", date2);
    Project project3 = new Project("Project 3", "Description 3", date3);

    projects.add(project3);
    projects.add(project1);
    projects.add(project2);

    Dashboard dashboard = new Dashboard(projects);

   
    ArrayList<Project> sortedProjects = dashboard.sortProjectsByDate();

    
    assertEquals(project2, sortedProjects.get(0)); 
    assertEquals(project1, sortedProjects.get(1)); 
    assertEquals(project3, sortedProjects.get(2)); 
}


    }
}