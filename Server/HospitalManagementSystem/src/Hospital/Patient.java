package Hospital;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

//this class store all patient imformation
  class Patient implements Serializable {

    //all variable of patient class
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

    // a list which store all patient information
    static List<Patient> patientlist=new ArrayList<>();
    public static Patient conPatientObj;//this is for reserve patient search history
    public static int conPateintinx;//this i for reserve patient search index
    public static final String PATIENT_FILE_NAME="Patient.txt";



    //constructor

// this constructor for creat list from file.txt
    public Patient(String patientId, String patientName, String email, String password, String contactNo, String patientGender, String patientAge, String pateintDob, String maritalStatus, String slectDisease, String address) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.email = email;
        this.password = password;
        ContactNo = contactNo;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientDob=pateintDob;
        this.maritalStatus = maritalStatus;
        this.slectDisease = slectDisease;
        this.address = address;
    }
//this constructor for write file.txt
    public Patient(String patientId, String patientName, String email, String password, String contactNo, String patientGender, String patientAge, String patientDob, String maritalStatus, String slectDisease, String address, int a) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.email = email;
        this.password = password;
        ContactNo = contactNo;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientDob=patientDob;
        this.maritalStatus = maritalStatus;
        this.slectDisease = slectDisease;
        this.address = address;
        addPatient(this);
    }
    //setters and getter methods

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

    void addPatient(Patient object) {  //this method a patient information or Patient object to patientlist

        patientlist.add(object);
        String line=this+"\n";
        BufferedWriter bw = null;
        File patientFile=new File(PATIENT_FILE_NAME);//filename for checking existing
            if(patientFile.exists()==false){ try {
                patientFile.createNewFile();//if file doesn't created yet this method call and creat file
            } catch (IOException e) {
                e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(patientFile,true));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            bw.write(line);

        }catch(Exception e)
        {
            System.out.println("exception while writing file");
        }
        try{
            bw.close();//this method close file
        }catch(Exception e)
        {
            System.out.println("error generate while close");
        }

    }
    @Override
    public String toString()
    {
        return   patientId+","+patientName+","+email+","+password+","+ContactNo+","+patientGender+","+patientAge+","+patientDob+","+maritalStatus+","+slectDisease+","+address;
    }
}
