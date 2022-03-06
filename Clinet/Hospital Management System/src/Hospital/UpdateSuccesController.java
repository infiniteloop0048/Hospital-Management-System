package Hospital;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.ClientMain.msg;

public class UpdateSuccesController implements Initializable {

    @FXML
    private Label userMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userMsg.setText(msg);
    }

}
