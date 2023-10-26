import java.util.Date;

public class ApplicationUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Application";
    private Application application;
    
    public ApplicationUI(){
        application = new Application();
    }

    public void run(){
        System.out.println(WELCOME_MESSAGE);

        //user login and sign up test
        if(application.signUp("amy", "smith","asmith", "asmiths@gmail.com", "12345", new Date())){
            System.out.println("You've successfully signed up");
        } else {
            System.out.println("Sorry, you couldn't signup.");
        }
        application.logout();

        if(application.login("asmith", "12345")){
            System.out.println("You've successfully logged in");
        } else {
            System.out.println("Sorry, you couldn't login");
        }

        //project test
        
    }

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }
}
