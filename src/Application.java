import java.util.Date;

public class Application {
    private static User users;
    private User currentUser;
    private Project project;
    private Team team;
    private UserList userList;
    private ProjectList projectList;

    public Application(){
        userList = UserList.getInstance();
        users=User.getInstance();
        project=Project.getInstance();
        team=Team.getInstance();
    }

    public static User getUsers(){
        return users;
    }
    public User getCurrentUser(){
        return currentUser;
    }

    public UserList getUserList(){
        return userList;
    }

    public Project getProject(){
        return project;
    }

    public ProjectList getProjectList(){
        return projectList;
    }
    
    public Team getTeam(){
        return team;
    }

    //sign up
    public boolean signUp(String firstName, String lastName, String userName, String email, String password, String company, Date dateOfBirth){
        return UserList.getInstance().addUser(firstName, lastName, userName, email, password, company, dateOfBirth);
       
    }

    //user logs in
    public boolean login(String userName, String password){ 
       //calls userList
       currentUser = UserList.getInstance().getUser(userName, password);
    
       return currentUser != null;
    }

    //save user and projects
    public void logout(){
        UserList.getInstance().saveUsers(); 
        ProjectList.getInstance().saveProjects();
    }

    //add project
    public void addProject(Project project){
        //call projectList
        ProjectList.getInstance().addProject(project);
    }

    public boolean removeProject(String name, String description) {
        if (projectList.removeProject(name, description)) {
            return true;
        } else {
            return false;
        }
    }


}
