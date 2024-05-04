package core;

import static java.lang.Integer.parseInt;

public class Game extends Activity {
    private core.Activity.Time endTime;
    private int availableSeats;

    public Game(String name, int price, String startTime, String endTime, int busySeats, int availableSeats) {
        super(name, price, busySeats, startTime);
        this.endTime = new Time(endTime);
        this.availableSeats = availableSeats;
    }
    public Game(String line){
        this(line.split("#")[0], parseInt(line.split("#")[1]), line.split("#")[2],
                line.split("#")[3], parseInt(line.split("#")[4]),parseInt(line.split("#")[5]));
    }
    public String toString(){
        return getName()+ "#" + getPrice()+ "#" + getStartTime().toString()+ "#" + endTime.toString()+ "#" + getBusySeats() + "#" + availableSeats;
    }
}