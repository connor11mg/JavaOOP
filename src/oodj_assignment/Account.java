package oodj_assignment;

import java.util.ArrayList;

public class Account {
    private String name, DOB, password,
             gender, email, IC, phone_number, ID, Theme;

    public Account(String name, String DOB, String password,
                    String gender, String email, String IC,
                   String phone_number, String ID, String Theme){

        this.name = name;
        this.DOB = DOB;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.IC = IC;
        this.phone_number = phone_number;
        this.ID = ID;
        this.Theme = Theme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDOB() {
        return DOB;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getIC() {
        return IC;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }
}