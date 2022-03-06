package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ServicePageController {

    private Page page;
    @FXML
    private Button bed;

    @FXML
    private Button add;

    @FXML
    private Button pay;
    @FXML
    private Button back;

    @FXML
    void addOnAction(ActionEvent event) {

        page.showAddReport();
    }

    @FXML
    void bedOnAction(ActionEvent event) {

        page.showBedBookedPage();
    }

    @FXML
    void payOnAction(ActionEvent event) {

    }
    @FXML
    void backOnAction(ActionEvent event) {
        page.showAdminHomePage();

    }


    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }

}

