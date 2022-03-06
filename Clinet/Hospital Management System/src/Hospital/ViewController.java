package Hospital;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import static Hospital.DoctorViewAppoinment.conDoctorViewApp;

public class ViewController implements Initializable {


    @FXML
    private Label name;

    @FXML
    private Label disease;

    @FXML
    private Label date;
    @FXML
    private Label time;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(conDoctorViewApp.getpName());
        disease.setText(conDoctorViewApp.getpDisease());
        date.setText(conDoctorViewApp.getDate());
        time.setText(conDoctorViewApp.getTime());
    }
}
