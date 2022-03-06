package Hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientPreviousPage implements Serializable {

    private String pId;
    private String bed;
    private String disease;
    private String aDate;
    private String rDate;
    private String pay;
    int a;

    public static List<PatientPreviousPage> previousPage=new ArrayList<>();
    public static final String HISTORY_FILE_NAME="PatientHistory.txt";


    public PatientPreviousPage(String pId) {
        this.pId = pId;
    }

    public PatientPreviousPage(String pId, String bed, String disease, String aDate, String rDate, String pay) {
        this.pId = pId;
        this.bed = bed;
        this.disease = disease;
        this.aDate = aDate;
        this.rDate = rDate;
        this.pay = pay;
    }

    public PatientPreviousPage(String pId, String bed, String disease, String aDate, String rDate, String pay, int a) {
        this.pId = pId;
        this.bed = bed;
        this.disease = disease;
        this.aDate = aDate;
        this.rDate = rDate;
        this.pay = pay;
        this.a = a;
        previousPage.add(this);
    }

    //----------------getter and setter--------------------

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getaDate() {
        return aDate;
    }

    public void setaDate(String aDate) {
        this.aDate = aDate;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return pId+","+bed+","+disease+","+aDate+","+rDate+","+pay;
    }
}
