import java.util.Arrays;
import java.util.Date;

public class Application {
    private static User users;
    private User currentUser;
    private Project project;
    private Project currentProject;
    private Team team;
    private UserList userList;
    private ProjectList projectList;

    public Application(){
        users=User.getInstance();
        project=Project.getInstance();
        team=Team.getInstance();
    }

    public static User getUsers(){
        return users;
    }

    public UserList getUserList(){
        return userList;
    }

    public Project getProject(){
        return project;
    }
    public Project getProjectList(){
        return projectList;
    }
    

    public Team getTeam(){
        return team;
    }

    //sign up
    public boolean signUp(String firstName, String lastName, String userName, String email, String password, Date dateOfBirth){
        return UserList.getInstance().addUser(firstName, lastName, userName, email, password, dateOfBirth);
    }

    //user logs in
    public boolean login(String userName, String password){ 
       //calls userList
       currentUser = UserList.getInstance().getUser(userName, password);
    
       return currentUser != null;
    }

    //save user 
    public void logout(){
        UserList.getInstance().saveUsers();
    }

    //create project
    public boolean createProject(String name, String description){
        //call projectList
        currentProject = ProjectList.getInstance().getProject(name, description);
        return currentProject != null;
        //add columns
        //add comments
    }

    //save project
    public void saveProjects(){
        ProjectList.getInstance().saveProjects();
    }


}
