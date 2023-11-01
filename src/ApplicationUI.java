import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

public class ApplicationUI {
    
    private static final String WELCOME_MESSAGE = "Welcome to our Application";
    Scanner keyboard = new Scanner(System.in);
    private Application application;
    
    public ApplicationUI() {
        application = new Application();
        
    }
    

    public void run() {
        hardcore();
        System.out.println(WELCOME_MESSAGE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

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
                        System.out.println("\nLogged In");
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

                        //user's current project list
                        System.out.println("\n---Your Projects--- \nElectric Missiles \nSoap Free Washers \nAir Computers");
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
                            System.out.println("\nSelect project to open: ");
                            System.out.println("1. Electric Missiles \n2. Soap Free Washers \n3. Air Computers\n");
                            int projToOpen = keyboard.nextInt();
                            if(projToOpen == 1)
                                System.out.println("Select choice: \n1. Add Task \n2. Move Task \n3. Remove Task \n4. Print project to scrum board\n");
                           
                            int choice = keyboard.nextInt();
                            if(choice == 4 ){
                                System.out.println("Printing project to scrum board!\n");
                            }
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
                System.out.println("Enter company");
                String company= keyboard.nextLine();
                System.out.println("Enter date of birth (mm/dd/yyyy): ");
                String dateOfBirth = keyboard.nextLine();

                Date date = null;

                try {
                    date = dateFormat.parse(dateOfBirth);
                } catch (ParseException e) {
                    System.out.println("Invalid date format");
                }

                application.signUp(firstName, lastName, userName, email, password, company, date);
                System.out.println("You signed up");

                DataWriter.saveUsers(UserList.getInstance().getUsers());
            } 
            
            //exit system
            else if (input == 3) {
                System.exit(0);
            }
    }


    public void hardcore(){

        //hardcode user
        ArrayList<User> users = UserList.getInstance().getUsers();
        User user1 = new User( 
            UUID.randomUUID(),
            "Atticus", 
            "Madden", 
            "AMadden", 
            "AMadden12@gmail.com",
            "123", 
            "Code Mission Possible",
            new Date());

       User user2 = new User( 
            UUID.randomUUID(),
            "Jeff", 
            "Goldblum", 
            "JGold", 
            "JGold12@gmail.com",
            "123", 
            "None",
            new Date());

       User user3 = new User( 
            UUID.randomUUID(),
            "Atticus", 
            "Finch", 
            "AFinch", 
            "AF12@gmail.com",
            "123", 
            "Code Mission Possible",
            new Date());


        users.add(user1);
        users.add(user2);
        users.add(user3);
        DataWriter.saveUsers(users);

        //hardcode projects
        ArrayList<Project> projects = ProjectList.getInstance().getProjects();
        ArrayList<User> projectUsers = new ArrayList<>();
        projectUsers.add(user1);
        
        //project 1
        Project proj1 = new Project(
        "Electric Missiles", 
        "boom");

        //project 2
        Project proj2 = new Project(
        "Soap Free Washers", 
        "soapy");

        //project 3
        Project proj3 = new Project(
        "Air Computers", 
        "airy");

       proj1.addColumns("Doing");
       proj1.addColumns("Abandoned");
       proj1.addColumns("Done");

       Tasks currTask = proj1.addTasks("Initialize super algorithm to detonate at warp speed");
       currTask.assignUser(user2);
       currTask.addComment(new Comments("Avoid civilians Jeff!", user1));

       currTask = proj1.addTasks("Curve the metal to make a cylindrical shape");
       currTask.assignUser(user1);
       proj1.moveTasks(currTask, 0, 1);
       currTask.addComment(new Comments("Not cylindrical enough", user2));
       currTask.addComment(new Comments("What's a cylinder", user3));
       currTask.addComment(new Comments("How about you do it jeff", user1));
       currTask.assignUser(user2);

       currTask = proj1.addTasks("Make impossible burger possible");
       proj1.moveTasks(currTask, 0, 2);

        projects.add(proj1);
        projects.add(proj2);
        projects.add(proj3);
        DataWriter.saveProjects(projects);
    }


    public static void main(String[] args) {
        ApplicationUI applicationInterface = new ApplicationUI();
        applicationInterface.run();

   }
}
