import java.util.ArrayList;

public class Application {
    private ArrayList<Project> currentProject;
    private ArrayList<User> currentUsers;
    private ArrayList<Team> team;
    private ArrayList<Project> archivedProjects;

    public Application(ArrayList<Project> currentProject, ArrayList<Team> team, ArrayList<User> currentUsers, ArrayList<Project> archivedProjects){
        this.currentProject=currentProject;
        this.currentUsers=currentUsers;
        this.team=team;
        this.archivedProjects=archivedProjects;
    }

    public ArrayList<Project> getCurrentProject(){
        return currentProject;
    }

    public ArrayList<User> getCurrentUsers(){
        return currentUsers;
    }

    public ArrayList<Team> getTeam(){
        return team;
    }

    public ArrayList<Project> getArchivedProjects(){
        return archivedProjects;
    }
}
