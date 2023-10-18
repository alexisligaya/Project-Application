import java.util.Arrays;
import java.util.Date;

public class Application {
    private User users;
    private Project project;
    private Team team;
    private UserList userList;

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

    public Team getTeam(){
        return team;
    }

    //sign up
    public User signUp(String firstName, String lastName, String userName, String email, String password, Date dateOfBirth){
        return UserList.getInstance().addUser(firstName, lastName, userName, email, password, dateOfBirth);
    }

    //user logs in
    public User login(String userName, String password){ 
       //calls userList
       getUserList();

       return getUsers();

    }

    //save user 
    public boolean saveUser(User user){
        return(Arrays.asList(userList).contains(user));
    }
}
