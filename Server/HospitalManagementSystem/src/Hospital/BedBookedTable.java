package Hospital;

import javafx.beans.property.SimpleStringProperty;

import java.io.FileInputStream;

public class BedBookedTable {

    private final SimpleStringProperty pId;
    private final SimpleStringProperty pName;
    private final SimpleStringProperty bedNo;

    //---------------constructor---------------


    public BedBookedTable(String pId, String pName, String bedNo) {
        this.pId = new SimpleStringProperty(pId);
        this.pName =new SimpleStringProperty(pName);
        this.bedNo =new SimpleStringProperty(bedNo);
    }


    //---------------------getter and setter-------------

    public String getpId() {
        return pId.get();
    }

    public SimpleStringProperty pIdProperty() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId.set(pId);
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

    public String getBedNo() {
        return bedNo.get();
    }

    public SimpleStringProperty bedNoProperty() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo.set(bedNo);
    }
}
