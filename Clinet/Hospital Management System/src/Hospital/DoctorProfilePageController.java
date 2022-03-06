package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Doctor.conDoctor;

public class DoctorProfilePageController implements Initializable{
    private Page page;
    public AnchorPane dct_prf_anchor;
    @FXML
    private Label ID;
    @FXML
    private Label doctorName;

    @FXML
    private Label doctorEmail;

    @FXML
    private Label doctorPassword;

    @FXML
    private Label doctorContact;

    @FXML
    private Label doctorDepartment;

    @FXML
    private Label doctorGender;

    @FXML
    private Label doctorQualification;

    @FXML
    private Label doctorAddress;

    @FXML
    private Label doctorDesingation;

    @FXML
    private Button update;

    @FXML
    private Button submit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ID.setText(conDoctor.getDoctorId());
        doctorName.setText(conDoctor.getDoctorName());
        doctorEmail.setText(conDoctor.getDoctorEmail());
        doctorPassword.setText(conDoctor.getDoctorPassword());
        doctorContact.setText(conDoctor.getDoctorContactNo());
        doctorDepartment.setText(conDoctor.getDoctorDepartment());
        doctorGender.setText(conDoctor.getDoctorGender());
        doctorQualification.setText(conDoctor.getDoctorGraduation());
        doctorAddress.setText(conDoctor.getDocotorAdress());
        doctorDesingation.setText(conDoctor.getDoctorDesignation());


    }

    public void backFrom_profile_action(ActionEvent actionEvent) {
        page.showDoctorHomePage();
    }
    @FXML
    void submitOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {
        page.showDoctorUpdateProfilePage();

    }

    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }


}
