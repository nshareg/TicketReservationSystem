package Activity;

public abstract class Activity {
    private String name;
    private String location;
    private double durationHours;
    private double price;
    private int numberOfSeats;


    public Activity(String name, String location, double durationHours, double price, int numberOfSeats) {
        this.name = name;
        this.location = location;
        this.durationHours = durationHours;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}