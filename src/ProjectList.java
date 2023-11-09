import java.util.ArrayList;

/**
 * Represents a list of projects
 */
public class ProjectList {
    private static ProjectList instance;
    private ArrayList<Project> projects;

    /**
     * Creates a ProjectList object an initializes the list of projects.
     */
    public ProjectList(){
        this.projects= new ArrayList<Project>();
    }

    /** Gets an instance of the ProjectList class.
     * @return The ProjectList instance
     */
    public static ProjectList getInstance(){
        if(instance == null)
            instance = new ProjectList();
        return instance;
    }

    /**
     * Gets a list of projects that match the given project
     * @param title The name of the project to find
     * @return      A list of projects that have titles that match the given project 
     */
    public ArrayList<Project> getProjects(String title){
        ArrayList<Project> matchingProjects = new ArrayList<>();
        for(Project project: projects){
            if(project.getName().equalsIgnoreCase(title)){
                matchingProjects.add(project);
            }
        }
        return matchingProjects;
    }

    /**
     * Gets a project with name and description that match the given one.
     * @param name  The name of the project to be found
     * @param description   The description  of the project to be found
     * @return  The project that matches the given name and description.
     */
    public Project getProjects(String name, String description){
        for(Project project : projects){
            if(project.getName().equals(name) && project.getDescription().equals(description))
                return project;
        }
        return null; //project with given projectID not found
    }

    /**
     * Gets the list of all projects
     * @return The list of all projects
     */
    public ArrayList<Project> getProjects(){
        return projects;
    }

    /**
     * Adds a project to the list
     * @param project The project to be added
     */
    public void addProject(Project project){
        //add to list
        projects.add(project);
    }

    public void loadProjects(){
        this.projects = DataLoader.loadProjects();
        if(this.projects == null){
            this.projects = new ArrayList<Project>();
        }
    }

    /**
     * Removes a project with the same name and description given 
     * @param name  The name of the project to remove
     * @param description   The description of the project to be removed
     * @return True if the project was removed, false if the project was not found
     */
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
    /**
     * Returns the ProjectList objects as a string
     * @return A string containing project information
     */
    public String toString(){
        String result = "Projects: " + this.projects;
        return result;
    }

    /**
     * Saves the projects
     */
    public void saveProjects(){
        DataWriter.saveProjects(projects);
    }
}

