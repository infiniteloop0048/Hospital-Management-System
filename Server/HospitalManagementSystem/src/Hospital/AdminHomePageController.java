package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sun.security.krb5.internal.PAData;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomePageController implements Initializable{
    private Page page;
    public AnchorPane admin_anchor;
    public Button home_admin;
    public Button parents_id;
    public Button doctor_id;
    public Button appointment_id;
    @FXML
    private Button seivies;
    @FXML
    private Button finance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void feedback_action(ActionEvent event) {
    }

    public void appointment_action(ActionEvent event) {
        page.showAdminAppoinmentTablePage();
    }

    public void doctor_action(ActionEvent event) {
        page.showDoctorTablePage();
    }

    public void parents_action(ActionEvent event) {

        page.showPatientTablePage();
    }

    public void home_admin_action(ActionEvent event) {
        page.showMainPage();
    }

    @FXML
    void serveOnAction(ActionEvent event) {

        page.showServicePage();
    }
    @FXML
    void financeOnAction(ActionEvent event) {

        page.showfinance();
    }



    //page setup
    void setPage(Page page)
    {
        this.page=page;
    }
}
