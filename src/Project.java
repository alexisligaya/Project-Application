import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;

public class Project {

    private UUID projectID;
    private String name, description;
    private double rating;
    private boolean isFinished, isPublic;
    private ArrayList<User> members;
    private ArrayList<Columns> columns; // make these empty for now
    private ArrayList<Comments> comments;
    private static Project instance;

    /**
     * Constructor for a Project with the given parameters
     *
     * @param projectID   - the unique identifier for the project.
     * @param name        - name of the project.
     * @param description - a description of the project.
     * @param rating      - the rating or score of the project.
     * @param isFinished  - a boolean indicating if the project is finished or
     *                    ongoing.
     * @param isPublic    - a boolean indicating if the project is public or
     *                    private.
     * @param columns     - an ArrayList of Columns representing the project's task
     *                    columns.
     * @param members     - an ArrayList of User objects representing the project
     *                    members.
     */
    public Project(UUID projectID, String name, String description, double rating, boolean isFinished, boolean isPublic,
            ArrayList<Columns> columns, ArrayList<User> members) {
        this.projectID = projectID;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.isFinished = isFinished;
        this.isPublic = isPublic;
        this.columns = columns;
        this.members = members;
    }

    /**
     * Constructs a Project with the given parameters
     * 
     * @param name        - name of the project
     * @param description - a description of the project
     */
    public Project(String name, String description) {
        this.projectID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.columns = new ArrayList<>();
        Columns defaultColumn = new Columns();
        this.columns.add(defaultColumn);
        this.members = new ArrayList<>();
    }

    /**
     * Gets the unique ID of the project
     * 
     * @return a UUID for the project
     */
    public UUID getProjectID() {
        return projectID;
    }

    /**
     * Gets the name of the project
     * 
     * @return a string representation of the name of the project
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the project
     * 
     * @return a string of the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the rating of the project
     * 
     * @return a double of the rating of the project
     */
    public double getRating() {
        return rating;
    }

    /**
     * Returns true or false based on completion of project
     * 
     * @return true if the project is finished, false if not
     */
    public boolean getIsFinished() {
        return isFinished;
    }

    /**
     * Returns true or false based on accessibility
     * 
     * @return true if public, false if not
     */
    public boolean getIsPublic() {
        return isPublic;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Columns> getColumns() {
        return columns;
    }

    /**
     * Gets the list of members
     *
     * @return an ArrayList of User objects that represent the project members
     */
    public ArrayList<User> getMembers() {
        return members;
    }

    /**
     * Adds a member to the project
     *
     * @param user - User object to add to the project member
     */
    public void addMember(User user) {
        if (!members.contains(user))
            members.add(user);
    }

    /**
     * Gets the singleton of the Project class
     *
     * @return singleton instance of the Project class
     */
    public static Project getInstance() {
        if (instance == null)
            instance = new Project("My Project", "this is my project");
        return instance;
    }

    // add tasks
    public void addTasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser,
            ArrayList<Change> changes, ArrayList<Comments> comments) {
        Tasks task = new Tasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);
        columns.get(0).addTask(task);
    }

    /**
     * Add a task with the choice of description to the column of the project
     *
     * @param taskDescription - the description of the task to be added
     * @return the Tasks object
     */
    public Tasks addTasks(String taskDescription) {
        Tasks task = new Tasks(taskDescription);
        columns.get(0).addTask(task);
        return task;
    }

    // add columns
    public void addColumns(String title) {
        Columns column = new Columns();
        column.setTitle(title);
        columns.add(column);
    }

    // add comments
    public void addComments(Date date, String text, User commentBy) {
        Comments comment = new Comments(text, commentBy);
        comments.add(comment);
    }

    // move
    public void moveTasks(Tasks task, int fromColumnPos, int toColumnPos) {
        this.columns.get(fromColumnPos).removeTask(task);
        this.columns.get(toColumnPos).addTask(task);
    }

    /**
     * Formats the string of all the information for the project
     * 
     * @return a formatted string
     */
    public String toString() {
        String result = "Project ID: " + this.projectID;
        result += "\nName: " + this.name;
        result += "\nDescription: " + this.description;
        result += "\nRating: " + this.rating;
        result += "\nIs Finished: " + this.isFinished;
        result += "\nIs Public: " + this.isPublic;
        result += "\nColumns: " + this.columns;
        result += "\nMembers: " + this.members;
        return result;
    }
}
