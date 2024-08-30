package com.lingxi.dataform;

import java.sql.Date;

public class Resume {
    private int id;
    private String name;
    private String picture;
    private String gender;
    private Date birthday;
    private String location;
    private String registration;
    private String phone;
    private String email;
    private String target;
    private String experience;

    public Resume(){}
    public Resume(String name, String picture, String gender, Date birthday, String location, String registration, String phone, String email, String target, String experience) {
        this.name = name;
        this.picture = picture;
        this.gender = gender;
        this.birthday = birthday;
        this.location = location;
        this.registration = registration;
        this.phone = phone;
        this.email = email;
        this.target = target;
        this.experience = experience;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPicture() { return picture; }
    public String getGender() { return gender; }
    public Date getBirthday() { return birthday; }
    public String getLocation() { return location; }
    public String getRegistration() { return registration; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getTarget() { return target; }
    public String getExperience() { return experience; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPicture(String picture) { this.picture = picture; }
    public void setGender(String gender) { this.gender = gender; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
    public void setLocation(String location) { this.location = location; }
    public void setRegistration(String registration) { this.registration = registration; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setTarget(String target) { this.target = target; }
    public void setExperience(String experience) { this.experience = experience; }

    public Object[] toArray() {
        return new Object[]{name, picture, gender, birthday, location, registration, phone, email, target, experience};
    }

}
