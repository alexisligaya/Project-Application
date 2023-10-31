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

        //hardcode AMadden
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try{
            Date dateOfBirth = dateFormat.parse("09/19/2000");
            application.signUp("Atticus", "Madden", "AMadden", "AMadden12@gmail.com", "12345", dateOfBirth);
        }
        catch(ParseException e){
            System.out.println("Error parsing date");
        }

        //hardcode project
            application.addProject("Electric Missiles", "boom");
            application.addProject("Soap Free Washers", "soapy");
            application.addProject("Air Computers", "holy moly");

    }

    public void run(){
        System.out.println(WELCOME_MESSAGE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        
        System.out.println("Enter 1 to login or 2 to signup");
        int input = keyboard.nextInt();
        if(input == 1 ){
            keyboard.nextLine();
            String userName, password;

            int counter = 0;
            do{
                System.out.println("Enter username: ");
                userName = keyboard.nextLine();

                System.out.println("Enter password: ");
                password = keyboard.nextLine();

                application.login(userName, password);
                if(application.login(userName, password)){
                    System.out.println("Login successfull");
                }
                else
                    System.out.println("Login failed");

                counter++;
            }
            while(!application.login(userName, password) && counter < 3 );
            if(counter == 3){
                System.out.println("Failed attempts");
                System.exit(0);
            }
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
            
            Date date = null;

            try {
                date = dateFormat.parse(dateOfBirth);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
            }

            application.signUp(firstName, lastName, userName, email, password, date);
            System.out.println("You signed up");
            }

            boolean running = true;
            while(running){
                System.out.println("Projects: ");

                for(Project project : ProjectList.getInstance().getProjects()){
                    System.out.println(project.getName());

                }

                System.out.println("Which project would you like to open?");
                System.out.println(" 1:Add task \n 2:Move task \n 3:Add comment");

                int input1 = keyboard.nextInt();

                if(input1 == 1){
                    keyboard.nextLine();
                    System.out.println("Enter deadline: ");
                    String deadLine = keyboard.nextLine(); 
                    Date date = null;
                    try {
                        date = dateFormat.parse(deadLine);
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

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }
}
