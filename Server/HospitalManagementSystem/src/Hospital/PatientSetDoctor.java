package Hospital;

import java.io.Serializable;

public class PatientSetDoctor implements Serializable {

    private String pName;
    private String pId;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public PatientSetDoctor(String pName, String pId) {

        this.pName = pName;
        this.pId = pId;
    }
}
