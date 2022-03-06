package Hospital;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.NetworkUtil;
import static Hospital.Patient.conPatientObj;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class PatirntSignUp_ControllerClass extends Component implements Initializable{
    private Patient ob;
    private int index;
    private Page patientPage;
    public AnchorPane PatientSign_Anchor;
    public Button backFrom_patient;
    public ComboBox<String> PatientGenderId;
    public ComboBox<String> PatientMarital_id;
    public TextField Patient_id;
    public TextField Patient_name;
    public TextField Patient_email;
    public TextField Patient_mobile;
    public TextField Patient_age;
    public TextField Patient_DOB;
    public TextArea Patient_address;
    public Button Patient_sign_up_submit;
    public PasswordField Patient_password;
    public ComboBox<String> Patient_disease_silect_id;
    ObservableList<String> list2 = FXCollections.observableArrayList("MALE","FEMALE","OTHERS");
    ObservableList<String> list3 = FXCollections.observableArrayList("MARRIED","DEVORCED","SINGLE","WIDOW");
    ObservableList<String> list4 = FXCollections.observableArrayList("Normal Disease","Heart Disease","Skin Disease","Cancer","Infectious Disease","Private Disease","Liver Disease","Big Disease","Other Disease");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    PatientGenderId.setItems(list2);
    PatientMarital_id.setItems(list3);
    Patient_disease_silect_id.setItems(list4);
    }

    public void backFrom_patient_action(ActionEvent event) throws IOException{
        patientPage.showMainPage();
    }

    public void PatientGenderAction(ActionEvent event) {
        String PatientGender_value =  PatientGenderId.getValue();
    }

    public void PatientMarital_action(ActionEvent event) {
         String PatientMarital_value = PatientMarital_id.getValue();
    }

    public void Patient_disease_silect_id_action(ActionEvent event) {
    }

    public void Patient_sign_up_submit_action(ActionEvent event) throws IOException{
        //Patient a = new Patient(Patient_id.getText(),Patient_name.getText(),Patient_email.getText(),Patient_password.getText(),Patient_mobile.getText(),PatientGenderId.getValue(),Patient_age.getText(),PatientMarital_id.getValue(),Patient_disease_silect_id.getValue(),Patient_address.getText());


           if ((Patient_id.getText()==null)||(Patient_name.getText()==null)||(Patient_email.getText()==null)||(Patient_password.getText()==null)||(Patient_mobile.getText()==null)||(PatientGenderId.getValue()==null)||(Patient_age.getText()==null)||(PatientMarital_id.getValue()==null)||(Patient_disease_silect_id.getValue()==null)||(Patient_address.getText()==null))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert Messege");
                alert.setHeaderText("Unfilled Some Field");
                alert.setContentText("You Have to fill all the filled");
                alert.showAndWait();
            }
            else
                {
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Patient ob = new Patient(Patient_id.getText(),Patient_name.getText(),Patient_email.getText(),Patient_password.getText(),Patient_mobile.getText(),PatientGenderId.getValue(),Patient_age.getText(),Patient_DOB.getText(),PatientMarital_id.getValue(),Patient_disease_silect_id.getValue(),Patient_address.getText());
        Object o = null;
        try{
             nc.write(ob);
             o=nc.read();
         }  catch (Exception e)
        {
            System.out.println("exception in patientsignup controller class");
        }
        if(o!=null)
        {
            if(o instanceof Patient)
            {
                conPatientObj=(Patient) o;
                patientPage.showPatientHomePage();

            }

        }
        else
           {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Invalid USERID");
               alert.setHeaderText("Invalid PATIENTID");
               alert.setContentText("This userid is mathch with other please try unic one");
               alert.showAndWait();
           }}

    }

    public void PatientIdCheckOnAction(ActionEvent actionEvent) {
//        if(!SearchLog.patientValidId(Patient_id.getText()))
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Incorrect Credentials");
//            alert.setHeaderText("Incorrect Credentials");
//            alert.setContentText("The username and password you provided is not correct.");
//            alert.showAndWait();
//        }
      //  System.out.println("fuck this");
    }
    void setPage(Page page)
    {
        this.patientPage=page;
    }
//    Patient setPatient() {return  ob;};
//    int setPatientIndex() {return  index;}
}
