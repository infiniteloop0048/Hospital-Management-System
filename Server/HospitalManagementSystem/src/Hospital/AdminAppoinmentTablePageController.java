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
import static Hospital.PatientAppoinment.patientAppoinmentlist;

public class AdminAppoinmentTablePageController implements Initializable {

    private List<AdminAppoinmentTableRef>  adminAppoinmentTableRefList=new ArrayList<>();
    private Page page;
    @FXML
    private TableView<AdminAppoinmentTableRef> tibleView;
    ObservableList<AdminAppoinmentTableRef> data;
    @FXML
    private TableColumn<AdminAppoinmentTableRef,String> pName;

    @FXML
    private TableColumn<AdminAppoinmentTableRef,String> pDisease;

    @FXML
    private TableColumn<AdminAppoinmentTableRef,String> dName;

    @FXML
    private TableColumn<AdminAppoinmentTableRef,String> date;

    @FXML
    private TableColumn<AdminAppoinmentTableRef,String> time;

    @FXML
    private Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pDisease.setCellValueFactory(new PropertyValueFactory<>("pDisease"));
        dName.setCellValueFactory(new PropertyValueFactory<>("dName"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        loadList();
        data= FXCollections.observableArrayList(adminAppoinmentTableRefList);
        tibleView.setEditable(true);
        tibleView.setItems(data);
    }

    @FXML
    void backOnAction(ActionEvent event) {

        page.showAdminHomePage();
    }
    void loadList()
    {
        PatientAppoinment papp;
        for(int i=0;i<patientAppoinmentlist.size();i++)
        {
            papp=patientAppoinmentlist.get(i);
            AdminAppoinmentTableRef adminAppoinmentTableRef=new AdminAppoinmentTableRef(papp.getPName(),papp.getPDisease(),papp.getDName(),papp.getDate(),papp.getTime());
            adminAppoinmentTableRefList.add(adminAppoinmentTableRef);
        }

    }

    //set the Page
    void setPage(Page page)
    {
        this.page=page;
    }

}
