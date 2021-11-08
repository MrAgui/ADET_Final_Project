package com.bsu.bsu_fproj;

import java.io.Serializable;

public class Account implements Serializable {

    public String sr_code;
    public  String last_Name;
    public  String first_Name;
    public  String middle_Initial;
    public  String program;
    public  String yr_Level;
    public  String password;
    public  String liabilities;

    public String getSr_code() {
        return sr_code;
    }

    public void setSr_code(String sr_code) {
        this.sr_code = sr_code;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getMiddle_Initial() {
        return middle_Initial;
    }

    public void setMiddle_Initial(String middle_Initial) {
        this.middle_Initial = middle_Initial;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getYr_Level() {
        return yr_Level;
    }

    public void setYr_Level(String yr_Level) {
        this.yr_Level = yr_Level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(String liabilities) {
        this.liabilities = liabilities;
    }
}
