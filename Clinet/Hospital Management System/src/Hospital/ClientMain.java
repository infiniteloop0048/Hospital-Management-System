package Hospital;


import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static Hospital.Patient.PATIENT_FILE_NAME;
import static Hospital.Patient.patientlist;


public class ClientMain extends Application {
    static String msg=null;//this message is for show any update message
    BufferedReader br;

    public void init()
    {
        initilizePatientFile();

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Page mainpage=new Page();
        mainpage.setMainPage(primaryStage);
        mainpage.showMainPage();
    }


    public static void main(String[] args) {
        launch(args);
    }
    void initilizePatientFile()
    {
        try//open file for reading date
        { br = new BufferedReader(new FileReader(PATIENT_FILE_NAME));
        }catch(Exception e)
        {
            System.out.println("oh!there is something mising.can't open file.please resolve itS");
        }
        File patientFile=new File(PATIENT_FILE_NAME);//filename for checking existing
        if(patientFile.exists()==false){ try {
            patientFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        while(true) {
            try {
                String line = null;   //this method can initilize patientlist
                line = br.readLine();
                //System.out.println(line);
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                patientlist.add(new Patient(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]));//problem ocouer here call a constructor
            } catch (IOException ex) {
                System.out.println("exception creat on readline");
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void initilizeDoctorFile()
    {
        ;//doctor file should initilize here
    }
}
