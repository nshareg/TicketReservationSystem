package core;
public abstract class Activity {
    private String name;
    private core.Activity.Time startTime;
    private core.Activity.Time endTime;
    private int availableSeats;
    private int price;
    public static class Time {
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

        @Override
        public String toString() {
            return hours + ":" + minutes;
        }

        @Override
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
    public Activity(String name,core.Activity.Time startTime, core.Activity.Time endTime, int price) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public core.Activity.Time getStartTime() {
        return new core.Activity.Time(startTime.hours, startTime.minutes);
    }

    public void setStartTime(core.Activity.Time startTime) {
        this.startTime = new core.Activity.Time(startTime.hours, startTime.minutes);
    }

    public core.Activity.Time getEndTime() {
        return new core.Activity.Time(endTime.hours, endTime.minutes);
    }

    public void setEndTime(core.Activity.Time endTime) {
        this.endTime = new core.Activity.Time(endTime.hours, endTime.minutes);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}