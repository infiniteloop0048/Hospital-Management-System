package Hospital;

import java.io.Serializable;

public class DoctorReportId implements Serializable {
    String id;

    public DoctorReportId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
