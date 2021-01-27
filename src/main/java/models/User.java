package models;

public class User {
    private String username;
    private String password;
    private String email;

    public User(String un, String p, String e){
        this.username = un;
        this.password = p;
        this.email = e;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
