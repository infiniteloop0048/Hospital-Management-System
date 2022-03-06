package Hospital;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sun.nio.ch.Net;
import util.NetworkUtil;

import static Hospital.ClientMain.msg;
import static Hospital.Patient.conPatientObj;


public class BedPageController implements Initializable {
        private Page page;

        boolean [] alocateBed={true,true,true,true};


    @FXML
    private Label bed1;

    @FXML
    private Label bed2;

    @FXML
    private Label bed3;

    @FXML
    private Label bed4;


    @FXML
        private Button b1;

        @FXML
        private Button c1;

        @FXML
        private Button b2;

        @FXML
        private Button b4;

        @FXML
        private Button b3;

        @FXML
        private Button c4;

        @FXML
        private Button c3;

        @FXML
        private Button c2;

        @FXML
        private Label name;

        @FXML
        private Label bedNo;
        @FXML
        private Button back;
        @FXML
        private Button submit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setText(conPatientObj.getPatientName());
        BedTracer bedTracer=new BedTracer();
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Object o=null;
        try {
            nc.write(bedTracer);
            o = nc.read();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(o instanceof BedTracer)
        {
            bedTracer=(BedTracer) o;
        }
        alocateBed=bedTracer.getAlocateBed();
        //write code to implemetn intital condition
        if(!alocateBed[0])
        {
            bed1.setText("Booked");
        }
        if(!alocateBed[1])
        {
            bed2.setText("Booked");
        }
        if(!alocateBed[2])
        {
            bed3.setText("Booked");
        }
        if(!alocateBed[3])
        {
            bed4.setText("Booked");
        }
        else
        bedNo.setText("empty");

    }

        @FXML
        void b1OnAction(ActionEvent event) {
            if(alocateBed[0])
            {
                alocateBed[0]=false;
                bed1.setText("Booked");
                bedNo.setText("1");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Booked");
                alert.setHeaderText("Already Booked");
                alert.setContentText("Already Booked please chose another one");
                alert.showAndWait();

            }
        }

        @FXML
        void b2OnAction(ActionEvent event) {
            if(alocateBed[1])
            {
                alocateBed[1]=false;
                bed2.setText("Booked");
                bedNo.setText("2");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Booked");
                alert.setHeaderText("Already Booked");
                alert.setContentText("Already Booked please chose another one");
                alert.showAndWait();

            }

        }

        @FXML
        void b3OnAction(ActionEvent event) {
            if(alocateBed[2])
            {
                alocateBed[2]=false;
                bed3.setText("Booked");
                bedNo.setText("3");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Booked");
                alert.setHeaderText("Already Booked");
                alert.setContentText("Already Booked please chose another one");
                alert.showAndWait();

            }

        }

        @FXML
        void b4OnAction(ActionEvent event) {
            if(alocateBed[3])
            {
                alocateBed[3]=false;
                bed4.setText("Booked");
                bedNo.setText("4");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Already Booked");
                alert.setHeaderText("Already Booked");
                alert.setContentText("Already Booked please chose another one");
                alert.showAndWait();

            }

        }

        @FXML
        void c1OnAction(ActionEvent event) {
            alocateBed[0]=true;
            bed1.setText("empty");
            bedNo.setText("empty");
        }

        @FXML
        void c2OnAction(ActionEvent event) {

            alocateBed[1]=true;
            bed2.setText("empty");
            bedNo.setText("empty");
        }

        @FXML
        void c3OnAction(ActionEvent event) {
            alocateBed[2]=true;
            bed3.setText("empty");
            bedNo.setText("empty");

        }

        @FXML
        void c4OnAction(ActionEvent event) {

            alocateBed[3]=true;
            bed4.setText("empty");
            bedNo.setText("empty");
        }
    @FXML
    void backOnAction(ActionEvent event) {
        page.showPatientHomePage();
    }
    @FXML
    void submitOnAction(ActionEvent event) {//this can send the changeable data
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        BookedBed ob=new BookedBed(conPatientObj.getPatientId(),conPatientObj.getPatientName(),bedNo.getText(),alocateBed);
        try{
            nc.write(ob);
        }  catch (Exception e)
        {
            System.out.println("exception in patientsignup controller class");
        }
        Stage primaryStage=new Stage();
        msg="  BED BOOKED";//this msg is a static method of client method for show msg
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdateSucces.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();

    }
    //Set the page
    void setPage(Page page)
    {
        this.page=page;
    }
}
