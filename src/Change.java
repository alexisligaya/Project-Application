import java.time.LocalDate;
import java.time.LocalDateTime;

public class Change {

    private String description;
    private LocalDate date;
    private User user;
    private Project project;

    /**
     * Constructor of a Change object with the given parameters
     * 
     * @param description - description of the change made
     * @param date        - date of when the change was made
     * @param user        - the user responsible for the change
     * @param project     - the current project whose information is being changed
     */
    public Change(String description) {
        this.description = description;
        this.date = LocalDate.now();
    }

    /**
     * Gets the description of the change
     * 
     * @return a string of the description for the change made
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the date of the change
     * 
     * @return a date of when the change was made
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the user who made the change
     * 
     * @return a user object
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the project that was changed
     * 
     * @return a project object
     */
    public Project getProject() {
        return project;
    }

    /**
     * Formats the string of all the information for the change
     * 
     * @return a formatted string
     */
    public String toString() {
        String result = "Decription: " + this.description;
        result += "\nDate: " + this.date;
        result += "\nUser: " + this.user;
        result += "\nProject: " + this.project;
        return result;
    }
}
