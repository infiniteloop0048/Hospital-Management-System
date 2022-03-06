package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.NetworkUtil;

import static Hospital.Patient.conPatientObj;

public class PayBillPageController {
    private Page page;

    @FXML
    private TextField doctor;

    @FXML
    private TextField bed;

    @FXML
    private TextField test;

    @FXML
    private TextField medicin;

    @FXML
    private Button totalb;

    @FXML
    private Button submit;

    @FXML
    private Button back;
    @FXML
    private TextField money;


    @FXML
    void backOnAction(ActionEvent event) {

        page.showPatientHomePage();
    }

    @FXML
    void submitOnAction(ActionEvent event) {

        Payment p=new Payment(conPatientObj.getPatientId(),conPatientObj.getPatientName(),money.getText());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        try{
            nc.write(p);
        }catch (Exception w)
        {
            ;
        }
    }

    @FXML
    void totalonAction(ActionEvent event) {
        int a=Integer.parseInt(doctor.getText(),10)+Integer.parseInt(bed.getText(),10)+Integer.parseInt(test.getText(),10)+Integer.parseInt(medicin.getText(),10);
        money.setText(String.valueOf(a));


    }

    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }

}
