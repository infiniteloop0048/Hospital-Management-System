package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import util.NetworkUtil;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.ClientMain.msg;
import static Hospital.Doctor.conDoctor;
import static Hospital.Patient.conPatientObj;

public class DoctorUpdateProfilePageController implements Initializable {

    private  Page page;
    public TextField doctor_email;
    public TextField doctor_contact;
    public TextField doctor_designation;
    public TextField doctor_name;
    public TextField doctor_graduation;
    public ComboBox<String> doctor_gendre;
    public ComboBox<String> doctor_department;
    public TextArea doctor_address;
    public TextField password_id;
    public Button toback_id;
    public Button backto_home;
    public Button service_id;
    public Button contact_id;
    ObservableList<String> list4 = FXCollections.observableArrayList("Psychiatrist","Immunologist","Skin DiseaseAnesthesiologist","Cardiologist","Dermatologist","Endocrinologist","Pathologist","Gynecologist","Hematologist","Nephrologist","Neurologist");
    ObservableList<String> list = FXCollections.observableArrayList("MALE","FEMALE","OTHERS");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doctor_department.setItems(list4);
        doctor_gendre.setItems(list);
        doctor_name.setText(conDoctor.getDoctorName());
        doctor_email.setText(conDoctor.getDoctorEmail());
        doctor_contact.setText(conDoctor.getDoctorEmail());
        doctor_designation.setText(conDoctor.getDoctorDesignation());
        doctor_graduation.setText(conDoctor.getDoctorGraduation());
        doctor_gendre.setValue(conDoctor.getDoctorGender());
        doctor_department.setValue(conDoctor.getDoctorDepartment());
        doctor_address.setText(conDoctor.getDocotorAdress());
        password_id.setText(conDoctor.getDoctorPassword());

    }

    //the controller method
    @FXML
    void back_action(ActionEvent event) {
        page.showDoctorProfilePage();

    }

    @FXML
    void backto_home_action(ActionEvent event) {
        page.showDoctorProfilePage();

    }

    @FXML
    void contact_action(ActionEvent event) {

    }

    @FXML
    void doctor_action(ActionEvent event) {

    }

    @FXML
    void service_action(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {//this method can update doctor profile

        NetworkUtil nc = new NetworkUtil("127.0.0.1", 20000);
        UDoctor ob=new UDoctor(conDoctor.getDoctorId(),doctor_name.getText(),doctor_email.getText(),password_id.getText(),doctor_contact.getText(),doctor_gendre.getValue(),doctor_department.getValue(),doctor_graduation.getText(),doctor_address.getText(),doctor_designation.getText());
        Object o = null;
        try {
            nc.write(ob);
            o = nc.read();
        } catch (Exception e) {
            System.out.println("exception in patientsignup controller class");
        }
        if (o != null) {
            if (o instanceof Doctor) {
                conDoctor = (Doctor) o;
                System.out.println("update sucessfully");
                Stage primaryStage=new Stage();
                msg="UPDATE";//this msg is a static method of client method for show msg
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

        }



    }




    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }
}
