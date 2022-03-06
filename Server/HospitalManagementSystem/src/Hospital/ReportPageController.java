package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Hospital.Patient.patientlist;

public class ReportPageController implements Initializable {


    private Page page;
    @FXML
    private ComboBox<String> id;

    @FXML
    private TextField bed;

    @FXML
    private TextField disease;

    @FXML
    private DatePicker aDate;

    @FXML
    private DatePicker rDate;

    @FXML
    private TextField pay;

    @FXML
    private Button back;

    @FXML
    private Button submit;
    ObservableList<String> list1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void backOnAction(ActionEvent event) {

        page.showServicePage();
    }

    @FXML
    void submitOnAction(ActionEvent event) {
       // new PatientPreviousPage(id.getValue(),bed.getText(),disease.getText(),aDate.getValue().toString(),rDate.getValue().toString(),pay.getText(),10);
        //this constructor can  automatically load previous history
    }

    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }

}

