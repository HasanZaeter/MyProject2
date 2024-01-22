import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Film1> list =new ArrayList<>();
        list.add(new Film1(1, "Action","The Walking Dead" ," 11:00 am to 12:45 pm" , "05:00 pm to 06:45 pm"));
        list.add(new Film1(2, "Comidi", "Home Alone","01:00 pm to 02:45 pm", "07:00 pm to 8:45 pm"));
        list.add(new Film1(3, "Drama", "Doctor Who","03:00 pm to 04:45 pm" , "09:00 pm to 10:45 pm"));
        CinemaHall hall1=new CinemaHall("CinemaHall 1",list);
        ArrayList<Film1> list2=new ArrayList<>();
        list2.add(new Film1(4, "Action", "Spider Man"," 11:00 am to 12:45 pm ", "05:00 pm to 06:45 pm"));
        list2.add(new Film1(5, "Comidi","The Office" ," 01:00 pm to 02:45 pm" , "07:00 pm to 8:45 pm"));
        list2.add( new Film1(6, "Drama", "Finestkind"," 03:00 pm to 04:45 pm ", "09:00 pm to 10:45 pm"));
        CinemaHall hall2 =new CinemaHall("CinemaHall 2",list2);
        new Login();
    }
}