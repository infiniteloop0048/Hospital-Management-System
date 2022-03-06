package Hospital;

import java.io.Serializable;

public class PatientViewLastAppoinment implements Serializable {
    private String pUserId;
    private String dName;
    private String pDisease;
    private String date;
    private String time;

    public PatientViewLastAppoinment(String pUserId) {
        this.pUserId = pUserId;
    }

    public PatientViewLastAppoinment(String pUserId, String dName, String pDisease, String date, String time) {
        this.pUserId = pUserId;
        this.dName = dName;
        this.pDisease = pDisease;
        this.date = date;
        this.time = time;
    }

    //----------------------getter and setter-------------------------

    public String getpUserId() {
        return pUserId;
    }

    public void setpUserId(String pUserId) {
        this.pUserId = pUserId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getpDisease() {
        return pDisease;
    }

    public void setpDisease(String pDisease) {
        this.pDisease = pDisease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
