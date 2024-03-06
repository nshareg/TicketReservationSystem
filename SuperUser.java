public class SuperUser {
    private String username;
    private String password;
    public SuperUser(){}
    public void setCreds(String username, String password){//one set method for two instances, because of impossibility to have username without password.
        if(Login.ifUserExists(username)){//if user exists simply set the instances to variables we have, will be used during initialization of objects from the txt database.
            this.username = username;
            this.password = password;
        }
        else{//if no user found, sets the instances and creates row regarding new user
            this.username = username;
            this.password = password;
            Login.setAccount(username,password);
        }
    }

    public String getPassword() {
        return Login.getCred(this.username, 1);//gets second colum of the user row, which is password
    }
    public String getUsername(){
        return Login.getCred(this.username, 0);//same as password, but the first column
    }
}
