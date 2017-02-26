package co.herovitamin.testsample.network.model;

public class User {

    String name;
    String username;
    String password;

    public User() {
        name = "";
        username = "";
        password = "";
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if( name != null && !name.isEmpty())
            this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if(password.length() > 6){
            this.password = password;
            return true;
        }
        else
            return false;
    }
}
