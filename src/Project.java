import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;

public class Project {
    private UUID projectID;
    private String name, description;
    private double rating;
    private boolean isFinished, isPublic;
    private ArrayList<User> members;
    private ArrayList<Columns> columns; //make these empty for now
    private ArrayList<Tasks> tasks;
    private ArrayList<Comments> comments; 
    private static Project instance;

    //contains all variables in parameters
    public Project(UUID projectID, String name, String description, double rating, boolean isFinished, boolean isPublic, ArrayList<Columns> columnList, ArrayList<User> members) {
        this.projectID = projectID;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.isFinished = isFinished;
        this.isPublic = isPublic;
        this.columns = columnList;
        this.members = members;
    }
    
    //does not contain the array lists in parameters (empty array lists)
    public Project(String name, String description) {
         this.projectID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.comments = new ArrayList<>();
        }
    
    public UUID getProjectID(){
        return projectID;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getRating(){
        return rating;
    }

    public boolean getIsFinished(){
        return isFinished;
    }

    public boolean getIsPublic(){
        return isPublic;
    }

    public ArrayList<Columns> getColumnList(){
        return columns;
    }

    public ArrayList<User> getMembers(){
        return members;
    }

    public static Project getInstance(){
        if(instance == null)
            instance = new Project("My Project", "this is my project");
        return instance;
    }

    //add tasks
    public void addTasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser, ArrayList<Change> changes, ArrayList<Comments> comments){
        Tasks task = new Tasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);
        tasks.add(task);
    }

    //add columns
    public void addColumns(String title, ArrayList<Tasks> tasks){
        Columns column = new Columns(title, tasks);
        columns.add(column);
    }

    //add comments
    public void addComments(Date date, String text, User commentBy, ArrayList<Comments> commentList){
        Comments comment = new Comments(date, text, commentBy, commentList);
        comments.add(comment);
    }

    public String toString(){
        String result = "Project ID: " + this.projectID;
        result += "\nName: "+this.name;
        result += "\nDescription: " + this.description;
        result += "\nRating: " + this.rating;
        result += "\nIs Finished: " + this.isFinished;
        result += "\nIs Public: " + this.isPublic;
        result += "\nColumns: " + this.columns;
        result += "\nMembers: " + this.members;
        return result;
    }
}
