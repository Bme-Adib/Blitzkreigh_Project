package com.herculife.herculifeLunaEMG.ProjectClasses;

public class UserClass {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private String role = USER;
    private String name = "";
    private String password = "";

    public UserClass(String role, String name, String password) {
        this.role = role;
        this.name = name;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserClass{" +
                "role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
