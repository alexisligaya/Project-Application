import java.util.Date;

public class Comments {
    private Date date;
    private String text;
    private User commentBy;

    public Comments(Date date, String text, User commentBy){
        this.date= date;
        this.text= text;
        this.commentBy = commentBy;
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

    public String toString(){
        String result = "Date: " + this.date;
        result += "\nText: "+this.text;
        result += "\nComment By: " + this.commentBy;
        return result;
    }

}
