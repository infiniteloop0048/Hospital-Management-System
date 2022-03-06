package Hospital;


import util.NetworkUtil;

public class Client {
    public Client(String ip, int port, LPatient lPatient)
    {
        NetworkUtil nc=new NetworkUtil(ip,port);
        nc.write(lPatient);
        Object o=nc.read();
        if(o!=null)
            if(o instanceof Patient)
            {
                Patient p=(Patient) o;

    }

    }
}
