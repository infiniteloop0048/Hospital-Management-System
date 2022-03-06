package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import util.NetworkUtil;

import java.net.URL;
import java.util.ResourceBundle;
import static Hospital.Patient.conPatientObj;

public class PatientViewLastAppoinmentPageController implements Initializable {
    private Page page;
    @FXML
    private Button back;

    @FXML
    private Label dName;

    @FXML
    private Label pDisease;

    @FXML
    private Label date;

    @FXML
    private Label time;

    @FXML
    private Button update;

    @FXML
    void backOnAction(ActionEvent event) {

        page.showPatientAppoinmentPage();
    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PatientViewLastAppoinment recieve=new PatientViewLastAppoinment(conPatientObj.getPatientId());
        Object ob=null;
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        try{
            nc.write(recieve);
            ob=nc.read();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if(ob instanceof PatientViewLastAppoinment) {
            recieve = (PatientViewLastAppoinment) ob;

            dName.setText(recieve.getdName());
            pDisease.setText(recieve.getpDisease());
            date.setText(recieve.getDate());
            time.setText(recieve.getTime());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You have no appoinment");
            alert.setHeaderText("No appoinment");
            alert.setContentText("No appoinment");
            alert.showAndWait();
        }


    }

    //this can set the page
    void setPage(Page page)
    {
        this.page=page;
    }
}
