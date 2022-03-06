package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private Page mainPage;
    public Button home;
    public Button service;
    public Button doctor;
    public Button contact;
    public Button about;
    public Button log;
    public ComboBox<String> signup_id;
    public Pane pane;
    public ComboBox<String> ligin_id;
    ObservableList<String> list = FXCollections.observableArrayList("PATIENT SIGN UP","DOCTOR SIGN UP");
    ObservableList<String> list1 = FXCollections.observableArrayList("PATIENT LOG IN","DOCTOR LOG IN");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signup_id.setItems(list);
        ligin_id.setItems(list1);
    }

    public void home_action(ActionEvent event) {
    }

    public void service_action(ActionEvent event) {
    }

    public void doctor_action(ActionEvent event) {
    }
    public void contactOnAction(ActionEvent actionEvent) {

        mainPage.showContactPage();
    }


    public void about_action(ActionEvent event) {
    }

    public void log_action(ActionEvent event) {
    }

    public void signupaction(ActionEvent event) throws IOException{
        String value = signup_id.getValue();
        if(value.equals("PATIENT SIGN UP"))
        {

            mainPage.showPatientSignUpPage();
        }
        else
        {

            mainPage.showDoctorSignUpPage();
        }
    }

    public void login_action(ActionEvent event) throws IOException{
        String value = ligin_id.getValue();
        if(value.equals("PATIENT LOG IN")==true)
        {
          mainPage.showPatientLogin();

        }
        else
        {
            mainPage.showDoctorLogInPage();
        }
    }
    void setPage(Page mainPage)
    {
        this.mainPage=mainPage;
    }


}
