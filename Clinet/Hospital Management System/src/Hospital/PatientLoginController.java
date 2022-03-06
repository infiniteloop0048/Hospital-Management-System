package Hospital;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static Hospital.Patient.conPatientObj;
import util.NetworkUtil;

public class PatientLoginController {
    private Page page;
    public TextField userName;
    public PasswordField password;
    public Button backButton;
    public Button loginButton;

    public void backOnAction(ActionEvent actionEvent) {
        page.showMainPage();
    }

    public void loginAction(ActionEvent actionEvent) {

        LPatient lPatient=new LPatient(userName.getText(),password.getText());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Object o=null;
        try{
        nc.write(lPatient);
         o=nc.read();
        }catch (Exception e)
        {
            System.out.println("exception handle");
        }

        if(o!=null)
        {
            if(o instanceof Patient)
            {
                conPatientObj=(Patient) o;
                page.showPatientHomePage();
            }

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Username or Password");
            alert.setHeaderText("Incorrect Username or password");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();

        }

        userName.setText(null);
        password.setText(null);






    }
    void setPage(Page page){this.page=page;}
}
