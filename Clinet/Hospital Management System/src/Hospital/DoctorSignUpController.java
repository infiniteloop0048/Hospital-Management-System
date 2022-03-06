package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.NetworkUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Hospital.Doctor.conDoctor;

public class DoctorSignUpController implements Initializable{
    private  Page page;
    public TextField doctor_id;
    public TextField doctor_email;
    public TextField doctor_contact;
    public TextField doctor_designation;
    public TextField doctor_name;
    public TextField doctor_graduation;
    public ComboBox<String> doctor_gendre;
    public ComboBox<String> doctor_department;
    public TextArea doctor_address;
    public PasswordField password_id;
    public Button toback_id;
    public Button backto_home;
    public Button service_id;
    public Button contact_id;
    ObservableList<String> list4 = FXCollections.observableArrayList("Psychiatrist","Immunologist","Skin DiseaseAnesthesiologist","Cardiologist","Dermatologist","Endocrinologist","Pathologist","Gynecologist","Hematologist","Nephrologist","Neurologist");
    ObservableList<String> list = FXCollections.observableArrayList("MALE","FEMALE","OTHERS");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doctor_department.setItems(list4);
        doctor_gendre.setItems(list);
    }

    public void back_action(ActionEvent event) {
        page.showMainPage();
    }

    public void backto_home_action(ActionEvent event) {
        page.showMainPage();
    }

    public void service_action(ActionEvent event) {
    }

    public void doctor_action(ActionEvent event) {
    }

    public void contact_action(ActionEvent event) {
    }

    public void submit_action(ActionEvent event) throws IOException {
        if ((doctor_id.getText()==null)||(doctor_name.getText()==null)||(doctor_email.getText()==null)||(password_id.getText()==null)||(doctor_contact.getText()==null)||(doctor_gendre.getValue()==null)||(doctor_department.getValue()==null)||(doctor_graduation.getText()==null)||(doctor_address.getText()==null)||(doctor_designation.getText()==null))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert Messege");
            alert.setHeaderText("Unfilled Some Field");
            alert.setContentText("You Have to fill all the filled");
            alert.showAndWait();
        }
        else {
            NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
            Doctor ob =new Doctor(doctor_id.getText(),doctor_name.getText(),doctor_email.getText(),password_id.getText(),doctor_contact.getText(),doctor_gendre.getValue(),doctor_department.getValue(),doctor_graduation.getText(),doctor_address.getText(),doctor_designation.getText());
            Object o = null;
            try{
                nc.write(ob);
                o=nc.read();
            }  catch (Exception e)
            {
                System.out.println("exception in patientsignup controller class");
            }
            if(o!=null)
            {
                if(o instanceof Doctor)
                {
                    conDoctor=(Doctor) o;
                    page.showDoctorHomePage();

                }

            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid USERID");
                alert.setHeaderText("Invalid PATIENTID");
                alert.setContentText("This userid is mathch with other please try unic one");
                alert.showAndWait();
            }
        }
        }



    //this method show the page
    void  setPage(Page page)
    {
        this.page=page;
    }
}
