package Hospital;

import java.io.Serializable;

public class UDoctor implements Serializable {

    private String doctorId;
    private String doctorName;
    private String doctorEmail;
    private String doctorPassword;
    private String doctorContactNo;
    private String doctorGender;
    private String doctorDepartment;
    private String doctorGraduation;
    private String docotorAdress;
    private String doctorDesignation;
    //add constructor


    public UDoctor(String doctorId, String doctorName, String doctorEmail, String doctorPassword, String doctorContactNo, String doctorGender, String doctorDepartment, String doctorGraduation, String docotorAdress, String doctorDesignation) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
        this.doctorContactNo = doctorContactNo;
        this.doctorGender = doctorGender;
        this.doctorDepartment = doctorDepartment;
        this.doctorGraduation = doctorGraduation;
        this.docotorAdress = docotorAdress;
        this.doctorDesignation = doctorDesignation;
    }

    //-----------add getter and setter------------

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public String getDoctorContactNo() {
        return doctorContactNo;
    }

    public void setDoctorContactNo(String doctorContactNo) {
        this.doctorContactNo = doctorContactNo;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public String getDoctorGraduation() {
        return doctorGraduation;
    }

    public void setDoctorGraduation(String doctorGraduation) {
        this.doctorGraduation = doctorGraduation;
    }

    public String getDocotorAdress() {
        return docotorAdress;
    }

    public void setDocotorAdress(String docotorAdress) {
        this.docotorAdress = docotorAdress;
    }

    public String getDoctorDesignation() {
        return doctorDesignation;
    }

    public void setDoctorDesignation(String doctorDesignation) {
        this.doctorDesignation = doctorDesignation;
    }
}
