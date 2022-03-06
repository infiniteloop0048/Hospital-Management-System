package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.NetworkUtil;

import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Patient.conPatientObj;

public class DoctorReportPageController implements Initializable {

    private Page page;
    @FXML
    private TextField age;

    @FXML
    private TextField name;

    @FXML
    private TextField disease;

    @FXML
    private Button back;

    @FXML
    private TextArea medicin;

    @FXML
    private TextArea test;

    @FXML
    private TextField id;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setText(conPatientObj.getPatientId());
        name.setText(conPatientObj.getPatientName());
        age.setText(conPatientObj.getPatientAge());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        DoctorReportId send=new DoctorReportId(conPatientObj.getPatientId());
        Presscribtion recieve=null;
        Object o=null;
        try{
            nc.write(send);
            o=nc.read();
        }catch (Exception e)
        {
            System.out.println("Report controller page exception");
        }
        if(o instanceof Presscribtion) {
            recieve = (Presscribtion) o;
            System.out.println(recieve);
            disease.setText(recieve.getDisease());
            medicin.setText(recieve.getMedicin());
            test.setText(recieve.getTest());


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
