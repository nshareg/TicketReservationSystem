public class SuperUser {
    private String username;
    private String name;
    private String surname;
    public SuperUser(){}
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getUsername(){
        return this.username;
    }
}
