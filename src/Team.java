import java.util.ArrayList;

/**
 * Represents a team
 */
public class Team {
    private ArrayList<User> members;
    private User productOwner;
    private User scrumMaster;
    private ArrayList<User> scrumTeamMembers;
    private ArrayList<Project> projects;
    private static Team instance;

    /**Creates a Team object with the given parameters.
     * @param members           The members in the team.
     * @param productOwner      The user assigned as prodcut owner
     * @param scrumMaster       The user assigned as scrum master
     * @param scrumTeamMembers  The members in the scrum team
     * @param projects          The projects of the team
     */
    public Team(ArrayList<User> members, User productOwner, User scrumMaster, ArrayList<User> scrumTeamMembers, ArrayList<Project> projects){
        this.members=members;
        this.productOwner=productOwner;
        this.scrumMaster=scrumMaster;
        this.scrumTeamMembers=scrumTeamMembers;
        this.projects=projects;
    }
    
    private Team(){
        this.members = new ArrayList<>();
        this.scrumTeamMembers = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    /**
     * Gets the list of team members
     * @return The array list of members.
     */
    public ArrayList<User> getMembers(){
        return members;
    }

    /**
     * Gets the product owner of the team
     * @return The product owner user.
     */
    public User getProductOwner(){
        return productOwner;
    }

    /**
     * Gets the scrum master of the team
     * @return The scrum master user
     */
    public User getScrumMaster(){
        return scrumMaster;
    }

    /**
     * Gets the list of the scrum team members.
     * @return The array list of scrum team members.
     */
    public ArrayList<User> getScrumTeamMembers(){
        return scrumTeamMembers;
    }

    /**
     * Gets the list of projects the team has.
     * @return The array list of projects
     */
    public ArrayList<Project> getProjects(){
        return projects;
    }

    /**
     * Gets an isntance of the Team class.
     * @return The Team instance.
     */
    public static Team getInstance(){
        if(instance == null){
            instance = new Team();
        }
        return instance;
    }

    /**
    * Removes a scrum team member from the team
    * @param user The user to be removed from the scrum team
    * @return True if the user was removed. false if user is not in the scrum team.
    */
public boolean removeScrumTeamMember(User user){
    if(scrumTeamMembers.contains(user)){
        scrumTeamMembers.remove(user);
        return true;
    }
    else{
        return false;
    }
  }

    /**
     * Adds a user to the list of scrum team members.
     * @param user The user to be added to the scrum team
     */
    public void addScrumTeamMember(User user){
        scrumTeamMembers.add(user);
    }
    /** Prints the team object as a string.
     * @return a string containing Team information.
     */

    public void addProject(Project project){
        projects.add(project);
        for(User member : members){
            project.addMember(member);
        }
    }


    public String toString(){
        String result = "Members: " + this.members;
        result += "\nProduct Owner: "+this.productOwner;
        result += "\nScrum Master: " + this.scrumMaster;
        result += "\nScrum Team Members: " + this.scrumTeamMembers;
        result += "\nProjects: " + this.projects;
        return result;
    }
}

