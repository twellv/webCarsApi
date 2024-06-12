package ecommerce.model;

import ecommerce.util.AccessLevel;

public class User {

    private long id;
    private String fullname;
    private String email;
    private String password;
    private Enum<AccessLevel> role = AccessLevel.USER;

    public User(){}

    public User(String fullname, String email, String password, Enum<AccessLevel> role) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum<AccessLevel> getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = AccessLevel.access(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
