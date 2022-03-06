package Hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Hospital.Main.bedTracer;
import static Hospital.Main.bookBedList;

public class BookedBedTableController implements Initializable {


    private Page page;

    private List<BedBookedTable> list=new ArrayList<>();

        @FXML
        private TableView<BedBookedTable> tableView;
        ObservableList<BedBookedTable> data;
        @FXML
        private TableColumn<BedBookedTable,String> name;

        @FXML
        private TableColumn<BedBookedTable,String> id;

        @FXML
        private TableColumn<BedBookedTable,String> bed;

        @FXML
        private Button back;

        @FXML
        private Label bed1;

        @FXML
        private Label bed2;

        @FXML
        private Label bed3;

        @FXML
        private Label bed4;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setCellValueFactory(new PropertyValueFactory<>("pId"));
        id.setCellValueFactory(new PropertyValueFactory<>("pName"));
        bed.setCellValueFactory(new PropertyValueFactory<>("bedNo"));
        loadList();
        data= FXCollections.observableArrayList(list);
        tableView.setEditable(true);
        tableView.setItems(data);
        if(!bedTracer.alocateBed[0]) bed1.setText("Booked");
        if(!bedTracer.alocateBed[1]) bed2.setText("Booked");
        if(!bedTracer.alocateBed[2]) bed3.setText("Booked");
        if(!bedTracer.alocateBed[3]) bed4.setText("Booked");

    }

        @FXML
        void backOnAction(ActionEvent event) {
        page.showServicePage();

    }

        //set the Page
    void setPage(Page page)
    {
        this.page=page;
    }

    //this method can load a list
    void loadList()
    {
        BookedBed bob;
        for(int i=0;i<bookBedList.bedList.size();i++)
        {
            bob=bookBedList.bedList.get(i);//this return the object
            BedBookedTable bedBookedTable=new BedBookedTable(bob.getpId(),bob.getpName(),bob.getBedNo());
            list.add(bedBookedTable);
        }
    }

}
