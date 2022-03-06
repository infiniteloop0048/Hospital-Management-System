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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.ClientMain.msg;
import static Hospital.Patient.conPatientObj;

public class PatientUpdateProfileController implements Initializable {

    private Page page;
    @FXML
    private AnchorPane PatientSign_Anchor;

    @FXML
    private Button backFrom_patient;

    @FXML
    private TextField Patient_name;

    @FXML
    private TextField Patient_email;

    @FXML
    private TextField Patient_mobile;

    @FXML
    private TextField Patient_age;

    @FXML
    private TextField Patient_DOB;

    @FXML
    private TextArea Patient_address;

    @FXML
    private Button Patient_sign_up_submit;

    @FXML
    private ComboBox<String> PatientGenderId;

    @FXML
    private ComboBox<String> PatientMarital_id;

    @FXML
    private TextField Patient_password;

    @FXML
    private ComboBox<String> Patient_disease_silect_id;

    ObservableList<String> list2 = FXCollections.observableArrayList("MALE","FEMALE","OTHERS");
    ObservableList<String> list3 = FXCollections.observableArrayList("MARRIED","DEVORCED","SINGLE","WIDOW");
    ObservableList<String> list4 = FXCollections.observableArrayList("Normal Disease","Heart Disease","Skin Disease","Cancer","Infectious Disease","Private Disease","Liver Disease","Big Disease","Other Disease");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Patient_name.setText(conPatientObj.getPatientName());
        Patient_email.setText(conPatientObj.getEmail());
        Patient_mobile.setText(conPatientObj.getContactNo());
        Patient_age.setText(conPatientObj.getPatientAge());
        Patient_DOB.setText(conPatientObj.getPatientDob());
        Patient_address.setText(conPatientObj.getAddress());
        PatientGenderId.setItems(list2);
        PatientMarital_id.setItems(list3);
        Patient_disease_silect_id.setItems(list4);
        PatientGenderId.setValue(conPatientObj.getPatientGender());
        PatientMarital_id.setValue(conPatientObj.getMaritalStatus());
        Patient_disease_silect_id.setValue(conPatientObj.getSlectDisease());
        Patient_password.setText(conPatientObj.getPassword());



    }

    @FXML
    void PatientGenderAction(ActionEvent event) {

    }

    @FXML
    void PatientIdCheckOnAction(ActionEvent event) {

    }

    @FXML
    void PatientMarital_action(ActionEvent event) {

    }

    @FXML
    void Patient_disease_silect_id_action(ActionEvent event) {

    }

    @FXML
    void Patient_sign_up_submit_action(ActionEvent event) {

        NetworkUtil nc = new NetworkUtil("127.0.0.1", 20000);
        UPatient ob = new UPatient(conPatientObj.getPatientId(), Patient_name.getText(), Patient_email.getText(), Patient_password.getText(), Patient_mobile.getText(), PatientGenderId.getValue(), Patient_age.getText(), Patient_DOB.getText(), PatientMarital_id.getValue(), Patient_disease_silect_id.getValue(), Patient_address.getText());
        Object o = null;
        try {
            nc.write(ob);
            o = nc.read();
        } catch (Exception e) {
            System.out.println("exception in patientsignup controller class");
        }
        if (o != null) {
            if (o instanceof Patient) {
                conPatientObj = (Patient) o;
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

    @FXML
    void backFrom_patient_action(ActionEvent event) {
        page.showPatientProfilePage();

    }


    //Set the page
    void setPage(Page page)
    {
        this.page=page;
    }


}
