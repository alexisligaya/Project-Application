import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ApplicationUI {
    
    private static final String WELCOME_MESSAGE = "Welcome to our Application";
    Scanner keyboard = new Scanner(System.in);
    private Application application;
    
    public ApplicationUI() {
        application = new Application();
    }

    public void run() {
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
                        System.out.println("Logged In\n");
                        loggedIn = true;
                        break;
                    }
                    else {
                        System.out.println("Login failed.");
                    }
                    counter++;
                } while(!loggedIn && counter < 3);

                if(counter == 3) {
                    System.out.println("Failed attempts.");
                    System.exit(0);
                }

                if(loggedIn) {
                    boolean running = true;
                    while(running) {
                        //user's current project list
                        //FIX: projects save in json but does not print all projects
                        System.out.println("Your Projects: ");
                        User currentUser = application.getCurrentUser();
                        int projectCount = 1;
                        for(Project project : ProjectList.getInstance().getProjects()){
                            if(project.getMembers().contains(currentUser)){
                                System.out.println(projectCount + ". " + project.getName());
                                projectCount++;
                            }
                        }

                        System.out.println("\n1. Open Project \n2. Create new project \n3. Logout");
                        int count = keyboard.nextInt();

                        //open project
                        if(count == 1){
                            
                        }
                        
                        //create new project
                        else if(count == 2){
                            keyboard.nextLine();

                            System.out.println("\nEnter project name: ");
                            String name = keyboard.nextLine();

                            System.out.println("Enter project description: ");
                            String description = keyboard.nextLine();

                            Project newProject = new Project(name, description);
                            newProject.addMember(currentUser);
                            ProjectList.getInstance().addProject(newProject);

                            System.out.println("Project '" + name + "' created");
                            DataWriter.saveProjects(ProjectList.getInstance().getProjects());
                        }
                        //logout
                        else if(count ==3){
                            System.out.print("Logging out\n");
                            running = false;
                        }
                    }
                }
            } 
            
            //signing up
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
            
            //exit system
            else if (input == 3) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();
    }
}