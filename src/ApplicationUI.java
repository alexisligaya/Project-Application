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
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        boolean exit = false;

        while(!exit) {
            System.out.println("1. Login \n2. Signup \n3. Exit");
            int input = keyboard.nextInt();

            if (input == 1) {
                keyboard.nextLine();
                String userName, password;

                int counter = 0;
                boolean loggedIn = false;
                do {
                    System.out.println("Enter username: ");
                    userName = keyboard.nextLine();

                    System.out.println("Enter password: ");
                    password = keyboard.nextLine();

                    if(application.login(userName, password)){
                        System.out.println("Login successfull");
                        loggedIn = true;
                        break;
                    }
                    else {
                        System.out.println("Login failed");
                    }
                    counter++;
                } while(!loggedIn && counter < 3 );

                if(counter == 3) {
                    System.out.println("Failed attempts");
                    System.exit(0);
                }

                if(loggedIn) {
                    boolean running = true;
                    while(running){
                        System.out.println("Projects: ");
        
                        int count = 1;
                        for(Project project : ProjectList.getInstance().getProjects()){
                            System.out.println(count + ". " + project.getName());
                            count++;
                        }
        
                        System.out.println("Which project would you like to open?");
                        int projectChoice = keyboard.nextInt();
                        System.out.println(ProjectList.getInstance().getProjects().get(projectChoice - 1).getName());
                        
                        System.out.println(" 1:Add task \n 2:Move task \n 3:Add comment \n 4. Assign User \n 5. Exit");
        
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
            
                                int userCount = 1;
                                for(User user : UserList.getInstance().getUsers()){
                                    System.out.println(userCount + ". " + user.getfirstName() + " " + user.getLastName());
                                    userCount++;
                                }
                            }
                            else if(input1 == 2){
            
                            }
                            else if(input1 == 3){
            
                            }
                            else if(input1 == 4){
            
                            }
                            else if(input1 == 5){
                                running = false;
                            }
                    }
                }     
            }

            else if (input == 2) {
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

                DataWriter.saveUsers(UserList.getInstance().getUsers());
            }
            else if (input == 3) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args){
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }
}
