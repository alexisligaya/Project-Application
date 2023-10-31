import java.util.ArrayList;

public class Columns {
    private String title;
    private ArrayList<Tasks> tasks;

    /**
     * Constructor for a Columns object with the given parameters
     * 
     * @param title - title of column
     * @param tasks - an ArrayList of tasks
     */
    public Columns(String title, ArrayList<Tasks> tasks) {
        this.title = title;
        this.tasks = tasks;
    }

    /**
     * One with an empty ArrayList of tasks
     */
    public Columns() {
        this.title = "Backlog";
        this.tasks= new ArrayList<>();
    }

    /**
     * Gets the title of the column
     * 
     * @return a string representation of the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the ArrayList of tasks for this column
     * 
     * @return an ArrayList of tasks
     */
    public ArrayList<Tasks> getTasks() {
        return tasks;
    }


    public void setTitle(String title){
        this.title=title;
    }

    /**
     * Adds a task to the ArrayList of tasks for this column
     * 
     * @param task - an ArrayList of tasks
     */
    public void addTask(Tasks task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the ArrayList of tasks for this column
     * 
     * @param task - an ArrayList of tasks
     */
    public void removeTask(Tasks task) {
        tasks.remove(task);
    }

    /**
     * Formats the string of all the information for the column
     * 
     * @return a formatted string
     */
    public String toString() {
        String result = "Title: " + this.title;
        result += "\nTasks: " + this.tasks;
        return result;
    }

}