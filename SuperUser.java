public class SuperUser {
    private String username;
    private String password;
    private String role;
    public final String DB_NAME = "passdb.txt";
    public SuperUser(){}//empty constructor
    /**
     * Updates values of username and password at the same time, also adds them to the db
     *
     * @param username     username in String
     * @param password     password in String
     */
    public void setCreds(String username, String password){//one set method for two instances, because of impossibility to have username without password.
        if(!FileInteract.ifLogin(username, password)){//if user exists simply set the instances to variables we have, will be used during initialization of objects from the txt database.
            FileInteract.setRow(username,password, DB_NAME);
        }
        //sets instances to values we got
        this.username = username;
        this.password = password;

    }
    /**
     * Updates role of the user, adds it to db
     * SET ONLY USER/ADMIN PLEASE DON'T TYPE ANYTHING ELSE METHOD WILL DO KABOOM
     *
     * @param role     role of the user in String
     */
    public void setRole(String role){
        if(FileInteract.getLength(this.username, DB_NAME) <= 2){//if number of elements is less or equal than 2 it means that role is not set yet
            FileInteract.setNewPart(this.username, role, DB_NAME);//so it's add String role from right
        }
        else{//if we already had role, it simply changes its value
            FileInteract.changePart(this.username, role, 2, DB_NAME);
        }
        this.role = role;//sets instances to values we got
    }

    /**
     * returns username of the object
     *
     * @return username of the user in String
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * returns password of the object
     *
     * @return password of the user in String
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * returns role of the object
     *
     * @return role of the user in String
     */
    public String getRole(){
        return this.role;
    }
}
