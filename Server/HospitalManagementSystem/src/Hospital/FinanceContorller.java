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

import static Hospital.Payment.paymentList;

public class FinanceContorller implements Initializable{

    private Page page;
    private List<FinanceTable> financeTables=new ArrayList<>();
    ObservableList<FinanceTable> data;
    @FXML
    private TableView<FinanceTable> tableView;

    @FXML
    private TableColumn<FinanceTable,String> id;

    @FXML
    private TableColumn<FinanceTable,String> name;

    @FXML
    private TableColumn<FinanceTable,String> money;

    @FXML
    private Button back;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        money.setCellValueFactory(new PropertyValueFactory<>("money"));

        loadlist();
        data= FXCollections.observableArrayList(financeTables);

        tableView.setItems(data);
    }

    @FXML
    void backOnAction(ActionEvent event) {

        page.showAdminHomePage();
    }
    void loadlist()
    {
        Payment ob;
        for(int i=0;i<paymentList.size();i++)
        {
            ob=paymentList.get(i);
            FinanceTable f=new FinanceTable(ob.getPid(),ob.getpName(),ob.getMoney());
            financeTables.add(f);
        }
    }

    //set page
    void setPage(Page page)
    {
        this.page=page;
    }
}
