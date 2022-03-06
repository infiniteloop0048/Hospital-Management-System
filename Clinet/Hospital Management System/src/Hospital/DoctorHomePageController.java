package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Doctor.conDoctor;

public class DoctorHomePageController implements Initializable{
    @FXML
    private Label DoctorName;
    private Page page;
    public AnchorPane homedoctor;
    public Button view_profile;
    public Button view_appointment;
    public Button logout;

    @FXML
    private Button report;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DoctorName.setText(conDoctor.getDoctorName());

    }

    public void backToHome_action(ActionEvent event) {  page.showMainPage();
    }

    public void view_profile_action(ActionEvent event) throws IOException{
       page.showDoctorProfilePage();

    }

    public void view_appointment_action(ActionEvent event) {
        page.showDoctorViewAppoinmentPage();
    }
    @FXML
    void reportOnAction(ActionEvent event) {
        page.showDoctorAddReportPage();

    }


    public void logout_action(ActionEvent event) {
        page.showMainPage();
    }


    //this method set the page
    void setPage(Page page)
    {
        this.page=page;
    }


}
