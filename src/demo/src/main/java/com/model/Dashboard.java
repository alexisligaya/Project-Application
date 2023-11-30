package com.model;
import java.util.ArrayList;
import java.util.UUID;

public class Dashboard {

    private ArrayList<Project> listOfProjects;

    /**
     * Creates a Dashboard object with the given list of projects
     * 
     * @param listOfProjects - an ArrayList of projects
     */
    public Dashboard(ArrayList<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    /**
     * gets the ArrayList of projects
     * 
     * @return an ArrayList of projects
     */
    public ArrayList<Project> getListOfProjects() {
        return listOfProjects;
    }

    /**
     * Formats the string of all the information for the listOfProjects
     * 
     * @return a formatted string
     */
    public String toString() {
        String result = "List of Projects: " + this.listOfProjects;
        return result;
    }

    /**
     * Views the ArrayList of projects
     * 
     * @return an ArrayList of projects
     */
    public ArrayList<Project> viewProjects() {
        return listOfProjects;
    }

    /**
     * Search for a project in the list of projects by its ID
     * 
     * @param projectID - unique project ID (UUID)
     * @return the Project object with its project ID, null if not found
     */
    public Project searchProject(UUID projectID) {
        for (Project project : listOfProjects) {
            if (project.getProjectID().equals(projectID)) {
                return project;
            }
        }
        return null;
    }

    /**
     * Sort the list of projects by date
     * 
     * @return an ArrayList of sorted projects
     */
    public ArrayList<Project> sortProjectsByDate() {
        // Implement logic to sort the list of projects by date and return the sorted
        // list
        return new ArrayList<Project>();
    }
}
