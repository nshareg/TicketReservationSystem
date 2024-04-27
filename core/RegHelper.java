package core;

public class RegHelper {
    private String code;
    private int freeSpaces;
    private int allSpaces;
    private int price;

    public RegHelper(String line){
        String[] arr = line.split(".");
        this.code = arr[0];
        this.freeSpaces = Integer.parseInt(arr[1]);
        this.allSpaces = Integer.parseInt(arr[2]);
        this.price = Integer.parseInt(arr[3]);
    }
    public boolean hasFreeSpot(){
        if(freeSpaces < allSpaces) return true;
        return false;
    }
}
