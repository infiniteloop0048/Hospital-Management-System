package Hospital;

//this is doctor class all information of doctor are maintian by this class

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Doctor implements Serializable{

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
    private int a;


    // doctorList which contain all doctor list
    public static List<Doctor> doctorList=new ArrayList<Doctor>();
    public static Doctor conDoctor;
    public static final String DOCTOR_FILE_NAME="Doctor.txt";
    //create doctor contructor


    public Doctor(String doctorId, String doctorName, String doctorEmail, String doctorPassword, String doctorContactNo, String doctorGender, String doctorDepartment, String doctorGraduation, String docotorAdress, String doctorDesignation) {
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

    //constructor for create list

    public Doctor(String doctorId, String doctorName, String doctorEmail, String doctorPassword, String doctorContactNo, String doctorGender, String doctorDepartment, String doctorGraduation, String docotorAdress, String doctorDesignation, int a) {
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
        this.a = a;
        addList();
    }


    //-----------gretter and setter method--------------

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


    //this method is for write file and add doctor in doctor list
    void addList()
    {

        doctorList.add(this);
        //this is for write a file for new doctor object
        String line=this+"\n";
        BufferedWriter bw = null;
        File DoctorFile=new File(DOCTOR_FILE_NAME);//filename for checking existing
        if(DoctorFile.exists()==false){ try {
            DoctorFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(DoctorFile,true));
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
        finally {
            try{
                bw.close();//this method close file
            }catch(Exception e)
            {
                System.out.println("error generate while close");
            }
        }
    }

    //generate toString method to load patientlist


    @Override
    public String toString() {
        return doctorId+","+doctorName +","+doctorEmail+","+doctorPassword +","+ doctorContactNo +","+ doctorGender +","+ doctorDepartment +","+ doctorGraduation +","+ docotorAdress +","+ doctorDesignation;
    }
}
