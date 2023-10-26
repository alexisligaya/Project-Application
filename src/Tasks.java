import java.util.Date;
import java.util.ArrayList;

public class Tasks {
    private Date deadline;
    private String taskDescription;
    private int priority;
    private double hours;
    private ArrayList<Change> changes;

    public Tasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser, ArrayList<Change> changes) {
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.hours = hours;
        this.changes = changes;
    }

    public Date getDeadline(){
        return deadline;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public int getPriority(){
        return priority;
    }

    public double getHours(){
        return hours;
    }

    public void assignToUser(User user){
        
    }

    public ArrayList<Change> getChanges(){
        return changes;
    }

    //add changes
    public void addChanges(String description, Date date, User user, Project project){
        Change change = new Change(description, date, user, project);
        changes.add(change);
    }

    public String toString(){
        String result = "Deadline: " + this.deadline;
        result += "\nTask Description: "+this.taskDescription;
        result += "\nPriority: " + this.priority;
        result += "\nHours: " + this.hours;
        return result;
    }
}
