import java.util.ArrayList;
import java.util.UUID;

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

    public ArrayList<Project> viewProjects(){
        return listOfProjects;
    }

    public Project searchProject(UUID projectID){
        for(Project project : listOfProjects){
            if(project.getProjectID().equals(projectID)){
                return project;
            }
        }
        return null;
    }
     public ArrayList<Project> sortProjectsByDate() {
        // Implement logic to sort the list of projects by date and return the sorted list
        return new ArrayList<Project>();
    }
}

