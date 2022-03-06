package Hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presscribtion implements Serializable {

    private String id;
    private String disease;
    private String test;
    private String medicin;
    int a;

    public static List<Presscribtion> presscribtionList=new ArrayList<>();
    public static final String PRESCRIBTION_FILE_NAME="Prescribtion.txt";

    //constructor
    public Presscribtion(String id, String disease, String test, String medicin) {
        this.id = id;
        this.disease = disease;
        this.test = test;
        this.medicin = medicin;
    }
    //addpatient construtor

    public Presscribtion(String id, String disease, String test, String medicin, int a) {
        this.id = id;
        this.disease = disease;
        this.test = test;
        this.medicin = medicin;
        this.a = a;
        presscribtionList.add(this);
    }
    //--------------getter and setter----------------


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getMedicin() {
        return medicin;
    }

    public void setMedicin(String medicin) {
        this.medicin = medicin;
    }

    @Override
    public String toString() {
        return  id+","+disease+","+test+","+medicin;
    }
}
