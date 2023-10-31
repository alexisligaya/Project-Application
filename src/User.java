import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;

public class User {
    private UUID userID;
    private String firstName, lastName, userName, email, password, company;
    private Date dateOfBirth;
    private static User instance;

    public User(UUID id, String firstName, String lastName, String userName, String email, String password, String company, Date dateOfBirth) {
        this.userID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.company = company;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String firstName, String lastName, String userName, String email, String password, String company, Date dateOfBirth) {
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.company = company;
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany(){
        return company;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public static User getInstance() {
        if (instance == null)
            instance = new User(UUID.randomUUID(), "John", "Doe", "JohnDoe","", "", "", new Date());
        return instance;
    }
    public void joinTeam(Team team){
        team.addScrumTeamMember(this);
    }

    public void leaveTeam(Team team){
        team.removeScrumTeamMember(this);
    }

    public ArrayList<Project> viewProjects(){
        ArrayList<Project> userProjects= new ArrayList<>();
        for(Project project : Team.getInstance().getProjects()){
            if(project.getMembers().contains(this)){
                userProjects.add(project);
            }
        }
        return userProjects;
    }
    
    public boolean isOnline(UUID userID) {
        // Use the UserList to check if the user with the given userID is online.
        User user = UserList.getInstance().getUser(userID);
    
        // Check if the user is not null (exists) and is online.
        return user != null && user.isOnline(userID);
    }
    
    public String toString() {
        String result = "User ID: " + this.userID;
        result += "\nFirst name: " + this.firstName;
        result += "\nLast name: " + this.lastName;
        result += "\nUsername: " + this.userName;
        result += "\nEmail: " + this.email;
        result += "\nPassword: " + this.password;
        result += "\nCompany: " + this.company;
        result += "\nDate of Birth: " + this.dateOfBirth;
        return result;
    }
}
