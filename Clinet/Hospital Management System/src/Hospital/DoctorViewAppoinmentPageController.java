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
import util.NetworkUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static Hospital.Doctor.conDoctor;

public class DoctorViewAppoinmentPageController implements Initializable {

    private  Page page;
    @FXML
    private TableView<DoctorViewAppoinment> tableView;
    ObservableList<DoctorViewAppoinment> data;
    private List<DoctorViewAppoinment> appoinmentList=new ArrayList<>();

    @FXML
    private TableColumn<DoctorViewAppoinment,String> name;

    @FXML
    private TableColumn<DoctorViewAppoinment,String> Id;

    @FXML
    private TableColumn<DoctorViewAppoinment,String> disease;

    @FXML
    private TableColumn<DoctorViewAppoinment,String> date;

    @FXML
    private TableColumn<DoctorViewAppoinment,String> time;

    @FXML
    private TableColumn<DoctorViewAppoinment,String> edit;
    @FXML
    private Button back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setCellValueFactory(new PropertyValueFactory<>("pName"));
        Id.setCellValueFactory(new PropertyValueFactory<>("pId"));
        disease.setCellValueFactory(new PropertyValueFactory<>("pDisease"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        edit.setCellValueFactory(new PropertyValueFactory<>("editButton"));
        loadList();
        data=FXCollections.observableArrayList(appoinmentList);
        tableView.setEditable(true);
        tableView.setItems(data);

    }
    @FXML
    void backOnAction(ActionEvent event) {
        page.showDoctorHomePage();

    }
    //this method can setthe value of list
    void loadList(){
        SendAppoinmetList recieve=new SendAppoinmetList(conDoctor.getDoctorId());
        NetworkUtil nc=new NetworkUtil("127.0.0.1",20000);
        Object ob=null;
        try{
            nc.write(recieve);
            ob=nc.read();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        if(ob instanceof SendAppoinmetList)
        {
            List<PatientAppoinment> list;
            PatientAppoinment p;
            recieve=(SendAppoinmetList) ob;
            list=recieve.getAppoinmentLsit();
           for(int i=0;i<list.size();i++)
           {
               p=list.get(i);
               DoctorViewAppoinment d=new DoctorViewAppoinment(p.getPName(),p.getPId(),p.getPDisease(),p.getDate(),p.getTime(),this.page);
               System.out.println(d);
               appoinmentList.add(d);
           }
        }
    }

    //this method can set the page
    void setPage(Page page)
    {
        this.page=page;
    }
}

