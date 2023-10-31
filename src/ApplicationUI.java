import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ApplicationUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Application";
    Scanner keyboard = new Scanner(System.in);
    private Application application;
    
    public ApplicationUI(){
        application = new Application();
    }

    public void run(){
        
        System.out.println(WELCOME_MESSAGE);
        
        System.out.println("Enter 1 to login or 2 to signup");
        int input = keyboard.nextInt();
        if(input == 1 ){
            keyboard.nextLine();
            System.out.println("Enter username: ");
            String userName = keyboard.nextLine();

            System.out.println("Enter password: ");
            String password = keyboard.nextLine();

            application.login(userName, password);
        }
        else if (input == 2){
            keyboard.nextLine();
            System.out.println("Enter first name: ");
            String firstName = keyboard.nextLine();
            System.out.println("Enter last name: ");
            String lastName = keyboard.nextLine();
            System.out.println("Enter user name: ");
            String userName = keyboard.nextLine();
            System.out.println("Enter email: ");
            String email = keyboard.nextLine();
            System.out.println("Enter password: ");
            String password= keyboard.nextLine();
            System.out.println("Enter date of birth (mm/dd/yyyy): ");
            String dateOfBirth = keyboard.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            Date date = null;

            try {
                date = dateFormat.parse(dateOfBirth);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
            }

            application.signUp(firstName, lastName, userName, email, password, date);
            System.out.println("You signed up");

            boolean running = true;
            while(running){
                System.out.println("Projects: ");
                System.out.println("Which project would you like to open?");
                System.out.println("1: Add task \n 2: Move task \n 3: Add comment");

                int input1 = keyboard.nextInt();

                if(input1 == 1){
                    keyboard.nextLine();
                    System.out.println("Enter deadline: ");
                    String deadLine = keyboard.nextLine(); 
                    try {
                        date = dateFormat.parse(dateOfBirth);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format");
                    }

                    System.out.println("Enter task description: ");
                    String taskDescription = keyboard.nextLine();

                    System.out.println("Enter priority: ");
                    int priority = keyboard.nextInt();

                    System.out.println("Enter hours: ");
                    Double hours = keyboard.nextDouble();

                    System.out.println("Assign a user: ");

                    
                }
                else if(input1 == 2){

                }
                else if(input1 == 3){

                }

            }

        }

        
    }

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }
}
