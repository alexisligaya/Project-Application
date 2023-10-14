import java.util.UUID;
import java.util.Date;
import java.util.ArrayList;

public class User {
    private UUID userID;
    private String firstName, lastName, userName, email, password;
    private Date dateOfBirth;
    private ArrayList<Tasks> tasks;

    public User(UUID userID, String firstName, String lastName, String userName, String email, String password, Date dateOfBirth, ArrayList<Tasks> tasks) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.tasks = tasks;
    }

    public UUID getUserID(){
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public String getfirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

   public ArrayList<Tasks> getTasks(){
        return tasks;
   }
}
