import java.util.UUID;
import java.util.Date;
import java.util.ArrayList;

public class User {
    private UUID userID;
    private String firstName, lastName, userName, email, password;
    private Date dateOfBirth;
    private ArrayList<Tasks> tasks;
    private static User instance;

    public User(String userID2, String firstName, String lastName, String userName, String email, String password, Date dateOfBirth) {
        this.userID = userID2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    private User(){
        this.userID = UUID.randomUUID();
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

   public static User getInstance(){
    if(instance == null)
        instance = new User();
    return instance;
   }

   public String toString(){
    String result = "User ID: " + this.userID;
    result += "\nFirst name: "+this.firstName;
    result += "\nLast name: " + this.lastName;
    result += "\nUsername: " + this.userName;
    result += "\nEmail: " + this.email;
    result += "\nPassword: " + this.password;
    result += "\nDate of Birth: " + this.dateOfBirth;
    return result;
}
}
