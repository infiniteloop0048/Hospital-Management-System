package Hospital;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientAppoinment implements Serializable {

    private String PName;
    private String PId;
    private String DName;
    private String DId;
    private String PDisease;
    private String date;
    private String time;
    int a;

    //--------This method can initialize patientlist
    public static List<PatientAppoinment> patientAppoinmentlist=new ArrayList<>();
    public static PatientAppoinment conPatientAppoinment;
    public static final String APPOINMENT_FILE="Appoinment.txt";


    //----constructor


    public PatientAppoinment(String PName, String PId, String DName, String DId, String PDisease, String date, String time) {
        this.PName = PName;
        this.PId = PId;
        this.DName = DName;
        this.DId = DId;
        this.PDisease = PDisease;
        this.date = date;
        this.time = time;
    }
    //-------file write constructor-----------


    public PatientAppoinment(String PName, String PId, String DName, String DId, String PDisease, String date, String time, int a) {
        this.PName = PName;
        this.PId = PId;
        this.DName = DName;
        this.DId = DId;
        this.PDisease = PDisease;
        this.date = date.toString();
        this.time = time;
        addlist();
    }

    //-------getter and setter------


    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getDId() {
        return DId;
    }

    public void setDId(String DId) {
        this.DId = DId;
    }

    public String getPDisease() {
        return PDisease;
    }

    public void setPDisease(String PDisease) {
        this.PDisease = PDisease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //this can addlist()
    void addlist()
    {
        patientAppoinmentlist.add(this);
        String line=this+"\n";
        BufferedWriter bw = null;
        File patientFile=new File(APPOINMENT_FILE);//filename for checking existing
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
    //tostring method

    @Override
    public String toString() {
        return PName+","+ PId +","+DName+","+DId+","+PDisease+","+date +","+time;
    }
}
