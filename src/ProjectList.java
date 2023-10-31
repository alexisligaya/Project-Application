import java.util.ArrayList;

public class ProjectList {
    private static ProjectList instance;
    private ArrayList<Project> projects;

    public ProjectList(){
        this.projects= DataLoader.loadProjects();
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

    public boolean addProject(String name, String description){
        //validate
        if(name == null || description == null)
            return false;

        //make a project
        for(Project projects : projects){
            if(projects.getName().equals(name) || projects.getDescription().equals(description))
                return false;
        }
        //add to list
        Project newProject = new Project(name, description);
        projects.add(newProject);

        //create newProject if successful
        return true;
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

