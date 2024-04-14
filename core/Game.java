package core;

public class Game extends Activity {

    private int availableSeats;

    private int vipSeats;
    private int ordinarySeats;


    public Game(String name, String location, Time startTime,Time endTime, int price,
                int numberOfSeats, int availableSeats, int vipSeats, int ordinarySeats) {
        super(name, location, startTime, endTime, price, numberOfSeats);
        this.vipSeats = vipSeats;
        this.ordinarySeats = ordinarySeats;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(int vipSeats) {
        this.vipSeats = vipSeats;
    }

    public int getOrdinarySeats() {
        return ordinarySeats;
    }

    public void setOrdinarySeats(int ordinarySeats) {
        this.ordinarySeats = ordinarySeats;
    }
}