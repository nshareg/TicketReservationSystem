package core;
public abstract class Activity {
    private String name;
    private int price;
    private core.Activity.Time startTime;

    public static class Time{
        private int hours;
        private int minutes;

        public Time(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }
        public Time(String time){
            String[] timeSpllited = time.split(":");
            this.hours = Integer.parseInt(timeSpllited[0]);
            this.minutes = Integer.parseInt(timeSpllited[1]);
        }
        public Time(Time obj){
            this.hours = obj.hours;
            this.minutes = obj.minutes;
        }
        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public String toString() {
            return hours + ":" + minutes;
        }

        public boolean equals(Object otherObject) {
            if (otherObject == null)
                return false;
            else if (getClass() != otherObject.getClass())
                return false;
            else {
                core.Activity.Time otherTime = (core.Activity.Time) otherObject;
                return (hours == otherTime.hours)
                        && (minutes == otherTime.minutes);
            }
        }
    }
    public Activity(String name, int price, String time) {
        this.name = name;
        this.price = price;
        this.startTime = new Time(time);
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Time getStartTime() {
        return startTime;
    }

}