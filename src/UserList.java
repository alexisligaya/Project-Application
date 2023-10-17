import java.util.ArrayList;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;

    private UserList() {
        this.users = new ArrayList<User>();
    }

    public static UserList getInstance(){
        if(instance == null)
            instance = new UserList();
         return instance;
    }
   
    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addUser(String firstName, String lastName, String username, String email, String password, String dateOfBirth){
       
    }

    public void saveUser(User user){

    }


    public String toString(){
        String result= "Users: " + this.users;
        return result;
    }
}

