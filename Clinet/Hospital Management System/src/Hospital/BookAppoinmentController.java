package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.ClientMain.msg;
import static Hospital.Patient.conPatientObj;

public class BookAppoinmentController implements Initializable{


    private Page page;
    public Button edit;
    public Button back;
    public ComboBox<String> doctorId;
    public ComboBox<String> select_disease;
    public ComboBox<String > doctorName;
    public DatePicker select_date;
    public TextField select_time;
    public Button submit;
    private  SetDoctorNameIdcom set;

    ObservableList<String> list = FXCollections.observableArrayList("Normal Disease","Heart Disease","Skin Disease","Cancer","Infectious Disease","Private Disease","Liver Disease","Big Disease","Other Disease");
    ObservableList<String> list1;
    ObservableList<String> list2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        select_disease.setItems(list);
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        PatientSetDoctor patientSetDoctor=new PatientSetDoctor(conPatientObj.getPatientName(),conPatientObj.getPatientId());
        Object ob=null;
        try{
            nc.write(patientSetDoctor);
            ob=nc.read();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if(ob!=null)
        {
            if(ob instanceof SetDoctorNameIdcom)
                set=(SetDoctorNameIdcom) ob;
        }
        list1=FXCollections.observableArrayList(set.doctorNameList);
        list2=FXCollections.observableArrayList(set.doctorIdList);
        doctorName.setItems(list1);
        doctorId.setItems(list2);
    }

    public void submit_action(ActionEvent event) {
        System.out.println("where is the problem");
        PatientAppoinment patientAppoinment=new PatientAppoinment(conPatientObj.getPatientName(),conPatientObj.getPatientId(),doctorName.getValue(),doctorId.getValue(),select_disease.getValue(),select_date.getValue().toString(),select_time.getText());
        System.out.println("where is the problem");
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Object ob=null;
        try{
            System.out.println();
            nc.write(patientAppoinment);
            ob=nc.read();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("submit on action");
        if(ob instanceof PatientAppoinment)

        {
            patientAppoinment=(PatientAppoinment) ob;
            //this method for show sucessfully msg
            Stage primaryStage=new Stage();
            msg="  APPOINMENT";//this msg is a static method of client method for show msg
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
        System.out.println(patientAppoinment);

    }

    public void comvb_action(ActionEvent event) {//select_time.setText(select_disease.getValue());
    }
    public void editOnAction(ActionEvent actionEvent) {

    }

    public void backONAction(ActionEvent actionEvent) {
        page.showPatientAppoinmentPage();

    }

    //set the page
    void setPage(Page page){
        this.page=page;
    }


}
