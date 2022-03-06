package Hospital;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class AdminController {
    private Page page;
    public Button home;
    public Button service;
    public Button doctor;
    public Button contact;
    public Button about;
    public Button admin;

    public void home_action(ActionEvent actionEvent) {
    }

    public void service_action(ActionEvent actionEvent) {
    }

    public void doctor_action(ActionEvent actionEvent) {
    }

    public void contact_action(ActionEvent actionEvent) {
    }

    public void about_action(ActionEvent actionEvent) {
    }

    public void adminOnAction(ActionEvent actionEvent) {
        page.showAdminLoginPage();
    }



    //this method set the page of main page
    void setPage(Page page)
    {
        this.page=page;
    }
}
