import java.util.Date;

public class Application {

    private static User users;
    private User currentUser;
    private Project project;
    private Team team;
    private UserList userList;
    private ProjectList projectList;

    public Application() {
        userList = UserList.getInstance();
        users = User.getInstance();
        project = Project.getInstance();
        team = Team.getInstance();
    }

    /**
     * Gets a list of User objects
     * 
     * @return an ArrayList of User objects
     */
    public static User getUsers() {
        return users;
    }

    /**
     * Gets the current user
     * 
     * @return a User object of the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Gets the user list
     * 
     * @return a UserList object
     */
    public UserList getUserList() {
        return userList;
    }

    /**
     * Gets the current project
     * 
     * @return a Project object of the current project being called
     */
    public Project getProject() {
        return project;
    }

    /**
     * Gets the project list
     * 
     * @return Projectlist object
     */
    public ProjectList getProjectList() {
        return projectList;
    }

    /**
     * Gets the current team
     * 
     * @return a team object
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Signing up a user with the following information:
     * 
     * @param firstName   - first name of user
     * @param lastName    - last name of user
     * @param userName    - user's chosen username
     * @param email       - email of user
     * @param password    - user's chosen password
     * @param dateOfBirth - user's date of birth
     * @return true that the user has been signed up
     */
    public boolean signUp(String firstName, String lastName, String userName, String email, String password, String company, Date dateOfBirth) {
        return UserList.getInstance().addUser(firstName, lastName, userName, email, password, company, dateOfBirth);

    }

    /**
     * Logs an existing user in through the use of the following information:
     * 
     * @param userName - user's personal username
     * @param password - user's personal password
     * @return true if the user is successfully logged in, false if not
     */
    public boolean login(String userName, String password) {
        // calls userList
        currentUser = UserList.getInstance().getUser(userName, password);

        return currentUser != null;
    }

    // save user and projects
    public void logout() {
        UserList.getInstance().saveUsers();
        ProjectList.getInstance().saveProjects();
    }

    // add project
    public void addProject(Project project) {
        // call projectList
        ProjectList.getInstance().addProject(project);
    }

    /**
     * Removes the specified project based on name and description
     * 
     * @param name        - name of specified project
     * @param description - description of specified project
     * @return true if the project was found and removed, false if not
     */
    public boolean removeProject(String name, String description) {
        if (projectList.removeProject(name, description)) {
            return true;
        } else {
            return false;
        }
    }
}
