package com.lingxi.dataform;

public class Admin {
    private int id;
    private String name;
    private String password;
    private String realName;
    private Boolean login;

    public Admin() {}
    public Admin(int id, String name, String password, String realName, Boolean login) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.realName = realName;
        this.login = login;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getPassword(){ return password; }
    public String getRealName(){ return realName; }
    public Boolean getLogin(){ return login; }

    public void setId(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setString(String password){ this.password = password; }
    public void setRealName(String realName){ this.realName = realName; }
    public void setLogin(Boolean login){ this.login = login; }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password +
                ", realName=" + realName + ", login=" + login + "]";
    }
}
