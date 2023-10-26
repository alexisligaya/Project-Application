import java.util.Date;
import java.util.ArrayList;

public class Comments {
    private Date date;
    private String text;
    private User commentBy;
    private ArrayList<Comments> commentList;

    public Comments(Date date, String text, User commentBy, ArrayList<Comments> commentList){
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

    public ArrayList<Comments> getCommentList(){
        return commentList;
    }

    public String toString(){
        String result = "Date: " + this.date;
        result += "\nText: "+this.text;
        result += "\nComment By: " + this.commentBy;
        return result;
    }

}
