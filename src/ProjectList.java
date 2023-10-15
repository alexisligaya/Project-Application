import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> projects;

    public ProjectList(ArrayList<Project> projects){
        this.projects=projects;
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public String toString(){
        String result = "Projects: " + this.projects;
        return result;
    }
}

