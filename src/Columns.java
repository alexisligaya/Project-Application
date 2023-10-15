import java.util.ArrayList;

public class Columns {
    private String title;
    private ArrayList<Tasks> tasks;

    public Columns(String title, ArrayList<Tasks> tasks) {
        this.title=title;
        this.tasks=tasks;
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<Tasks> getTasks(){
        return tasks;
    }

}