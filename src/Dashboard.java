import java.util.ArrayList;

public class Dashboard {
    private ArrayList<Project> listOfProjects;

    public Dashboard(ArrayList<Project> listOfProjects){
        this.listOfProjects = listOfProjects;
    }

    public ArrayList<Project> getListOfProjects(){
        return listOfProjects;
    }

    public String toString(){
        String result = "List of Projects: " + this.listOfProjects;
        return result;
    }
}

