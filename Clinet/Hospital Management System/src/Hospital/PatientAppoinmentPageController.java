package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PatientAppoinmentPageController {

    private Page page;

    @FXML
    private Button back;

    @FXML
    private Button book;

    @FXML
    private Button view;

    @FXML
    void backAction(ActionEvent event) {

        System.out.println("hey! man you press back button");
        page.showPatientHomePage();
    }

    @FXML
    void bookAction(ActionEvent event) {

        System.out.println("hey! man you press book button");
        page.showBookAppoinment();
    }

    @FXML
    void viewAction(ActionEvent event) {
        System.out.println("hey! man you press view button");
        page.showLastAppoinmentPage();

    }

    void setPage(Page page)
    {
        this.page=page;
    }

}
