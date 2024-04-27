package core;

public class Amusement extends Activity {
    private enum LevelOfAccess {
        VIP,
        REGULAR
    }

    private core.Amusement.LevelOfAccess requiredAccessLevel;

    public Amusement(String name, String location, String startTime, String endTime, int price, core.Amusement.LevelOfAccess requiredAccessLevel) {
        super(name, location, new Time(startTime), new Time(endTime), price);
        this.requiredAccessLevel = requiredAccessLevel;
    }
    public core.Amusement.LevelOfAccess getRequiredAccessLevel() {
        return requiredAccessLevel;
    }

    public void setRequiredAccessLevel(core.Amusement.LevelOfAccess requiredAccessLevel) {
        this.requiredAccessLevel = requiredAccessLevel;
    }
}