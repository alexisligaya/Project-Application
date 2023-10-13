import java.util.UUID;
import java.util.Date;
import java.util.ArrayList;

public class User {
    private UUID userID;
    private String firstName, lastName, userName, email, password;
    private Date dateOfBirth;
    private ArrayList<Tasks> tasks;

    public User(String firstName, String lastName, String userName, String email, String password, Date dateOfBirth, ArrayList<Tasks> tasks) {
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.tasks = tasks;
    }
}
