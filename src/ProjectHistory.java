import java.util.ArrayList;
import java.util.Date;

public class ProjectHistory {
    private ArrayList<Change> changes;
    private Date lastUpdate;

    public ProjectHistory(ArrayList<Change> changes, Date lastUpdate){
        this.changes=changes;
        this.lastUpdate=lastUpdate;
    }

    public ArrayList<Change> changes(){
        return changes;
    }

    public Date lastUpdate(){
        return lastUpdate;
    }
    public void addChange(User user, String description){
        Change change = new Change(description, new Date(), user, null);
        changes.add(change);
        lastUpdate = new Date();
    }

    public boolean removeChange(Change change) {
        return changes.remove(change);
    }

    public ArrayList<Change> getAllChanges(){
        return changes;
    }

    public String toString(){
        String result = "Changes: " + this.changes;
        result += "\nLast Update: "+this.lastUpdate;
        return result;
    }
}
