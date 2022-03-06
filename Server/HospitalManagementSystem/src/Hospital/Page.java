package Hospital;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class Page {

    Stage primaryStage;


    void setMainPage(Stage myStage)
    {
        primaryStage=myStage;
    }

    public void showMainPage()  {
        // FXML Loading using FXMLLoader

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Admin.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        AdminController adminController = loader.getController();
        adminController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    void showAdminLoginPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminLogin.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        AdminLoginController adminLoginController = loader.getController();
        adminLoginController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }

    public void showAdminHomePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminHomePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        AdminHomePageController adminHomePageController = loader.getController();
        adminHomePageController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }
    public void showPatientTablePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientTableList.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        PatientTableListController patientTableListController = loader.getController();
        patientTableListController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

    void showDoctorTablePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DoctorTableList.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        DoctorTableListController doctorTableListController = loader.getController();
        doctorTableListController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

    void showAdminAppoinmentTablePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminAppoinmentTabelPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        AdminAppoinmentTablePageController adminAppoinmentTablePageController = loader.getController();
        adminAppoinmentTablePageController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

    //finance
    void showfinance()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Finance.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        FinanceContorller financeContorller = loader.getController();
        financeContorller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();



    }

    //this method show submit page
    void showServicePage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ServicePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
       ServicePageController servicePageController = loader.getController();
        servicePageController.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }
        //show bed alocation Page
    void showBedBookedPage()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BookedBedTable.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Loading the controller
        BookedBedTableController bookedBedTableController = loader.getController();
        bookedBedTableController.setPage(this);
        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }
    //creat report for the patient
    void showAddReport()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ReportPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Loading the controller
        ReportPageController reportPageController = loader.getController();
        reportPageController.setPage(this);
        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();

    }

}
