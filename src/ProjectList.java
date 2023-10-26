import java.util.ArrayList;

public class ProjectList {
    private static ProjectList instance;
    private ArrayList<Project> projects;

    public ProjectList(){
        this.projects= new ArrayList<Project>();
    }

    public static ProjectList getInstance(){
        if(instance == null)
            instance = new ProjectList();
        return instance;
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public Project getProjects(String name, String description){
        for(Project projects : projects){
                return projects;
        }
        return null; //project with given projectID not found
    }

    public boolean addProject(String name, String description){
        //validate
        if(name == null || description == null)
            return false;

        //make a project
        for(Project projects : projects)
            if(projects.getName().equals(name) || projects.getDescription().equals(description))
                return false;

        //add to list
        Project newProject = new Project(name, description);
        projects.add(newProject);

        //create newProject if successful
        return true;
    }

    public String toString(){
        String result = "Projects: " + this.projects;
        return result;
    }

    public void saveProjects(){
        DataWriter.saveProjects();
    }
}

