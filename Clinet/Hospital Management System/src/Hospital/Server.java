package Hospital;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;

 class Server implements Runnable {
    ServerSocket serverSocket;
    Thread thr;
    public Server(int port)
    {

        try{
            System.out.println("server is open");
            serverSocket=new ServerSocket(port);
            thr=new Thread(this);
            thr.start();
        }catch (Exception e)
        {
            System.out.println("Exception"+e);
        }
    }
    public void run()
    {
        try{
        while(true)
        {

            Socket socket=serverSocket.accept();
            System.out.println("server is connected to socket");
            serve(socket);
        } }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void serve(Socket socket)
    {
        NetworkUtil nc=new NetworkUtil(socket);
        new ServerWorkThread(nc);

    }
}
