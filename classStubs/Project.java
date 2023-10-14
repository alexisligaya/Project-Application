import java.util.UUID;
import java.util.ArrayList;

public class Project {
    private UUID projectID;
    private String name, description;
    private float rating;
    private boolean isFinished, isPublic;
    private ArrayList<Columns> columnList;
    private ArrayList<User> members;

    public Project(UUID projectID, String name, String description, float rating, boolean isFinished, boolean isPublic, ArrayList<Columns> columnList, ArrayList<User> members){
        this.projectID= projectID;
        this.name = name;
        this.description = description;
        this.rating= rating;
        this.isFinished= isFinished;
        this.isPublic = isPublic;
        this.columnList= columnList;
        this.members= members;
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

    public float getRating(){
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

}
