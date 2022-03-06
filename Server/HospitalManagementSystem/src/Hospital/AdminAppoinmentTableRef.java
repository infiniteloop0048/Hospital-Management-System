package Hospital;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class AdminAppoinmentTableRef implements Serializable {

    private final SimpleStringProperty pName;
    private final SimpleStringProperty pDisease;
    private final SimpleStringProperty dName;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;

    public AdminAppoinmentTableRef(String pName,String pDisease,String dName,String date,String time) {
        this.pName = new SimpleStringProperty(pName);
        this.pDisease =new SimpleStringProperty(pDisease);
        this.dName =new SimpleStringProperty(dName);
        this.date = new SimpleStringProperty(date);
        this.time =new SimpleStringProperty(time);
    }

    public String getpName() {
        return pName.get();
    }

    public SimpleStringProperty pNameProperty() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public String getpDisease() {
        return pDisease.get();
    }

    public SimpleStringProperty pDiseaseProperty() {
        return pDisease;
    }

    public void setpDisease(String pDisease) {
        this.pDisease.set(pDisease);
    }

    public String getdName() {
        return dName.get();
    }

    public SimpleStringProperty dNameProperty() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName.set(dName);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }
}
