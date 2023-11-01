import java.util.Date;
import java.util.ArrayList;

public class Tasks {
    private Date deadline;
    private String taskDescription;
    private int priority;
    private double hours;
    private User assignedUser;
    private String user;
    private ArrayList<Change> changes;
    private ArrayList<Comments> comments;

    public Tasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser, ArrayList<Change> changes, ArrayList<Comments> comments) {
        this.deadline = deadline;
        this.taskDescription = taskDescription;
        this.priority = priority;
        this.hours = hours;
        this.assignedUser = assignedUser;
        this.changes = changes;
        this.comments = comments;
    }

    public Tasks(String taskDescription){
        this.taskDescription=taskDescription;
        this.deadline=null;
        this.priority=0;
        this.hours=0;
        this.assignedUser=null;
        this.changes= new ArrayList<>();
        this.comments = new ArrayList<>();
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

    public User getAssignedUser(){
        return assignedUser;
    }

    public ArrayList<Change> getChanges(){
        return changes;
    }

    public ArrayList<Comments> getComments(){
        return comments;
    }

    public void assignUser(User member){
        String description = "Task assigned from "; 
        if(this.assignedUser == null){
            description += "null";
        }
        else{
            description += this.assignedUser.getUserName();
        }
        description += " to " + member.getUserName();

        this.assignedUser = member;
        addChanges(description);
    }


    public void addComment(Comments comment){
        String description = "Comment by " + comment.getCommentBy() + ": " + comment.getText();
        comments.add(comment);
        addChanges(description);
    }

    //add changes
    public void addChanges(String description){
        Change change = new Change(description);
        changes.add(change);
    }

    public String toString(){
        String result = "Deadline: " + this.deadline;
        result += "\nTask Description: "+this.taskDescription;
        result += "\nPriority: " + this.priority;
        result += "\nHours: " + this.hours;
        result += "\nAssigned User: " + this.assignedUser;
        return result;
    }
}
