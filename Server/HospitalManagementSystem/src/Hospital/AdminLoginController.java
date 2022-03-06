package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable{
    private Page page;
    public Button login;
    public AnchorPane anchorpane;
    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void login_action(ActionEvent event) {

        if(userName.getText().equals("BUETCSE16") && passWord.getText().equals("108"))
        {
        page.showAdminHomePage();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Username or Password");
            alert.setHeaderText("Incorrect Username or password");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }


    void setPage(Page page)
    {
        this.page=page;
    }
}
