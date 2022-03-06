package Hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Payment implements Serializable {
    String Pid;
    String pName;
    String money;
    int  a;

    public static List<Payment> paymentList=new ArrayList<>();
    public static final String PAYMENT_FILE="pay.txt";

    //-----------constructor-----------


    public Payment(String pid, String pName, String money) {
        Pid = pid;
        this.pName = pName;
        this.money = money;
    }

    public Payment(String pid, String pName, String money, int a) {
        Pid = pid;
        this.pName = pName;
        this.money = money;
        this.a = a;
        paymentList.add(this);
    }

    //---------------------getter and setter-----------------

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return Pid+","+pName+","+money;
    }
}
