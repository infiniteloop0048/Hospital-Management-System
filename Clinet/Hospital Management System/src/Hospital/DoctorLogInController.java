package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.NetworkUtil;
import static Hospital.Doctor.conDoctor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorLogInController implements Initializable{

    //public AnchorPane AfterDoc_signIn;
    private Page page;
    public AnchorPane login_dctr_anchor;
    public Button SUBMIT;
    public Button back;
    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void BackOnAction(ActionEvent actionEvent) {
        page.showMainPage();
    }

    public void SUBMIT__action(ActionEvent event) throws IOException{

        LDoctor lDoctor=new LDoctor(userName.getText(),password.getText());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Object o=null;
        try{
            nc.write(lDoctor);
            o=nc.read();
        }catch (Exception e)
        {
            System.out.println("exception handle");
        }

        if(o!=null)
        {
            if(o instanceof Doctor)
            {
                conDoctor=(Doctor) o;
                page.showDoctorHomePage();
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


    void setPage(Page page)
    {
        this.page=page;
    }


}
