package com.lingxi.dataform;

public class Passport {

    private User.Role role;
    private String name;
    private String password;

    public Passport(User.Role role, String name, String password){
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public User.Role getRole(){ return role; }
    public void setRole(User.Role role){ this.role = role; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }


}
