package com.lingxi.dataform;

import java.sql.Date;

public class Job {
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
    private String company;
    private int capacity;
    private int apply;
    private Date endDate;
    private State state;

    public Job() {}
    public Job(int id, String name, String company, int capacity, int apply, Date endDate, State state) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.capacity = capacity;
        this.apply = apply;
        this.endDate = endDate;
        this.state = state;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCompany() { return company; }
    public int getCapacity() { return capacity; }
    public int getApply() { return apply; }
    public Date getEndDate() { return endDate; }
    public State getState() { return state; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCompany(String company) { this.company = company; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setApply(int apply) { this.apply = apply; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setState(State state) { this.state = state; }


    @Override
    public String toString() {
        return "Job [id=" + id + ", name=" + name + ", company=" + company +
                ", capacity=" + capacity + ", apply=" + apply + ", endDate=" + endDate + ", state=" + state + "]";
    }

    public Object[] toArray() {
        return new Object[]{id, name, company, capacity, apply, endDate, state};
    }

    public Object[] toArray(Object end) {
        return new Object[]{id, name, company, capacity, apply, endDate, state, end};
    }
}
