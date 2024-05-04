package core;

import static java.lang.Integer.parseInt;

public class Transportation extends Activity {
    private Activity.Time arrivalTime;
    private int numberOfStops;
    private int availableSeats;

    public Transportation(String name, int price, String startTime, String arrivalTime, int numberOfStops, int busySeats, int availableSeats) {
        super(name, price, busySeats, startTime);
        this.arrivalTime = new Time(arrivalTime);
        this.numberOfStops = numberOfStops;
        this.availableSeats = availableSeats;
    }

    public Transportation(String line){
        this(line.split("#")[0], parseInt(line.split("#")[1]), line.split("#")[2],
                line.split("#")[3], parseInt(line.split("#")[4]),parseInt(line.split("#")[5]), parseInt(line.split("#")[6]));
    }
    public String toString(){
        return getName()+ "#" + getPrice()+ "#" + getStartTime().toString()+ "#" + arrivalTime.toString()+ "#" + numberOfStops + "#" + getBusySeats() + "#" + availableSeats;
    }
}