import java.util.Date;
import java.util.ArrayList;

public class Comment {
    private Date date;
    private String text;
    private User commentBy;
    private ArrayList<Comment> commentList;

    public Comment(Date date, String text, User commentBy, ArrayList<Comment> commentList){
        this.date= date;
        this.text= text;
        this.commentList=commentList;
    }

    public Date getDate(){
        return date;
    }

    public String getText(){
        return text;
    }

    public User getCommentBy(){
        return commentBy;
    }

    public ArrayList<Comment> getCommentList(){
        return commentList;
    }

    public String toString(){
        String result = "Date: " + this.date;
        result += "\nText: "+this.text;
        result += "\nComment By: " + this.commentBy;
        return result;
    }

}
