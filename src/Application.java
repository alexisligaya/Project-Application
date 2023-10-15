
public class Application {
    private User users;
    private Project project;
    private Team team;

    public Application(){
        users=User.getInstance();
        project=Project.getInstance();
        team=Team.getInstance();
    }

    public User getUsers(){
        return users;
    }

    public Project getProject(){
        return project;
    }

    public Team getTeam(){
        return team;
    }

    public boolean login(String userName, String password){ //user logs in
        return true;
    }
}
