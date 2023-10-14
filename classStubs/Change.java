import java.util.Date;

public class Change {
    private String description;
    private Date date;
    private User user;
    private Project project;

    public Change(String description, Date date, User user, Project project){
        this.description=description;
        this.date=date;
        this.user= user;
        this.project=project;
    }

    public String getDescription(){
        return description;
    }
    
    public Date getDate(){
        return date;
    }

    public User getUser(){
        return user;
    }

    public Project getProject(){
        return project;
    }
}
