import  java.util.ArrayList;
public class CinemaHall extends Film1 {
    String name;
    String filmName;
    ArrayList<Film1> list;
    public CinemaHall(String name, ArrayList<Film1>list ) {
        this.list=list;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void print () {
        System.out.println(name + "   ");
        for(Film1 film:list){
            film.PrintInfoFilm();
        }
    }
}