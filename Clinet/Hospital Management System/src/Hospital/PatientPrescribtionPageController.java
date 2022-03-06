package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.NetworkUtil;

import java.net.URL;
import java.util.ResourceBundle;

import static Hospital.Patient.conPatientObj;

public class PatientPrescribtionPageController implements Initializable {

    private Page page;

    private PrescribPageInit set;

    @FXML
    private ComboBox<String> id;

    @FXML
    private TextField age;

    @FXML
    private TextField name;

    @FXML
    private TextField disease;

    @FXML
    private Button submit;

    @FXML
    private Button back;

    @FXML
    private TextArea medicin;

    @FXML
    private TextArea test;
    ObservableList<String> list1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        set=new PrescribPageInit();
        Object ob=null;
        try{
            nc.write(set);
            ob=nc.read();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if(ob!=null)
        {
            if(ob instanceof PrescribPageInit)
                set=(PrescribPageInit) ob;
        }
        //set the patient id list
        list1= FXCollections.observableArrayList(set.id);
        id.setItems(list1);
    }

    @FXML
    void backOnAction(ActionEvent event) {

        page.showDoctorHomePage();
    }

    @FXML
    void submitOnAction(ActionEvent event) {
       Presscribtion send=new Presscribtion(id.getValue(),disease.getText(),test.getText(),medicin.getText());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        nc.write(send);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("READY");
        alert.setHeaderText("REPORT READY");
        alert.setContentText("rportready!!!!!!!!!!!!!!!!!!!");
        alert.showAndWait();
    }

    @FXML
    void idOnAction(ActionEvent event) {

        name.setText(set.idName.get(id.getValue()));//idName is hashmap,id is the key
    }


    //this methos can save the page
    void setPage(Page page)
    {
        this.page=page;
    }

}
