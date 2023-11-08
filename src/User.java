import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;
/** 
 * Represents a user 
 */
public class User {
    private UUID userID;
    private String firstName, lastName, userName, email, password, company;
    private Date dateOfBirth;
    private static User instance;

    /**
     * Consructs a User object with the given parameters
     * @param id           The unique identifier for the user.
     * @param firstName    The user's first name.
     * @param lastName     The user's last name.
     * @param userName     The user's username.
     * @param email        The user's email.
     * @param password     The user's password.
     * @param company
     * @param dateOfBirth  The user's date of birth.
     */
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

    /** Gets the UUID of the user
     * @return The UUID of the user
     */
    public UUID getUserID() {
        return userID;
    }
    /** Gets the username of the User
     * @return The username of the user
     */
    public String getUserName() {
        return userName;
    }
     /** Gets the user's first name.
     * @return The first name of the user
     */
    public String getfirstName() {
        return firstName;
    }
    /** Gets the user's last name.
     * @return The last name of the user
     */
    public String getLastName() {
        return lastName;
    }
    /** Gets the user's email address.
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }
    /** Gets the user's password.
    * @return The password of the user
     */
    public String getPassword() {
        return password;
    }

    /** Gets the user's company.
    * @return The company of the user
     */
    public String getCompany(){
        return company;
    }

    /** Gets the user's date of birth.
    * @return The date of birth of the user
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /** Gets an instance of the User class.
    * @return The User instance.
     */
    public static User getInstance() {
        if (instance == null)
            instance = new User(UUID.randomUUID(), "John", "Doe", "JohnDoe","", "", "", new Date());
        return instance;
    }
    
    /**
     * Joins a Scrum Team
     * @param team The team to be joined.
     */
    public void joinTeam(Team team){
        team.addScrumTeamMember(this);
    }

    /**
     * Leaves a Scrum Team
     * @param team The team to be left.
     */
    public void leaveTeam(Team team){
        team.removeScrumTeamMember(this);
    }

    /**
     * View the user's projects.
     * @return An array list of Project object that the user is a member of.
     */
    public ArrayList<Project> viewProjects(){
        ArrayList<Project> userProjects= new ArrayList<>();
        for(Project project : Team.getInstance().getProjects()){
            if(project.getMembers().contains(this)){
                userProjects.add(project);
            }
        }
        return userProjects;
    }
    
    /**
     * Checks if the user is online.
     * @param userID The user ID of the person being checked for online status.
     * @return True if the user is online, false if not online.
     */
    public boolean isOnline() {
        // Use the UserList to check if the user with the given userID is online.
       return UserList.getInstance().isUserOnline(this.getUserID());
    }
    
    /**
     * Returns the User object as a string.
     * 
     * @return A string containing user information.
     */
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
    