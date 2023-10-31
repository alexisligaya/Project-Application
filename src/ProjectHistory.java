import java.util.ArrayList;
import java.util.Date;

/**
 * Represents the history of changes associated with a project
 */
public class ProjectHistory {
    private ArrayList<Change> changes;
    private Date lastUpdate;

    /**
     * Constructs a ProjectHistory object with the provided list of changes and the date of the last update.
     * @param changes
     * @param lastUpdate
     */
    public ProjectHistory(ArrayList<Change> changes, Date lastUpdate){
        this.changes=changes;
        this.lastUpdate=lastUpdate;
    }

    /**
     * Gets the list of changes in the project's history
     * @return  The list of changes associated with the project's history.
     */
    public ArrayList<Change> changes(){
        return changes;
    }

   /**Gets the date of the last update in the project's history
    * @return The date of the last update.
    */
public Date getLastUpdate(){
    return lastUpdate;
   }
   
    /**
     * Adds a new change to the project's history.
     * @param user  The user who made the change.
     * @param description The description of the change.
     */
    public void addChange(User user, String description){
        //NOTE: implement when project history is used
        //Change change = new Change(description, new Date(), user, null);
        //changes.add(change);
        lastUpdate = new Date();
    }

    /**
     * Removes a specific change from the project's history.
     * @param change The change to be removed.
     * @return  True if the change was removed, false otherwise
     */
    public boolean removeChange(Change change) {
        return changes.remove(change);
    }

    /**
     * Gets all the changes in the project's history
     * @return  The list of all changes in the project's history.
     */
    public ArrayList<Change> getAllChanges(){
        return changes;
    }
    /**
     * Returns the ProjectHistory object as a string 
     * @return A string containing the project history information
     */
    public String toString(){
        String result = "Changes: " + this.changes;
        result += "\nLast Update: "+this.lastUpdate;
        return result;
    }
}
