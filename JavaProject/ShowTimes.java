import java.util.ArrayList;

public class ShowTimes {
    public String time;
    public int NumberChair=100;
    public  int counter=1;
//    ArrayList<Ticket> TicketList=new ArrayList<>();
    public ShowTimes(){}
    public ShowTimes(String time,ArrayList<Ticket> list){
        //this.TicketList.addAll(list);
        this.time=time;
    }



    public void setTime(String time) {
        this.time = time;
    }

    public String getTime(){return time;}
}
