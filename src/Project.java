import java.util.UUID;
import org.json.simple.JSONArray;
import java.util.ArrayList;

public class Project {
    private UUID projectID;
    private String name, description;
    private double rating;
    private boolean isFinished, isPublic;
    private ArrayList<Columns> columnList;
    private ArrayList<User> members;
    private static Project instance;

    public Project(UUID projectID, String name, String description, double rating, boolean isFinished, boolean isPublic, ArrayList<Columns> columnList, ArrayList<User> members){
        this.projectID= projectID;
        this.name = name;
        this.description = description;
        this.rating= rating;
        this.isFinished= isFinished;
        this.isPublic = isPublic;
        this.columnList= columnList;
        this.members= members;
    }


    public Project(String name, String description){
        this.projectID= UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public Project(){
        this.projectID = UUID.randomUUID();
        this.name = "New Project";
        this.description = "Enter description here";
        this.rating= 1f;
        this.isFinished= false;
        this.isPublic = false;
        this.columnList= new ArrayList<>();
        this.members= new ArrayList<>();
    }

    Project(String projectID2, String name2, String description2, float rating2, boolean isFinished2, boolean isPublic2, JSONArray columnList2){

    }

    //set name

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
        return columnList;
    }

    public ArrayList<User> getMembers(){
        return members;
    }

    public static Project getInstance(){
        if(instance == null)
            instance = new Project(UUID.randomUUID(), "myProject", "this is my project", ("a", "b", "c") );
        return instance;
    }

    public String toString(){
        String result = "Project ID: " + this.projectID;
        result += "\nName: "+this.name;
        result += "\nDescription: " + this.description;
        result += "\nRating: " + this.rating;
        result += "\nIs Finished: " + this.isFinished;
        result += "\nIs Public: " + this.isPublic;
        result += "\nColumn List: " + this.columnList;
        result += "\nMembers: " + this.members;
        return result;
    }

}
