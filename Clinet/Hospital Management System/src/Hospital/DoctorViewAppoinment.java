package Hospital;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class DoctorViewAppoinment {

   // private Page page;
    private Page page;
    private final SimpleStringProperty pName;
    private final SimpleStringProperty pId;
    private final SimpleStringProperty pDisease;
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final Button editButton;
    public static DoctorViewAppoinment conDoctorViewApp;

    public DoctorViewAppoinment(String pName,String pId,String pDisease,String date, String time,Page page) {
       // this.page=page;
        this.pName = new SimpleStringProperty(pName);
        this.pId =new SimpleStringProperty(pId);
        this.pDisease =new SimpleStringProperty(pDisease);
        this.date =new SimpleStringProperty(date);
        this.time =new SimpleStringProperty(time);
        this.page=page;
        this.editButton=new Button("View");
       // editButton.setText("Edit");
        editButton.setOnAction(e->
        {
            conDoctorViewApp=this;
            Stage primaryStage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("View.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 500, 400));
            primaryStage.show();

        });
    }
    //---------------------------getter and setter-------------------------------


    public String getpName() {
        return pName.get();
    }

    public SimpleStringProperty pNameProperty() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public String getpId() {
        return pId.get();
    }

    public SimpleStringProperty pIdProperty() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId.set(pId);
    }

    public String getpDisease() {
        return pDisease.get();
    }

    public SimpleStringProperty pDiseaseProperty() {
        return pDisease;
    }

    public void setpDisease(String pDisease) {
        this.pDisease.set(pDisease);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public Button getEditButton() {
        return editButton;
    }

    @Override
    public String toString() {
        return "DoctorViewAppoinment{" +
                "pName=" + pName +
                ", pId=" + pId +
                ", pDisease=" + pDisease +
                ", date=" + date +
                ", time=" + time +
                ", editButton=" + editButton +
                '}';
    }
}
