package core;

public class Transportation extends Activity {
    private String mode;
    private int availableSeats;
    private int lengthOfRoad;
    private int numberOfSections;
    private int vipPlaces;
    private int ordinaryPlaces;

    public Transportation(String name, String location, Time startTime, String mode, int price, int numberOfSeats,
                          int availableSeats, int lengthOfRoad, int numberOfSections, int vipPlaces, int ordinaryPlaces, Time endTime) {
        super(name, location, startTime, endTime, price, numberOfSeats);
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

    public void setLengthOfRoad(int lengthOfRoad) {
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