import java.util.Scanner;

public class ApplicationUI {
    private static final String WELCOME_MESSAGE = "Welcome to out Application";
    private Application application;
    private Scanner scanner;
    
    ApplicationUI(){
        application = new Application(); 
    }
    public void run(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }

}
