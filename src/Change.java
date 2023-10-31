import java.util.Date;

public class Change {
    
    private String description;
    private Date date;
    private User user;
    private Project project;

    /**
     * Creates a Change object with the given information:
     * @param description - description of the change made
     * @param date - date of when the change was made
     * @param user - the user responsible for the change
     * @param project - the current project whose information is being changed
     */
    public Change(String description, Date date, User user, Project project){
        this.description = description;
        this.date = date;
        this.user = user;
        this.project = project;
    }

    /**
     * Gets the description of the change
     * @return a string of the description for the change made
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Gets the date of the change
     * @return a date of when the change was made
     */
    public Date getDate(){
        return date;
    }

    /**
     * Gets the user who made the change
     * @return a user object
     */
    public User getUser(){
        return user;
    }

    /**
     * Gets the project that was changed
     * @return a project object
     */
    public Project getProject(){
        return project;
    }

    /**
     * Formats the string of all the information for the change
     * @return a formatted string
     */
    public String toString(){
        String result = "Decription: " + this.description;
        result += "\nDate: "+this.date;
        result += "\nUser: " + this.user;
        result += "\nProject: " + this.project;
        return result;
    }
}
