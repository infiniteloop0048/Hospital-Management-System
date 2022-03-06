package Hospital;


import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.io.*;

import static Hospital.Doctor.DOCTOR_FILE_NAME;
import static Hospital.Doctor.doctorList;
import static Hospital.Patient.PATIENT_FILE_NAME;
import static Hospital.Patient.patientlist;
import static Hospital.PatientAppoinment.APPOINMENT_FILE;
import static Hospital.PatientAppoinment.patientAppoinmentlist;
import static Hospital.PatientPreviousPage.HISTORY_FILE_NAME;
import static Hospital.PatientPreviousPage.previousPage;
import static Hospital.Payment.PAYMENT_FILE;
import static Hospital.Payment.paymentList;
import static Hospital.Presscribtion.PRESCRIBTION_FILE_NAME;
import static Hospital.Presscribtion.presscribtionList;


public class Main extends Application {
    final String BEDTRACER_FILE_NAME="Bedtracer.txt";
    final String BOOK_BED_FILE_NANE="Bookedbed.txt";
    BufferedReader br;
    public static BedTracer bedTracer=new BedTracer();//this hava a arry whcih can trace the bed allocation
    public static BookBedList bookBedList=new BookBedList();//this variabel have Bookedbed type list which load for creat a table

    public void init()
    {

        initilizePatientFile();
        initilizeDoctorFile();
        initializationAppoinmentfile();
        initializeBedTracer();
        initailizeBookBedList();
        initilizeHistory();
        initilizePrescribtion();
        initilizePayment();

    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Page mainpage=new Page();
        mainpage.setMainPage(primaryStage);
        mainpage.showMainPage();
    }
    public void stop()
    {
        updatePatinetlist();
        updatedoctorList();
        updateAppoinmentList();
        updateBedTracer();
        updateBookBedList();
        updatePatienHistory();
        updatePrescribtionfile();
        updatePaymentFile();
        System.out.println("all file are update");

    }


    public static void main(String[] args)  {

       new Server(20000);//this statement can run the server
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
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                int length=arr.length;
                if(length<11)
                {
                    String arr1[]=new String[11];
                    for(int i=0;i<length;i++) arr1[i]=arr[i];
                    for(int i=length;i<11;i++) arr1[i]=" ";
                    arr=arr1;
                }

                patientlist.add(new Patient(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]));//problem ocouer here call a constructor
            } catch (Exception ex) {
               // System.out.println("exception creat on readline");
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

        File doctorFile=new File(DOCTOR_FILE_NAME);//filename for checking existing
        if(doctorFile.exists()==false){ try {
            doctorFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//open file for reading date
        { br = new BufferedReader(new FileReader(DOCTOR_FILE_NAME));
        }catch(Exception e)
        {
            System.out.println("oh!there is something mising.can't open file.please resolve itS");
        }

        while(true) {
            try {
                String line = null;   //this method can initilize patientlist
                line = br.readLine();
                //System.out.println(line);
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                int length=arr.length;
                if(length<10)
                {
                    String arr1[]=new String[10];
                    for(int i=0;i<length;i++) arr1[i]=arr[i];
                    for(int i=length;i<10;i++) arr1[i]=" ";
                    arr=arr1;
                }
                //if(length<10) { for(int i=length;i<10;i++) arr[i]=" ";}
                doctorList.add(new Doctor(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9]));//problem ocouer here call a constructor
            } catch (Exception ex) {
                // System.out.println("exception creat on readline");
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //this file can initialize appoinmentfilelist

    void initializationAppoinmentfile()
    {
        File appoinmentFile=new File(APPOINMENT_FILE);//filename for checking existing
        if(appoinmentFile.exists()==false){ try {
            appoinmentFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//open file for reading date
        { br = new BufferedReader(new FileReader(APPOINMENT_FILE));
        }catch(Exception e)
        {
            System.out.println("oh!there is something mising.can't open file.please resolve itS");
        }

        while(true) {
            try {
                String line = null;   //this method can initilize patientlist
                line = br.readLine();
                //System.out.println(line);
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                int length=arr.length;
                if(length<7)
                {
                    String arr1[]=new String[7];
                    for(int i=0;i<length;i++) arr1[i]=arr[i];
                    for(int i=length;i<7;i++) arr1[i]=" ";
                    arr=arr1;
                }
                //if(length<10) { for(int i=length;i<10;i++) arr[i]=" ";}
                patientAppoinmentlist.add(new PatientAppoinment(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));//problem ocouer here call a constructor
            } catch (Exception ex) {
                // System.out.println("exception creat on readline");
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //this method can update all the filefrom static variable list

    void updatePatinetlist()//this can update patient list
    {
        String line=null;
        BufferedWriter bw = null;
        File patientFile=new File(PATIENT_FILE_NAME);//filename for checking existing
        if(patientFile.exists()==false){ try {
            patientFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(patientFile));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            Patient p;
            for(int i=0;i<patientlist.size();i++)
            {
                p=patientlist.get(i);
                line=p+"\n";
                bw.write(line);
            }
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

    void updatedoctorList()//this can updata doctor list
    {
        String line=null;
        BufferedWriter bw = null;
        File doctorfile=new File(DOCTOR_FILE_NAME);//filename for checking existing
        if(!doctorfile.exists()){ try {
            doctorfile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(doctorfile));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            Doctor d;
            for(int i=0;i<doctorList.size();i++)
            {
                d=doctorList.get(i);
                line=d+"\n";
                bw.write(line);
            }
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



    void updateAppoinmentList()//this can update appoinment lsit
    {
        String line=null;
        BufferedWriter bw = null;
        File patientFile=new File(APPOINMENT_FILE);//filename for checking existing
        if(patientFile.exists()==false){ try {
            patientFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(APPOINMENT_FILE));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            PatientAppoinment p;
            for(int i=0;i<patientAppoinmentlist.size();i++)
            {
                p=patientAppoinmentlist.get(i);
                line=p+"\n";
                bw.write(line);
            }
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

    //this method can initilize bedtracer
    void initializeBedTracer(){
        File bedtracFile=new File(BEDTRACER_FILE_NAME);//filename for checking existing
        if(!bedtracFile.exists()){ try {
            bedtracFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
       try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(bedtracFile)))
       {
           Object ob=ois.readObject();
           if(ob instanceof BedTracer)
           {
               bedTracer=(BedTracer) ob;
           }
       }catch (Exception e)
       {
           System.out.println("exception in bedtracer");
       }
    }
    //this can read the object to file
    void updateBedTracer()
    {
        File bedtracFile=new File(BEDTRACER_FILE_NAME);//filename for checking existing
        if(!bedtracFile.exists()){ try {
            bedtracFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(bedtracFile)))
        {
            oos.writeObject(bedTracer);

        }catch (Exception e)
        {
            System.out.println("Exception in updateBedTracer");

        }

    }
    void initailizeBookBedList()
    {
        File bedFile=new File(BOOK_BED_FILE_NANE);//filename for checking existing
        if(!bedFile.exists()){ try {
            bedFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(bedFile)))
        {
            Object ob=ois.readObject();
            if(ob instanceof BookBedList)
            {
                bookBedList=(BookBedList) ob;
            }
        }catch (Exception e)
        {
            System.out.println("exception in bedtracer");
        }
    }
    void updateBookBedList()
    {
        File bedFile=new File(BOOK_BED_FILE_NANE);//filename for checking existing
        if(!bedFile.exists()){ try {
            bedFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(bedFile)))
        {
            oos.writeObject(bookBedList);

        }catch (Exception e)
        {
            System.out.println("Exception in updateBedTracer");

        }
    }

    //this function initialize patietnprevious page

    void initilizeHistory()
    {
        File historyFile=new File(HISTORY_FILE_NAME);//filename for checking existing
        if(historyFile.exists()==false){ try {
            historyFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

        try//open file for reading date
        { br = new BufferedReader(new FileReader(HISTORY_FILE_NAME));
        }catch(Exception e)
        {
            System.out.println("oh!there is something mising.can't open file.please resolve itS");
        }

        while(true) {
            try {
                String line = null;   //this method can initilize patientlist
                line = br.readLine();
                //System.out.println(line);
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                int length=arr.length;
                if(length<6)
                {
                    String arr1[]=new String[6];
                    for(int i=0;i<length;i++) arr1[i]=arr[i];
                    for(int i=length;i<6;i++) arr1[i]=" ";
                    arr=arr1;
                }
                new PatientPreviousPage(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],10);
            } catch (Exception ex) {
                // System.out.println("exception creat on readline");
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //updata patient history
    void updatePatienHistory()
    {
        String line=null;
        BufferedWriter bw = null;
        File historyFile=new File(HISTORY_FILE_NAME);//filename for checking existing
        if(historyFile.exists()==false){ try {
            historyFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(HISTORY_FILE_NAME));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            PatientPreviousPage p;
            for(int i=0;i<previousPage.size();i++)
            {
                p=previousPage.get(i);
                line=p+"\n";
                bw.write(line);
            }
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


   //this method can initilize prescribtion.txt file
   void initilizePrescribtion()
   {
       File prescribtionFile=new File(PRESCRIBTION_FILE_NAME);//filename for checking existing
       if(prescribtionFile.exists()==false){ try {
           prescribtionFile.createNewFile();//if file doesn't created yet this method call and creat file
       } catch (IOException e) {
           e.printStackTrace();
       } }

       //read from file precbtion object
       try( ObjectInputStream ois=new ObjectInputStream(new FileInputStream(prescribtionFile))){
           Object obj;
           Presscribtion p=null;
           while (true)
           {
               obj=ois.readObject();//write object
               if(obj==null) break;
               p=(Presscribtion) obj;
               presscribtionList.add(p);
           }
       }
       catch(Exception e ) {
           //System.out.println("e");
       }
   }

   //this method can update object file
    void updatePrescribtionfile()
    {
        File prescribtionFile=new File(PRESCRIBTION_FILE_NAME);//filename for checking existing
        if(prescribtionFile.exists()==false){ try {
            prescribtionFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        } }

        //write objcet in file
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(prescribtionFile))){
            Presscribtion p=null;
            for(int i=0;i<presscribtionList.size();i++)
            {
                p=presscribtionList.get(i);
                oos.writeObject(p);
            }
        }catch (Exception e)
        {
           // System.out.println();
        }

    }
    //this  method can initilize payment file
    void initilizePayment()//giev correction of this code
    {
        File paymentFile=new File(PAYMENT_FILE);//filename for checking existing
        if(paymentFile.exists()==false){ try {
            paymentFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//open file for reading date
        { br = new BufferedReader(new FileReader(PAYMENT_FILE));
        }catch(Exception e)
        {
            System.out.println("oh!there is something mising.can't open file.please resolve itS");
        }

        while(true) {
            try {
                String line = null;   //this method can initilize patientlist
                line = br.readLine();
                //System.out.println(line);
                if (line == null) break;//problem ocour here;
                String arr[] = line.split(",");
                int length=arr.length;
                if(length<3)
                {
                    String arr1[]=new String[3];
                    for(int i=0;i<length;i++) arr1[i]=arr[i];
                    for(int i=length;i<3;i++) arr1[i]=" ";
                    arr=arr1;
                }
                //if(length<10) { for(int i=length;i<10;i++) arr[i]=" ";}
               paymentList.add(new Payment(arr[0],arr[1],arr[2]));
            } catch (Exception ex) {
                // System.out.println("exception creat on readline");
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updatePaymentFile()
    {
        String line=null;
        BufferedWriter bw = null;
        File paymentFile=new File(PAYMENT_FILE);//filename for checking existing
        if(paymentFile.exists()==false){ try {
            paymentFile.createNewFile();//if file doesn't created yet this method call and creat file
        } catch (IOException e) {
            e.printStackTrace();
        }}
        try//this method open file
        {
            bw=new BufferedWriter(new FileWriter(PAYMENT_FILE));
        }
        catch(Exception e)
        {
            System.out.println("trouble on while open for writing file");
        }

        try{//this method  write file
            Payment p;
            for(int i=0;i<patientlist.size();i++)
            {
                p=paymentList.get(i);
                line=p+"\n";
                bw.write(line);
            }
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


}
