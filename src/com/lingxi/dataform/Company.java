package com.lingxi.dataform;

import java.math.BigInteger;

public class Company {
    public enum State {
        last,
        pause,
        finish,
        ;

        @Override
        public String toString() {
            if(this == last) return "招聘中";
            else if(this == pause) return "已暂停";
            else if(this == finish) return "已结束";
            return name();
        }
    }

    private int id;
    private String name;
    private String address;
    private String scale;
    private String type;
    private String introduction;
    private State state;
    private int order;
    private String picture="";
    private Long views=0L;

    public Company() {}
    public Company(String name, String address, String scale, String type, String introduction, State state,
                   String picture, int order) {
        this.name = name;
        this.address = address;
        this.scale = scale;
        this.type = type;
        this.introduction = introduction;
        this.state = state;
        this.picture = picture;
        this.order = order;

    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getScale() { return scale; }
    public String getType() { return type; }
    public String getIntroduction() { return introduction; }
    public State getState() { return state; }
    public int getOrder() { return order; }
    public String getPicture() { return picture; }
    public Long getViews() { return views; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setScale(String scale) { this.scale = scale; }
    public void setType(String type) { this.type = type; }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public void setState(State state) { this.state = state; }
    public void setOrder(int order) { this.order = order; }
    public void setPicture(String picture) { this.picture = picture; }
    public void setViews(Long views) { this.views = views; }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", address=" + address + ", scale=" + scale + ", type=" +
                type + ", introduction=" + introduction + ", state=" + state + ", picture=" + picture + ", order=" + order +
                 ", views=" + views + "]";
    }

    public Object[] toArray() {
        return new Object[]{name, address, scale, type, introduction, state.name(), order, picture};
    }

    public Object[] toArray(Object end) {
        return new Object[]{name, address, scale, type, introduction, state.name(), order, picture, end};
    }
}
