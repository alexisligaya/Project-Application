import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

public class UserList {
    private static UserList instance;
    private ArrayList<User> users;
    private Set<UUID> onlineUsers = new HashSet<>();

    private UserList() {
        this.users = new ArrayList<User>();
    }

    public static UserList getInstance(){
        if(instance==null){
            instance=new UserList();
        }
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

    public User getUser(UUID userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null; // User with the given userID not found.
    }

    public boolean addUser(String firstName, String lastName, String userName, String email, String password, String company, Date dateOfBirth){
        
        //validate credentials
        if(firstName == null || lastName == null || userName == null || email == null || password == null || company == null || dateOfBirth == null)
            return false;

        //make a user
        for(User user : users){
            if(user.getUserName().equals(userName) || user.getEmail().equals(email))
                return false;
        }

        //add to list
        User newUser = new User(firstName, lastName, userName, email, password, company, dateOfBirth);
        users.add(newUser);
        saveUsers();

        //return null if not successful

        //create newUser if successful
        return true;
    }

    public void setUserOnline(UUID userID, boolean isOnline){
        if(isOnline)
            onlineUsers.add(userID);
        else    
            onlineUsers.remove(userID);
    }

    public boolean isUserOnline(UUID userID){
        return onlineUsers.contains(userID);
    }


    public String toString(){
        String result= "Users: " + this.users;
        return result;
    }

    public void saveUsers(){
        DataWriter.saveUsers(users);
    }

    public void loadUsers(){
        this.users = DataLoader.loadUsers();
        if(this.users == null){
            this.users = new ArrayList<User>();
        }
    }
}

