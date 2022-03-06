package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Patient.conPatientObj;

public class PatientProfilePageController implements Initializable{
    private Page page;
    public AnchorPane anachor;
    public Label patient_id;
    public Label patient_email;
    public Label patient_name;
    public Label patien_password;
    public Label patient_contact;
    public Label patient_age;
    public Label patient_gender;
    public Label patient_bod;
    public Label patinet_marital_status;
    public Label patient_address;
    public Label patient_disease;
    public Button backFrom_profile;
    @FXML
    private Button update;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
         patient_id.setText(conPatientObj.getPatientId());
         patient_email.setText(conPatientObj.getEmail());
         patient_name.setText(conPatientObj.getPatientName());
         patien_password.setText(conPatientObj.getPassword());
         patient_contact.setText(conPatientObj.getContactNo());
         patient_age.setText(conPatientObj.getPatientAge());
         patient_gender.setText(conPatientObj.getPatientGender());
         patient_bod.setText(conPatientObj.getPatientDob());
         patinet_marital_status.setText(conPatientObj.getMaritalStatus());
         patinet_marital_status.setText(conPatientObj.getMaritalStatus());
         patient_address.setText(conPatientObj.getAddress());
         patient_disease.setText(conPatientObj.getSlectDisease());
    }
    @FXML
    void updateOnAction(ActionEvent event) {
        page.showPatientUpdatePage();

    }

    public void backFrom_profile_action(ActionEvent event) {
        page.showPatientHomePage();
    }

    //this page set the page
    void setPage(Page page)
    {
        this.page=page;
    }
}
