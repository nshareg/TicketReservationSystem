package core;

import static java.lang.Integer.parseInt;

public class Amusement extends Activity {
    public enum LevelOfAccess {
        VIP, REGULAR
    }
    private core.Amusement.LevelOfAccess requiredAccessLevel;


    public Amusement(String name, int price, String time, LevelOfAccess requiredAccessLevel) {
        super(name, price, time);
        this.requiredAccessLevel = requiredAccessLevel;
    }
    public Amusement(String line){
        super(line.split("#")[0],parseInt(line.split("#")[1]), line.split("#")[2]);
        this.requiredAccessLevel = LevelOfAccess.valueOf(line.split("#")[3].toUpperCase());
    }
    public String toString(){
        return getName()+ "#" + getPrice()+ "#" + getStartTime().toString()+ "#" + requiredAccessLevel;
    }
}