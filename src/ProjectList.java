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

    public ArrayList<Project> getProjects(String title){
        ArrayList<Project> matchingProjects = new ArrayList<>();
        for(Project project: projects){
            if(project.getName().equalsIgnoreCase(title)){
                matchingProjects.add(project);
            }
        }
        return matchingProjects;
    }

    public Project getProjects(String name, String description){
        for(Project project : projects){
            if(project.getName().equals(name) && project.getDescription().equals(description))
                return project;
        }
        return null; //project with given projectID not found
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public void addProject(Project project){
        //add to list
        projects.add(project);

    }


    public boolean removeProject(String name, String description) {
        Project projectToRemove = null;
       
        for (Project project : projects) {
            if (project.getName().equals(name) && project.getDescription().equals(description)) {
                projectToRemove = project;
                break;
            }
        }
        if (projectToRemove != null) {
            projects.remove(projectToRemove);
            return true;
        } 
        else 
            return false;
    }

    public String toString(){
        String result = "Projects: " + this.projects;
        return result;
    }

    public void saveProjects(){
        DataWriter.saveProjects(projects);
    }
}

