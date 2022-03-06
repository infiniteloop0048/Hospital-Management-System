package Hospital;

import java.io.Serializable;
import java.util.List;

public class SendAppoinmetList implements Serializable {
    private String userId;
    private List<PatientAppoinment> appoinmentLsit;

    //costructor method
    public SendAppoinmetList(String userId) {
        this.userId = userId;
    }

    public List<PatientAppoinment> getAppoinmentLsit() {
        return appoinmentLsit;
    }

    public void setAppoinmentLsit(List<PatientAppoinment> appoinmentLsit) {
        this.appoinmentLsit = appoinmentLsit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
