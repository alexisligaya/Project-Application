import java.util.ArrayList;

public class Team {
    private ArrayList<User> members;
    private User productOwner;
    private User scrumMaster;
    private ArrayList<User> scrumTeamMembers;
    private ArrayList<Project> projects;

    public Team(ArrayList<User> members, User productOwner, User scrumMaster, ArrayList<User> scrumTeamMembers, ArrayList<Project> projects){
        this.members=members;
        this.productOwner=productOwner;
        this.scrumMaster=scrumMaster;
        this.scrumTeamMembers=scrumTeamMembers;
        this.projects=projects;
    }

    public ArrayList<User> getMembers(){
        return members;
    }

    public User getProductOwner(){
        return productOwner;
    }

    public User getScrumMaster(){
        return scrumMaster;
    }

    public ArrayList<User> getScrumTeamMembers(){
        return scrumTeamMembers;
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

}   
