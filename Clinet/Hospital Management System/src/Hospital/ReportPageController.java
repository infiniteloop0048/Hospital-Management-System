package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.NetworkUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Hospital.Patient.conPatientObj;
import static Hospital.Patient.patientlist;

public class ReportPageController implements Initializable {


    private Page page;
    @FXML
    private Label name;

    @FXML
    private Label pay;

    @FXML
    private Label rDate;

    @FXML
    private Label aDate;

    @FXML
    private Label disease;

    @FXML
    private Label bed;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        PatientPreviousPage recieve=new PatientPreviousPage(conPatientObj.getPatientId());
        Object o=null;
        try{
            nc.write(recieve);
            o=nc.read();
        }catch (Exception e)
        {
            System.out.println("Report controller page exception");
        }
        if(o instanceof PatientPreviousPage) {
            recieve = (PatientPreviousPage) o;
            System.out.println(recieve);
            name.setText(conPatientObj.getPatientName());
            disease.setText(recieve.getDisease());
            aDate.setText(recieve.getaDate());
            rDate.setText(recieve.getrDate());
            pay.setText(recieve.getPay());
            bed.setText(recieve.getBed());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("YOUR REPORT ISN'T READY");
            alert.setHeaderText("REPORT IS PROCESSING");
            alert.setContentText("PLEASE WAIT YOUR REPORT ISN'T READY YET");
            alert.showAndWait();
        }
    }

    @FXML
    void backOnAction(ActionEvent event) {
    page.showPatietHistoryPage();
    }

    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }

}

