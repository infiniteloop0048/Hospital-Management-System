package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.util.*;

import static Hospital.Patient.patientlist;

public class PatientTableListController implements Initializable {


    private List<PatientTableRef> patientTableRefList=new ArrayList<>();
    private Page page;
        @FXML
        private  TableView<PatientTableRef> tableView;
        ObservableList<PatientTableRef> data;

        @FXML
        private TableColumn<PatientTableRef,String> PatientId;

        @FXML
        private TableColumn<PatientTableRef,String> PatientName;

        @FXML
        private TableColumn<PatientTableRef,String> PatientDisease;

        @FXML
        private TableColumn<PatientTableRef,String> PatientNum;

        @FXML
        private TableColumn<PatientTableRef,String> PatientEmail;

        @FXML
        private TableColumn<PatientTableRef,String> PatientAddress;
        @FXML
        private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //PatientId=new TableColumn<>("UserID");
        PatientId.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        //PatientName=new TableColumn<>("Name");
        PatientName.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        //PatientDisease=new TableColumn<>("Disease");
        PatientDisease.setCellValueFactory(new PropertyValueFactory<>("SlectDisease"));
        //PatientNum=new TableColumn<>("Phone Number");
        PatientNum.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));

        //PatientEmail=new TableColumn<>("Email");
        PatientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        //PatientAddress=new TableColumn<>("Address");
        PatientAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        //tableView.getColumns().addAll(PatientId,PatientName,PatientDisease,PatientNum,PatientEmail,PatientAddress);
        loadlist();//this method can load a list
        data= FXCollections.observableArrayList(patientTableRefList);
        tableView.setEditable(true);
        tableView.setItems(data);
    }
    //this method set the data
    void loadlist()
    {
        Patient pob;

        for(int i=0;i<patientlist.size();i++)
        {
            pob=patientlist.get(i);
            System.out.println(pob);
            PatientTableRef patientTableRef=new PatientTableRef(pob.getPatientId(),pob.getPatientName(),pob.getSlectDisease(),pob.getContactNo(),pob.getEmail(),pob.getAddress());
            patientTableRefList.add(patientTableRef);

        }
    }

    //this method is on back action
    public void backOnActiion(ActionEvent actionEvent) {
             page.showAdminHomePage();
    }


    //this method can set the page
    void setPage(Page page)
    {
        this.page=page;
    }


}


