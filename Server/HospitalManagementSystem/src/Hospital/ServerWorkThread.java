package Hospital;


import util.NetworkUtil;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

import static Hospital.Doctor.doctorList;
import static Hospital.Main.bedTracer;
import static Hospital.Main.bookBedList;
import static Hospital.Patient.patientlist;
import static Hospital.PatientAppoinment.conPatientAppoinment;
import static Hospital.PatientAppoinment.patientAppoinmentlist;
import static Hospital.PatientPreviousPage.previousPage;
import static Hospital.Payment.paymentList;
import static Hospital.Presscribtion.presscribtionList;


class ServerWorkThread implements Runnable {
     private  NetworkUtil nc;
     private Thread thr;
    int index=-1;
    ServerWorkThread(NetworkUtil nc)
     {
         this.nc=nc;
         thr=new Thread(this);
         thr.start();
     }
     public void run()
     {
         try {
             Object o = nc.read();

             if (o != null) {

                 if (o instanceof LPatient) {//this method can take patient id and password and back match patient

                     LPatient lPatient = (LPatient) o;
                     index= SearchLog.patientSearch(lPatient.userName, lPatient.passWord);

                   if(index>-1) {
                       Patient p = patientlist.get(index);
                       nc.write(p);
                       System.out.println("server write object");
                   }
                   else nc.write(null);
                 }
                else if(o instanceof Patient)//this can sign up a patient with proper userid
                 {
                     Patient patient=(Patient) o;
                     if(SearchLog.patientValidId(patient.getPatientId())){
                         Patient p=new Patient(patient.getPatientId(),patient.getPatientName(),patient.getEmail(),patient.getPassword(),patient.getContactNo(),patient.getPatientGender(),patient.getPatientAge(),patient.getPatientAge(),patient.getMaritalStatus(),patient.getSlectDisease(),patient.getAddress(),10);
                         nc.write(p);
                     }
                     else nc.write(null);
                 }


                 else if(o instanceof UPatient) //this can update profile
                 {
                     int index=-1;
                     UPatient up=(UPatient) o;
                     Patient p=new Patient(up.getPatientId(),up.getPatientName(),up.getEmail(),up.getPassword(),up.getContactNo(),up.getPatientGender(),up.getPatientAge(),up.getPatientDob(),up.getMaritalStatus(),up.getSlectDisease(),up.getAddress());
                     Patient ob=null;
                     for(int i=0;i<patientlist.size();i++)
                     {
                         ob=patientlist.get(i);
                         if(ob.getPatientId().equals(up.getPatientId()))
                         {
                             index=i;
                             patientlist.remove(i);
                             patientlist.add(i,p);
                             break;
                         }
                     }
                     if(index!=-1) nc.write(p);
                     else nc.write(null);
                 }




                 else if(o instanceof LDoctor)  //this method can seatch a doctor with proper user id and password
                 {
                     LDoctor lDoctor=(LDoctor) o;
                     index=SearchLog.doctorSearch(lDoctor.getUserName(),lDoctor.getPassword());
                     if(index>-1)
                     {
                         Doctor doctor=Doctor.doctorList.get(index);
                         nc.write(doctor);
                     }
                     else nc.write(null);
                 }



                else if(o instanceof Doctor)//this can sing up a doctor with porper userid
                 {
                     Doctor doctor=(Doctor) o;
                     if(SearchLog.doctorValidId(doctor.getDoctorId())){
                         Doctor d=new Doctor(doctor.getDoctorId(),doctor.getDoctorName(),doctor.getDoctorEmail(),doctor.getDoctorPassword(),doctor.getDoctorContactNo(),doctor.getDoctorGender(),doctor.getDoctorDepartment(),doctor.getDoctorGraduation(),doctor.getDocotorAdress(),doctor.getDoctorDesignation(),10);
                         nc.write(d);
                     }
                     else nc.write(null);
                 }

                 else if(o instanceof UDoctor) //this can update doctorprofile and send the data
                 {
                     int index=-1;
                     UDoctor ud=(UDoctor) o;
                     Doctor d=new Doctor(ud.getDoctorId(),ud.getDoctorName(),ud.getDoctorEmail(),ud.getDoctorPassword(),ud.getDoctorContactNo(),ud.getDoctorGender(),ud.getDoctorDepartment(),ud.getDoctorGraduation(),ud.getDocotorAdress(),ud.getDoctorDesignation());
                     Doctor ob=null;
                     for(int i=0;i<doctorList.size();i++)
                     {
                         ob=doctorList.get(i);
                         if(ob.getDoctorId().equals(ud.getDoctorId()))
                         {
                             index=i;
                             doctorList.remove(i);
                             doctorList.add(i,d);
                             break;
                         }
                     }
                     if(index!=-1) nc.write(d);
                     else nc.write(null);
                 }

                 else if(o instanceof PatientSetDoctor)//this is for the action of setcomobox
                 {
                     PatientSetDoctor patientSetDoctor=(PatientSetDoctor) o;
                     SetDoctorNameIdcom set=new SetDoctorNameIdcom();

                     for(int i=0;i<doctorList.size();i++)
                     {
                         set.doctorNameList.add(doctorList.get(i).getDoctorName());
                         set.doctorIdList.add(doctorList.get(i).getDoctorId());
                     }
                     nc.write(set);
                 }

                 else if(o instanceof PatientAppoinment)  //this can read the appoinmentfile
                 {
                     int index=-1;
                     PatientAppoinment p=(PatientAppoinment) o;
                     PatientAppoinment pap=null;
                     for(int i=0;i<patientAppoinmentlist.size();i++)  //search for patientappoinment if it is match or not match
                     {
                         pap=patientAppoinmentlist.get(i);
                         if(pap.getPId().equals(p.getPId()))
                         {
                             index=i;
                             break;
                         }
                     }
                     if(index!=-1) {
                         patientAppoinmentlist.remove(index);//delete match appoinment
                         patientAppoinmentlist.add(index,p);//add update appoinment on particular person
                         nc.write(p);//send this to the patient
                     }
                      else if(index==-1) {
                         PatientAppoinment patientAppoinment1 = new PatientAppoinment(p.getPName(), p.getPId(), p.getDName(), p.getDId(), p.getPDisease(), p.getDate(), p.getTime(), 10);//cteat new appoinment
                         nc.write(patientAppoinment1);
                     }

                 }

                 else if(o instanceof SendAppoinmetList)  //this can read the doctorappoinment
                 {
                     List<PatientAppoinment> list=new ArrayList<>();
                     PatientAppoinment papt=null;
                     SendAppoinmetList send=(SendAppoinmetList) o;
                     for(int i=0;i<patientAppoinmentlist.size();i++)
                     {
                         papt=patientAppoinmentlist.get(i);
                         System.out.println(papt.getDId());
                         System.out.println(send.getUserId());
                         if(papt.getDId().equals(send.getUserId()))
                         {
                             list.add(papt);
                             System.out.println(papt);
                         }
                     }
                     send.setAppoinmentLsit(list);
                     nc.write(send);
                 }

                 else if(o instanceof PatientViewLastAppoinment)//patient view his last appoinment
                 {
                     PatientViewLastAppoinment send=(PatientViewLastAppoinment) o;
                     PatientAppoinment pa=null;
                     int i;
                     for(i=0;i<patientAppoinmentlist.size();i++)
                     {
                         pa=patientAppoinmentlist.get(i);
                         if(pa.getPId().equals(send.getpUserId()))
                         {
                             send=new PatientViewLastAppoinment(pa.getPId(),pa.getDName(),pa.getPDisease(),pa.getDate(),pa.getTime());
                            nc.write(send);
                             break;
                         }

                     }
                     if(i==patientAppoinmentlist.size()) nc.write(null);

                 }

                 //this is for write bedallocation
                 else if(o instanceof BedTracer){
                     nc.write(bedTracer);//this is send initail condition of the array
                 }
                 //this is for bed allotmentfile
                 else if(o instanceof BookedBed)
                 {
                     BookedBed bookedBed=(BookedBed) o;
                     bedTracer.alocateBed=bookedBed.currentArrray;
                     bookBedList.bedList.add(bookedBed);
                 }

                 //this can send patient hospital history
                 else if(o instanceof PatientPreviousPage)
                 {
                     PatientPreviousPage send=(PatientPreviousPage) o;
                     PatientPreviousPage p=null;
                     index=-1;
                     for(int i=0;i<previousPage.size();i++)
                     {
                         p=previousPage.get(i);
                         if(p.getpId().equals(send.getpId()))
                         {
                             index=i;
                             send=previousPage.get(i);
                             break;
                         }
                     }
                     if(index!=-1) nc.write(send);
                     else nc.write(null);
                 }

                 else if(o instanceof PrescribPageInit)
                 {
                     PrescribPageInit get=(PrescribPageInit) o;
                     Patient p=null;
                     for(int i=0;i<patientlist.size();i++)
                     {
                         p=patientlist.get(i);
                         get.id.add(p.getPatientId());
                         get.idName.put(p.getPatientId(),p.getPatientName());
                     }

                    nc.write(get);
                 }
                 else if(o instanceof Presscribtion)
                 {
                     Presscribtion get=(Presscribtion) o;
                     presscribtionList.add(get);
                 }

                 else if(o instanceof DoctorReportId)
                 {
                     DoctorReportId d=(DoctorReportId) o;
                     Presscribtion p=null;
                     int index=-1;
                     for(int i=0;i<presscribtionList.size();i++)
                     {
                         p=presscribtionList.get(i);
                         if(p.getId().equals(d.getId()))
                         {
                             index=i;
                             break;
                         }
                     }
                     if(index!=-1) nc.write(p);
                     else nc.write(null);
                 }
                 else if(o instanceof Payment)
                 {
                     Payment p=(Payment) o;
                     paymentList.add(p);
                 }


             }
         }
         catch (Exception e)
         {
             System.out.println("there is an exception in serve method in server class"+e);
         }
     }
}
