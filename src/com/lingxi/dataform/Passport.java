package com.lingxi.dataform;

public class Passport {

    public enum UserRole{
        admin,
        user
    }

    private UserRole role;
    private String name;
    private String password;

    public Passport(UserRole role, String name, String password){
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public UserRole getRole(){ return role; }
    public void setRole(UserRole role){ this.role = role; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }


}
