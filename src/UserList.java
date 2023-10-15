import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> users(){
        return users;
    }

    public String toString(){
        String result= "Users: " + this.users;
        return result;
    }
}

