import javax.swing.*;
import java.io.*;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Scanner;

public class Ticketing extends Ticket{
     //ArrayList<Ticket> tickets=new ArrayList<>();
    public  synchronized  void TicketBooking(String userName,int balance,String selectedMovie,String selectedTime,int selectedNumberOfChair,ArrayList<Film1> list) {
        //ReadFromFileTickets();
        String message="";
        int i=1,chair = 0;
        ReadFromFileNumberSeats(list);
        try{
            BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Tickets.txt"));
            String line;
            int counter=0;
            while((line = reader.readLine())!=null){
                String []parts=line.split(",");
                if(parts.length==0)
                    break;
                counter =Integer.parseInt(parts[4]);
            }
            Ticket.counter=counter+1;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        for(Film1 movie : list) {
            if (selectedMovie.equals(movie.getMoveName()) && i <= 3) {
                if (selectedTime.equals(movie.showTimesFirst.time)) {
                    if (selectedNumberOfChair <=movie.showTimesFirst.NumberChair && selectedNumberOfChair*price <=balance ) {
                        changeBalance(userName,- (selectedNumberOfChair*price));
                        Ticket ticket =new Ticket(userName,selectedMovie,selectedTime);
                        chair = selectedNumberOfChair;
                        movie.showTimesFirst.NumberChair -= chair;
                        ticket.NumberChair = chair;
                        ticket.ID = Ticket.counter++;
                        tickets.add(ticket);
                        message = Message(selectedMovie, selectedTime, ticket.price, chair, movie.showTimesFirst.counter, selectedNumberOfChair, ticket.ID);
                        movie.showTimesFirst.counter += chair;
                        JOptionPane.showMessageDialog(null, message, "Ticket Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        WriteInTickets(ticket);
                    }else if( selectedNumberOfChair*price >balance){
                        JOptionPane.showMessageDialog(null,"You do not have enough money");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Number of Seats available  " + movie.showTimesFirst.NumberChair, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if (selectedTime.equals(movie.showTimesReplay.time)) {
                    if (selectedNumberOfChair <= movie.showTimesReplay.NumberChair && selectedNumberOfChair*price <=balance) {
                        changeBalance(userName,- (selectedNumberOfChair*price));
                        Ticket ticket =new Ticket(userName,selectedMovie,selectedTime);
                        chair = selectedNumberOfChair;
                        movie.showTimesReplay.NumberChair -= chair;
                        ticket.NumberChair = chair;
                        ticket.ID = Ticket.counter++;
                        tickets.add(ticket);
                        message = Message(selectedMovie, selectedTime, ticket.price, chair, movie.showTimesReplay.counter, selectedNumberOfChair, ticket.ID);
                        movie.showTimesReplay.counter += chair;
                        JOptionPane.showMessageDialog(null, message, "Ticket Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        WriteInTickets(ticket);
                    }
                    else if( selectedNumberOfChair*price >balance){
                        JOptionPane.showMessageDialog(null,"You do not have enough money");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Number of Seats available  " + movie.showTimesFirst.NumberChair, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            } else if (selectedMovie.equals(movie.getMoveName()) && i > 3 && i <= 6) {
                if (selectedTime.equals(movie.showTimesFirst.time)) {
                    if (selectedNumberOfChair <= Ticket.max_Chair  && selectedNumberOfChair*price <=balance) {
                        changeBalance(userName,- (selectedNumberOfChair*price));
                        Ticket ticket =new Ticket(userName,selectedMovie,selectedTime);
                        chair = selectedNumberOfChair;
                        movie.showTimesFirst.NumberChair -= chair;
                        ticket.NumberChair = chair;
                        ticket.ID = Ticket.counter++;
                        tickets.add(ticket);
                        message = Message(selectedMovie, selectedTime, ticket.price, chair, movie.showTimesFirst.counter, selectedNumberOfChair, ticket.ID);
                        movie.showTimesFirst.counter += chair;
                        JOptionPane.showMessageDialog(null, message, "Ticket Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        WriteInTickets(ticket);
                    } else if( selectedNumberOfChair*price >balance){
                        JOptionPane.showMessageDialog(null,"You do not have enough money");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Number of Seats available  " + movie.showTimesFirst.NumberChair, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if (selectedTime.equals(movie.showTimesReplay.time)) {
                    if (selectedNumberOfChair <= Ticket.max_Chair && selectedNumberOfChair*price<=balance) {
                        changeBalance(userName,- (selectedNumberOfChair*price));
                        Ticket ticket =new Ticket(userName,selectedMovie,selectedTime);
                        chair = selectedNumberOfChair;
                        movie.showTimesReplay.NumberChair -= chair;
                        ticket.NumberChair = chair;
                        ticket.ID = Ticket.counter++;
                        tickets.add(ticket);
                        message = Message(selectedMovie, selectedTime, ticket.price, chair, movie.showTimesReplay.counter, selectedNumberOfChair, ticket.ID);
                        movie.showTimesReplay.counter += chair;
                        JOptionPane.showMessageDialog(null, message, "Ticket Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        WriteInTickets(ticket);
                    }else if( selectedNumberOfChair*price >balance){
                        JOptionPane.showMessageDialog(null,"You do not have enough money");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Number of Seats available  " + movie.showTimesFirst.NumberChair, "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            i++;
        }
        //StoreInFileTickets();
        WriteInFileNumberSeats(list);
    }
    public static void changeBalance(String user, int money){
     ArrayList<User> users =new ArrayList<>();
        try{
            BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
            String line;
            while((line =reader.readLine())!=null){
                String []parts=line.split(",");
                users.add(new User(parts[0],parts[1],Integer.parseInt(parts[2])));
            }
            for(User u : users){
                if(u.UserAccount.equals(user)){
                    u.balance+=money;
                    //System.out.println(u.balance);
                    break;
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\User.txt"));
            for(User u:users){
                writer.write(u.UserAccount+","+u.AccountPassWord+","+u.balance);
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public void WriteInTickets(Ticket ticket){
        try{
            BufferedWriter writer =new BufferedWriter(new FileWriter("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Tickets.txt",true));
            writer.write(ticket.UserName + "," + ticket.MovieName + "," + ticket.MovieTime + "," + ticket.NumberChair + "," + ticket.ID + "\n");
            writer.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void ReadFromFileTickets(){
        try{
            BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Tickets.txt"));
            String line;
            Ticket ticket;
            // int counter=1;
            while((line=reader.readLine()) != null){
                String []parts=line.split(",");
                ticket =new Ticket(parts[0],parts[1],parts[2]);
                ticket.NumberChair=Integer.parseInt(parts[3]);
                ticket.ID=Integer.parseInt(parts[4]);
                tickets.add(ticket);
            }
            // Ticket.counter=counter;
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void ReadFromFileNumberSeats(ArrayList<Film1> movies) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\NumberSeats.txt"));
            String line;
            while((line=reader.readLine()) !=null){
               String []parts=line.split(",");
               for(Film1 movie :movies){
                   if(movie.getMoveName().equals(parts[0]) && movie.showTimesFirst.time.equals(parts[1])){
                       movie.showTimesFirst.counter=Integer.parseInt(parts[3]);//11
                       movie.showTimesFirst.NumberChair=Integer.parseInt(parts[2]);//90
                   }
                   else if(movie.getMoveName().equals(parts[0])&& movie.showTimesReplay.time.equals(parts[1])){
                       movie.showTimesReplay.counter=Integer.parseInt(parts[3]);
                       movie.showTimesReplay.NumberChair=Integer.parseInt(parts[2]);
                   }
               }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void WriteInFileTickets(){
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\Tickets.txt",false));
            for(Ticket t:tickets){
                writer.write(t.UserName + "," + t.MovieName + "," + t.MovieTime + "," + t.NumberChair + "," + t.ID + "\n");
                writer.flush();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void WriteInFileNumberSeats(ArrayList<Film1> movies){
        try{
            BufferedWriter writer =new BufferedWriter(new FileWriter("C:\\Users\\Hasan\\IdeaProjects\\Swing\\src\\NumberSeats.txt",false));
            for(Film1 movie : movies) {

                writer.write(movie.getMoveName() + "," + movie.showTimesFirst.time + "," + movie.showTimesFirst.NumberChair + "," + movie.showTimesFirst.counter + "\n");
                writer.write(movie.getMoveName() + "," + movie.showTimesReplay.time + "," + movie.showTimesReplay.NumberChair + "," + movie.showTimesReplay.counter + "\n");
                writer.flush();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static boolean CancelTicket(int ticket,ArrayList<Film1> movies,String username){
        int balance =0;
        tickets.clear();
        ReadFromFileTickets();
        for(Ticket ticket1 : tickets){
           if(ticket1.ID==ticket && ticket1.UserName.equals(username))
           {
               balance=ticket1.price*ticket1.NumberChair;
               tickets.remove(ReTurnTicket(ticket));
               Function(ticket1.MovieName,ticket1.MovieTime,ticket1.NumberChair,movies);
               changeBalance(username,balance);
               WriteInFileNumberSeats(movies);
               return true;
           }
       }
       return false;
    }

    public static void Function(String name,String time ,int number,ArrayList<Film1> movies){
        ReadFromFileNumberSeats(movies);
        for(Film1 movie : movies){
            if(movie.getMoveName().equals(name) && time.equals(movie.showTimesFirst.time)){
                movie.showTimesFirst.NumberChair+=number;
                movie.showTimesFirst.counter-=number;
            }
            else if(name.equals(movie.getMoveName()) && time.equals(movie.showTimesReplay.time)){
                movie.showTimesReplay.NumberChair+=number;
                movie.showTimesReplay.counter-=number;
            }
        }

    }

    public static Ticket ReTurnTicket(int ticket){
       Ticket ticket1=new Ticket();
       for(Ticket t: tickets){
           if(t.ID==ticket) {
               ticket1=t;
               break;
           }
       }

        return ticket1;
    }

    public static String Message(String Name,String Time,int price,int seat,int counter,int Number,int ticketNumber){
        return "Ticket booked for : \nMovie : "+Name+"\nTime "+Time+"\nPrice of Tiket :"+price+
                "\n CinemaHall : 1"+" and number of Seat is "+seat+"\nSeat numbers in the cinema hall "+printSeat(counter,Number)+"\nTotalPrice is "+price * seat+"\n Number Of Ticket is "+ticketNumber;
    }

    public static String printSeat(int count,int num){
        String number="";
        for(int i=count ;i<(count+num);i++) {
            if((i-count) % 10 ==0)
               number+="\n";
            number+=i+" ";
        }
        return number;
    }
}
