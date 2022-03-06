package Hospital;


import java.io.Serializable;

public class BookedBed implements Serializable{
    String pId;
    String pName;
    String BedNo;
    boolean[] currentArrray=new boolean[4];

    public BookedBed(String pId, String pName, String bedNo,boolean[] currentArrray) {
        this.pId = pId;
        this.pName = pName;
        BedNo = bedNo;
        this.currentArrray = currentArrray;
    }
    //---------------getter and setter methods-----------------


    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getBedNo() {
        return BedNo;
    }

    public void setBedNo(String bedNo) {
        BedNo = bedNo;
    }

    public boolean[] getCurrentArrray() {
        return currentArrray;
    }

    public void setCurrentArrray(boolean[] currentArrray) {
        this.currentArrray = currentArrray;
    }
}
