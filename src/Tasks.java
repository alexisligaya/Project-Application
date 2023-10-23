import java.util.Date;
import java.util.ArrayList;

public class Tasks {
    private Date deadline;
    private String taskDescription;
    private int priority;
    private double hours;
    private ArrayList<Comment> comments;
    private User assignedUser;

    public Tasks(Date deadline, String taskDescription, int priority, double hours, ArrayList<Comment> comments, User assignedUser) {
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.hours = hours;
        this.comments = comments;
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

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public void assignToUser(User user){
        
    }
    public String toString(){
        String result = "Deadline: " + this.deadline;
        result += "\nTask Description: "+this.taskDescription;
        result += "\nPriority: " + this.priority;
        result += "\nHours: " + this.hours;
        result += "\nComments" + this.comments;
        return result;
    }
}
