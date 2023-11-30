package com.model;
import java.time.LocalDate;

public class Comments {

    private LocalDate date;
    private String text;
    private User commentBy;

    /**
     * Constructor for a Comment object with the given parameters
     * 
     * @param date      - date of comment
     * @param text      - comment text/context
     * @param commentBy - user who posted the comment
     */
    public Comments(String text, User commentBy) {
        this.date = LocalDate.now();
        this.text = text;
        this.commentBy = commentBy;
    }

    /**
     * Gets the date of when the comment was posted
     * 
     * @return a Date object
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the content/text of the comment
     * 
     * @return a string representation of the text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the user who made the comment
     * 
     * @return a User object
     */
    public User getCommentBy() {
        return commentBy;
    }

    /**
     * Formats the string of all the information for the comment
     * 
     * @return a formatted string
     */
    public String toString() {
        String result = "Date: " + this.date;
        result += "\nText: " + this.text;
        result += "\nComment By: " + this.commentBy;
        return result;
    }

}
