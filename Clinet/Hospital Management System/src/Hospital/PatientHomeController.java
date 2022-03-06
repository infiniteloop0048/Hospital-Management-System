package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Patient.conPatientObj;


public class PatientHomeController implements Initializable{

    public Label patientName;
    public Button ProfileButton;
    private Page page;
    public AnchorPane signUp_submit;
    public Button to_home;
    public Button logOut;
    @FXML
    private Button patientAppointment;
    @FXML
    private Button bed;
    @FXML
    private Button payBill;

    @FXML
    private Button history;



//    public Label PatientName;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
      patientName.setText(conPatientObj.getPatientName());
    }
    //this method can save the level name which diplay as patinet name



    public void to_home_action(ActionEvent event) throws IOException{
        page.showMainPage();
    }

    public void profileOnAction(ActionEvent actionEvent) {
        page.showPatientProfilePage();

    }
    @FXML
    void AppoinmentOnAction(ActionEvent event) {
         page.showPatientAppoinmentPage();
    }


    public void logOutOnAction(ActionEvent event) throws IOException{

        page.showMainPage();
    }
    @FXML
    void bedOnAction(ActionEvent event) {
        page.showBedPage();

    }
    @FXML
    void historyOnAction(ActionEvent event) {

        page.showPatietHistoryPage();
    }

    @FXML
    void payBillOnAction(ActionEvent event) {
        page.showPaybill();

    }
    void setPage(Page page){ this.page=page;}


}
