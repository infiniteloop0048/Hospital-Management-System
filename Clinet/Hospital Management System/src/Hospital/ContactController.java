package Hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ContactController {
    private Page page;
    public Button BACK_from_contact2main;
    public AnchorPane contact_id;

    public void BACK_from_contact2main_action(ActionEvent event) throws IOException{
        page.showMainPage();
    }
    void setPage(Page page){ this.page=page;}
}
