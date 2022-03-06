package Hospital;


import util.NetworkUtil;


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
                 if (o instanceof LPatient) {

                     LPatient lPatient = (LPatient) o;
                     index= SearchLog.patientSearch(lPatient.userName, lPatient.passWord);

                   if(index>-1) {
                       Patient p = Patient.patientlist.get(index);
                       nc.write(p);
                       System.out.println("server write object");
                   }
                   else nc.write(null);
                 }
                 if(o instanceof Patient)
                 {
                     Patient patient=(Patient) o;
                     if(SearchLog.patientValidId(patient.getPatientId())){
                         Patient p=new Patient(patient.getPatientId(),patient.getPatientName(),patient.getEmail(),patient.getPassword(),patient.getContactNo(),patient.getPatientGender(),patient.getPatientAge(),patient.getPatientAge(),patient.getMaritalStatus(),patient.getSlectDisease(),patient.getAddress(),10);
                         nc.write(p);
                     }
                     else nc.write(null);
                 }

             }}
         catch (Exception e)
         {
             System.out.println("there is an exception in serve method in server class"+e);
         }
     }
}
