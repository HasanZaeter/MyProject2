
public class Film1 {
    private int moveNumber;
    private String moveType;
    ShowTimes showTimesFirst =new ShowTimes(),showTimesReplay=new ShowTimes();
    private String moveName;

    public Film1() {
    }

    public Film1(int moveNumber, String moveType, String moveName, String showTimesFirst,String showTimesReplay) {
        this.moveNumber = moveNumber;
        this.moveType = moveType;
        try {
            this.showTimesFirst.time=showTimesFirst;
            this.showTimesReplay.time= showTimesReplay;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        this.moveName = moveName;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getMoveName() {
        return moveName;
    }

    public ShowTimes getShowTimesFirst() {
        return showTimesFirst;
    }

    public ShowTimes getShowTimesReplay() {
        return showTimesReplay;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public void PrintInfoFilm(){
        System.out.print(getMoveNumber() +" "+getMoveType() +" "+getMoveName()+" "+getShowTimesFirst().getTime()+" "+getShowTimesReplay().getTime());
        System.out.println();
    }
}
