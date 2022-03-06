package Hospital;

import java.io.Serializable;

public class UPatient implements Serializable {

    private String patientId;
    private String patientName;
    private String email;
    private String password;
    private String ContactNo;
    private String patientGender;
    private String patientAge;
    private String patientDob;
    private String maritalStatus;
    private String slectDisease;
    private String address;
    //constructor


    public UPatient(String patientId, String patientName, String email, String password, String contactNo, String patientGender, String patientAge, String patientDob, String maritalStatus, String slectDisease, String address) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.email = email;
        this.password = password;
        ContactNo = contactNo;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientDob = patientDob;
        this.maritalStatus = maritalStatus;
        this.slectDisease = slectDisease;
        this.address = address;
    }

    //----------getter and setter---------------

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(String patientDob) {
        this.patientDob = patientDob;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSlectDisease() {
        return slectDisease;
    }

    public void setSlectDisease(String slectDisease) {
        this.slectDisease = slectDisease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
