import java.util.ArrayList;
import java.util.Date;

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

    public User getUser(String userName, String password){
        for(User user : users){
            if(user.getUserName().equals(userName)){
                if(user.getPassword().equals(password))
                    return user;
                else
                    return null; //null means incorrect password
            }
                
        }
        //null means user doesn't exist
        return null;
    }

    public boolean addUser(String firstName, String lastName, String userName, String email, String password, Date dateOfBirth){
        //validate credentials
        if(firstName == null || lastName == null || userName == null || email == null || password == null || dateOfBirth == null)
            return false;

        //make a user
        for(User user : users){
            if(user.getUserName().equals(userName) || user.getEmail().equals(email))
                return false;
        }

        //add to list
        User newUser = new User(firstName, lastName, userName, email, password, dateOfBirth);
        users.add(newUser);

        //return null if not successful

        //create newUser if successful
        return true;
    }

    
    public String toString(){
        String result= "Users: " + this.users;
        return result;
    }

    public void saveUsers(){
        DataWriter.saveUsers();
    }
}

