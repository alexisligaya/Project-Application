import java.util.Date;
import java.util.ArrayList;

/**
 * Represents a task
 */
public class Tasks {
    private Date deadline;
    private String taskDescription;
    private int priority;
    private double hours;
    private User assignedUser;
    private ArrayList<Change> changes;
    private ArrayList<Comments> comments;

    /**
     * Creates a Tasks object with the given parameters.
     * @param deadline          The deadline for the task.
     * @param taskDescription   The description of the task.
     * @param priority          The priority of the task.
     * @param hours             The hours needed for the task.
     * @param assignedUser      The user assigned to the task.
     * @param changes           The list of changes the task has.
     * @param comments          The list of comments the task has.
     */
    public Tasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser, ArrayList<Change> changes, ArrayList<Comments> comments) {
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.hours = hours;
        this.assignedUser = assignedUser;
        this.changes = changes;
        this.comments = comments;
    }

    /**
     * Gets the deadline for the task.
     * @return The task's deadline.
     */
    public Date getDeadline(){
        return deadline;
    }

    /**
     * Gets the description of the task
     * @return  The task's description.
     */
    public String getTaskDescription(){
        return taskDescription;
    }

    /**
     * Gets the priority of the task
     * @return  The task's priority
     */
    public int getPriority(){
        return priority;
    }

    /**
     * Gets the hours needed for the task
     * @return The hours for the task.
     */
    public double getHours(){
        return hours;
    }

    /**
     * Gets the user assigned to the task.
     * @return  The assigned user for the task.
     */
    public User getAssignedUser(){
        return assignedUser;
    }

    /**
     * Assigns a user to the task
     * @param user The user to be assigned to the task
     */
    public void assignUser(User user){
        this.assignedUser = user;
    }

    /**
     * Gets the list of changes the task has
     * @return  The list of changes for the task
     */
    public ArrayList<Change> getChanges(){
        return changes;
    }

    /**
     * Gets the list of comments a task has.
     * @return  The list of comments for the task
     */
    public ArrayList<Comments> getComments(){
        return comments;
    }

    
    /**Addss a change to the task
     * @param description   The description of the change.
     * @param date          The date of when the change happened
     * @param user          The user that made the change
     * @param project       The project associated with the change.
     */
    public void addChanges(String description, Date date, User user, Project project){
        Change change = new Change(description, date, user, project);
        changes.add(change);
    }
    /**
     * Returns the Task object as a string
     * @return a string containing the task information.
     */
    public String toString(){
        String result = "Deadline: " + this.deadline;
        result += "\nTask Description: "+this.taskDescription;
        result += "\nPriority: " + this.priority;
        result += "\nHours: " + this.hours;
        result += "\nAssigned User: " + this.assignedUser;
        return result;
    }
}
