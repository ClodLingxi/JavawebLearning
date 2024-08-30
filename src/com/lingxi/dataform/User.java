package com.lingxi.dataform;

public class User {
    public enum Role{
        Admin,
        Company,
        User,
        ;

        @Override
        public String toString() {
            if (this.equals(Admin)) return "系统管理员";
            else if (this.equals(Company)) return "Company";
            else if (this.equals(User)) return "用户";
            return name();
        }
    }

    private int id;
    private String name;
    private String password;
    private String realName;
    private Role role;
    private String email;
    private Boolean enabled;
    private Boolean login;

    public User() {}
    public User(String name, String password, String realName, Role role, String email, Boolean enabled){
        this(-1, name, password, realName, role, email, enabled, false);
    }
    public User(int id, String name, String password, String realName, Role role, String email, Boolean enabled, Boolean login) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.realName = realName;
        this.role = role;
        this.email = email;
        this.enabled = enabled;
        this.login = login;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getPassword(){ return password; }
    public String getRealName(){ return realName; }
    public Role getRole(){ return role; }
    public String getEmail(){ return email; }
    public Boolean getEnabled(){ return enabled; }
    public Boolean getLogin(){ return login; }

    public void setId(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setString(String password){ this.password = password; }
    public void setRealName(String realName){ this.realName = realName; }
    public void setRole(Role role){ this.role = role; }
    public void setEmail(String email){ this.email = email; }
    public void setEnabled(Boolean enabled){ this.enabled = enabled; }
    public void setLogin(Boolean login){ this.login = login; }

    public Object[] toArray(){
        return new Object[]{name, password, realName, role.ordinal() + 1, email, enabled};
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", realName="
                + realName + ", role=" + role + ", email=" + email + ", enabled=" + enabled + ", login=" + login + "]";
    }
}
