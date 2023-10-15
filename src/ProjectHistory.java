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

}
