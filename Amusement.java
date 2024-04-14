package Activity;

public class Amusement extends Activity {
    private enum LevelOfAccess {
        VIP,
        REGULAR
    }

    private String attraction;
    private int visitors;
    private Activity.Amusement.LevelOfAccess requiredAccessLevel;

    public Amusement(String name, String location, double durationHours, double price, String attraction, int numberOfSeats, Activity.Amusement.LevelOfAccess requiredAccessLevel) {
        super(name, location, durationHours, price, numberOfSeats);
        this.attraction = attraction;
        this.visitors = 0;
        this.requiredAccessLevel = requiredAccessLevel;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public Activity.Amusement.LevelOfAccess getRequiredAccessLevel() {
        return requiredAccessLevel;
    }

    public void setRequiredAccessLevel(Activity.Amusement.LevelOfAccess requiredAccessLevel) {
        this.requiredAccessLevel = requiredAccessLevel;
    }
}