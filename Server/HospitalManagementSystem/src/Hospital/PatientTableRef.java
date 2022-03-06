package Hospital;

import javafx.beans.property.SimpleStringProperty;



public class PatientTableRef  {

    private final SimpleStringProperty PatientId;
    private final SimpleStringProperty PatientName;
    private final SimpleStringProperty SlectDisease;
    private final SimpleStringProperty ContactNo;
    private final SimpleStringProperty email;
    private final SimpleStringProperty address;
    //------------constructor--------------

    public PatientTableRef(String patientId, String patientName, String slectDisease, String contactNo, String email, String address) {
        this.PatientId = new SimpleStringProperty(patientId);
        this.PatientName = new SimpleStringProperty(patientName);
        this.SlectDisease = new SimpleStringProperty(slectDisease);
        this.ContactNo = new SimpleStringProperty(contactNo);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
    }
    //-------------getter and setter----------------


    public String getPatientId() {
        return PatientId.get();
    }



    public String getPatientName() {
        return PatientName.get();
    }



    public String getSlectDisease() {
        return SlectDisease.get();
    }



    public String getContactNo() {
        return ContactNo.get();
    }



    public String getEmail() {
        return email.get();
    }



    public String getAddress() {
        return address.get();
    }


}
