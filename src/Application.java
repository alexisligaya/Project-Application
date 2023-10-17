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

    public User getUsers(){
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
    public User login(User user){ 
       //calls userList
       getUserList();

       //getUser
       getUsers();
    }

    //save user 
    public boolean saveUser(User user){

    }
}
