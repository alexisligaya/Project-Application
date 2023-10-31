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
    private ArrayList<Comments> comments; 
    private static Project instance;

    /**
     * Constructor for Project that contains all variables in parameters
     * @param projectID
     * @param name
     * @param description
     * @param rating
     * @param isFinished
     * @param isPublic
     * @param columns
     * @param members
     */
    public Project(UUID projectID, String name, String description, double rating, boolean isFinished, boolean isPublic, ArrayList<Columns> columns, ArrayList<User> members) {
        this.projectID = projectID;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.isFinished = isFinished;
        this.isPublic = isPublic;
        this.columns = columns;
        this.members = members;
    }
    
    //does not contain the array lists in parameters (empty array lists)
    /**
     * 
     * @param name
     * @param description
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

    public ArrayList<Columns> getColumns(){
        return columns;
    }

    public ArrayList<User> getMembers(){
        return members;
    }

    public void addMember(User user){ //adds member to project
        if(!members.contains(user))
            members.add(user);
    }

    public static Project getInstance(){
        if(instance == null)
            instance = new Project("My Project", "this is my project");
        return instance;
    }

    //add tasks
    public void addTasks(Date deadline, String taskDescription, int priority, double hours, User assignedUser, ArrayList<Change> changes, ArrayList<Comments> comments){
        Tasks task = new Tasks(deadline, taskDescription, priority, hours, assignedUser, changes, comments);
        columns.get(0).addTask(task);
    }

    public Tasks addTasks(String taskDescription){
        Tasks task = new Tasks(taskDescription);
        columns.get(0).addTask(task);
        return task;
    }

    //add columns
    public void addColumns(String title){
        Columns column = new Columns();
        column.setTitle(title);
        columns.add(column);
    }

    //add comments
    public void addComments(Date date, String text, User commentBy){
        Comments comment = new Comments(text, commentBy);
        comments.add(comment);
    }

    //move 
    public void moveTasks(Tasks task, int fromColumnPos, int toColumnPos){
        this.columns.get(fromColumnPos).removeTask(task);
        this.columns.get(toColumnPos).addTask(task);
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
