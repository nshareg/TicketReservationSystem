package core;

public class Core {
    private DatabaseWrapper db;
    private User tempUser;
    private final String USERDB = "passdb.txt";
    private final String ACTIVITYDB = "activitydb.txt";
    public Core(){
        db = new DatabaseWrapper(USERDB, ACTIVITYDB);
    }
    public boolean login(String username, String password){
        boolean loginFlag = db.ifLogin(username, password);
        if(loginFlag){
            tempUser = db.getUser(username);
        }
        return loginFlag;
    }
    public boolean register(String activityID){
        Activity temp = db.getActivity(activityID);
        if(temp.getPrice() <= tempUser.getBalance()){
            System.out.println(temp.getBusySeats());
            tempUser.addActivity(activityID);
            temp.increment();
            System.out.println(temp.getBusySeats());
            return true;
        }
        else{
            return false;
        }
    }
    public Activity[] getActivityDB(){//to be added logic, use with this definition
        //return db.getActivities();
        return new Activity[3];
    }
    public String getUser(){
        return tempUser.toString();
    }
    public String[] getUserActivites(){
        String[] temp = new String[tempUser.getActivities().length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = db.getActivity(tempUser.getActivities()[i]).toString();
        }
        return temp;
    }
    public boolean setBalance(int balance){
        if(balance > 0) tempUser.setBalance(balance);
        return balance > 0;
    }

    public void logOut(){
        tempUser = null;
    }
}
