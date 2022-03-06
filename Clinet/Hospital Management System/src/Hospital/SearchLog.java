package Hospital;



import static Hospital.Patient.patientlist;

public class SearchLog {

    public static int patientSearch(String userid, String pass)
    {
        int index=-1;
        Patient ob=null;
        for(int i = 0; i< patientlist.size(); i++)
        {
            ob= patientlist.get(i);
            if(ob.getPatientId().equals(userid))
            {
                index=i;
                break;
            }
        }
        if(index==-1) return -1;
        if(ob.getPassword().equals(pass)) return index;
        else return -1;

    }


    public static boolean patientValidId(String userid)
    {

        Patient ob=null;

        for(int i = 0; i< patientlist.size(); i++)

        {
            ob = patientlist.get(i);

            if(ob.getPatientId().equals(userid))
            {

                return false;
            }
        }
        return true;
    }






}
