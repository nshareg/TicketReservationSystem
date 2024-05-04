package core;

import static java.lang.Integer.parseInt;

public class Amusement extends Activity {
    public enum LevelOfAccess {
        VIP, REGULAR
    }

    public Amusement(String name, int price,int busySeats, String time, LevelOfAccess requiredAccessLevel) {
        super(name, price, busySeats, time);
        this.accessLevel = requiredAccessLevel;
    }
    public Amusement(String line){
        super(line.split("#")[0],parseInt(line.split("#")[1]), parseInt(line.split("#")[2]), line.split("#")[3]);
        this.accessLevel = LevelOfAccess.valueOf(line.split("#")[4].toUpperCase());
    }
    public String toString(){
        return getName()+ "#" + getPrice()+ "#" + getBusySeats() + "#" + getStartTime().toString()+ "#" + accessLevel;
    }
}