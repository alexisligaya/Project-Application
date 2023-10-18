import java.util.Date;
import java.util.Scanner;

public class ApplicationUI {
    private static final String WELCOME_MESSAGE = "Welcome to out Application";
    private Application application;
    private Scanner scanner;
    private UserList userList;
    
    public ApplicationUI(){
        application = new Application(); 
    }
    public void run(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }

    //sign up
   public void signUp(String firstName, String lastName, String userName, String email, String password, Date dateOfBirth){
        userList.saveUser(userList.addUser("John", "Doe", "jdoe", "jdoe123@gmail.com", "Applepotato123!08", "02/02/02"));
        
   }

    //log in
    public User login(String userName, String password){
        for(User user :  userList.getUsers()){
            if(user.getUserName().equals("jdoe") && user.getPassword().equals("Applepotato123!08")){
                return user;
            }
        }
        return null;
    }
}
