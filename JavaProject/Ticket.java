import java.util.ArrayList;
public class Ticket extends Film1{
    static int counter;
    int ID;
    public String UserName,MovieName,MovieTime;
    public static final int max_Chair = 100;
    public int price=2000;
    public int NumberChair;
    static ArrayList<Ticket> tickets=new ArrayList<>();
    public Ticket(){}

    public Ticket(String user,String MovieName,String MovieTime){
        UserName=user;
        this.MovieName=MovieName;
        this.MovieTime=MovieTime;
    }
    public double getPrice() {
        return price;
    }

}
