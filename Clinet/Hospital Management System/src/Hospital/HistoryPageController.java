package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HistoryPageController {

    private Page page;
    @FXML
    private Button dReport;

    @FXML
    private Button pHistory;

    @FXML
    private Button back;

    @FXML
    void backOnAction(ActionEvent event) {

        page.showPatientHomePage();
    }

    @FXML
    void dReportOnAction(ActionEvent event) {

        page.showDoctorReportPage();
    }

    @FXML
    void pHItoryOnAction(ActionEvent event) {

        page.showprevoiusHistory();
    }

    //set the page
    void setPage(Page page)
    {
        this.page=page;
    }

}

