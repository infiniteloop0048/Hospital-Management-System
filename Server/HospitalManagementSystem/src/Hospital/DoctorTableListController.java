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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Hospital.Doctor.doctorList;

public class DoctorTableListController implements Initializable {

    private List<DoctorTableRef> doctorTableRefList = new ArrayList<>();
    private Page page;
    @FXML
    private TableView<DoctorTableRef> tableview;
    ObservableList<DoctorTableRef> data;

    @FXML
    private TableColumn<DoctorTableRef, String> ID;

    @FXML
    private TableColumn<DoctorTableRef, String> Name;

    @FXML
    private TableColumn<DoctorTableRef, String> Dept;

    @FXML
    private TableColumn<DoctorTableRef, String> Email;

    @FXML
    private TableColumn<DoctorTableRef, String> Phone;

    @FXML
    private TableColumn<DoctorTableRef, String> Address;

    @FXML
    private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        //PatientName=new TableColumn<>("Name");
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        //PatientDisease=new TableColumn<>("Disease");
        Dept.setCellValueFactory(new PropertyValueFactory<>("Dept"));
        //PatientNum=new TableColumn<>("Phone Number");
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));

        //PatientEmail=new TableColumn<>("Email");
        Phone.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        //PatientAddress=new TableColumn<>("Address");
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        loadlist();
        data = FXCollections.observableArrayList(doctorTableRefList);
        tableview.setEditable(true);
        tableview.setItems(data);
    }

    void loadlist() {
        Doctor dob;

        for (int i = 0; i < doctorList.size(); i++) {
            dob = doctorList.get(i);
            System.out.println(dob);
            DoctorTableRef doctorTableRef = new DoctorTableRef(dob.getDoctorId(), dob.getDoctorName(), dob.getDoctorDepartment(), dob.getDoctorContactNo(), dob.getDoctorEmail(), dob.getDocotorAdress());
            doctorTableRefList.add(doctorTableRef);
        }
    }


    @FXML
    void backOnAction(ActionEvent event) {

        page.showAdminHomePage();
    }

    void setPage(Page page)
    {
        this.page=page;
    }
}
