import java.io.File;

public class SuperUser {
    private String username;
    private String password;
    public final String DB_NAME = "passdb.txt";
    public SuperUser(){}
    public void setCreds(String username, String password){//one set method for two instances, because of impossibility to have username without password.
        if(FileInteract.ifUserExists(username,DB_NAME)){//if user exists simply set the instances to variables we have, will be used during initialization of objects from the txt database.
            this.username = username;
            this.password = password;
        }
        else{//if no user found, sets the instances and creates row regarding new user
            this.username = username;
            this.password = password;
            FileInteract.setRow(username,password, DB_NAME);
        }
    }

    public String getPassword() {
        return FileInteract.getCred(this.username, 1, DB_NAME);//gets second colum of the user row, which is password
    }
    public String getUsername(){
        return FileInteract.getCred(this.username, 0,DB_NAME);//same as password, but the first column
    }
}
