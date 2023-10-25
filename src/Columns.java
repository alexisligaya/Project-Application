import java.util.ArrayList;

public class Columns {
    private String title;
    private ArrayList<Tasks> tasks;

    //calling this from json
    public Columns(String title, ArrayList<Tasks> tasks) {
        this.title=title;
        this.tasks=tasks;
    }

    //one with empty array list of tasks
    public Columns(){
        
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<Tasks> getTasks(){
        return tasks;
    }
    
    public void addTask (Tasks task){
        tasks.add(task);
    }
   public void removeTask(Tasks task){
    tasks.remove(task);
   }

    public String toString(){
        String result = "Title: " + this.title;
        result += "\nTasks: "+this.tasks;
        return result;
    }

}