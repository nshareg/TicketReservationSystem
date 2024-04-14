package Activity;

public class Transportation extends Activity {
    private String mode;
    private int availableSeats;
    private double lengthOfRoad;
    private int numberOfSections;
    private int vipPlaces;
    private int ordinaryPlaces;

    public Transportation(String name, String location, double durationHours, String mode, double price, int numberOfSeats,
                          int availableSeats, double lengthOfRoad,int numberOfSections, int vipPlaces, int ordinaryPlaces) {
        super(name, location, durationHours, price, numberOfSeats);
        this.mode = mode;
        this.availableSeats = availableSeats;
        this.lengthOfRoad = lengthOfRoad;
        this.numberOfSections = numberOfSections;
        this.vipPlaces = vipPlaces;
        this.ordinaryPlaces = ordinaryPlaces;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getLengthOfRoad() {
        return lengthOfRoad;
    }

    public void setLengthOfRoad(double lengthOfRoad) {
        this.lengthOfRoad = lengthOfRoad;
    }

    public int getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(int numberOfSections) {
        this.numberOfSections = numberOfSections;
    }

    public int getVipPlaces() {
        return vipPlaces;
    }

    public void setVipPlaces(int vipPlaces) {
        this.vipPlaces = vipPlaces;
    }

    public int getOrdinaryPlaces() {
        return ordinaryPlaces;
    }

    public void setOrdinaryPlaces(int ordinaryPlaces) {
        this.ordinaryPlaces = ordinaryPlaces;
    }

}