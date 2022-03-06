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
        loader.setLocation(getClass().getResource("HomePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        Controller controller = loader.getController();
        controller.setPage(this);

        // Set the primary stage
        primaryStage.setTitle("WelCome");
        primaryStage.setScene(new Scene(root, 1030, 700));
        primaryStage.show();
    }
    //This method for show patient sign up page

    void showPatientSignUpPage()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientSignUp.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatirntSignUp_ControllerClass patientSignUp=loader.getController();
        patientSignUp.setPage(this);
        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1220, 760));
        primaryStage.show();
    }
    //this method show patient log in page
    void showPatientLogin ()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientLoginPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatientLoginController patientLoginController =loader.getController();
        patientLoginController.setPage(this);


        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1030, 760));
        primaryStage.show();
    }
    //this method show patienthome page...more specificly if patient login or sign up they can directly come this page
    //this file design in PatientHome.fxml file
    void showPatientHomePage()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientHome.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatientHomeController patientProfileController=loader.getController();
        patientProfileController.setPage(this);

        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1030, 760));
        primaryStage.show();

     }

   //this method show patientprofile page which is designed in patientprofile.fxml
    void showPatientProfilePage()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientProfilePage.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatientProfilePageController patientProfilePageController=loader.getController();
        patientProfilePageController.setPage(this);

        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1030, 760));
        primaryStage.show();

    }
    //patient update page
     void showPatientUpdatePage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("PatientUpdateProfile.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         PatientUpdateProfileController patientUpdateProfileController=loader.getController();
         patientUpdateProfileController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }
    //patient appoinmetn page
    void showPatientAppoinmentPage()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PatientAppoinmentPage.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatientAppoinmentPageController patientAppoinmentPageController=loader.getController();
        patientAppoinmentPageController.setPage(this);

        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1030, 760));
        primaryStage.show();

    }
    void showBookAppoinment()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("BookAppoinment.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookAppoinmentController bookAppoinmentController=loader.getController();
        bookAppoinmentController.setPage(this);

        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1030, 760));
        primaryStage.show();

    }
    //patient last appoinmentpage
     void showLastAppoinmentPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("PatientViewLastAppoinmentPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         PatientViewLastAppoinmentPageController patientViewLastAppoinmentPageController=loader.getController();
         patientViewLastAppoinmentPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }

     //show bedpage
     void showBedPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("BedPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         BedPageController bedPageController=loader.getController();
         bedPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }
     //show paybill page
     void showPaybill()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("PayBillPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         PayBillPageController payBillPageController=loader.getController();
         payBillPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }


     //patient history pge
     void showPatietHistoryPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("Historypage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         HistoryPageController historyPageController=loader.getController();
         historyPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }
     //show docotor report
     void showDoctorReportPage()
     {

         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorReportPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorReportPageController doctorReportPageController=loader.getController();
         doctorReportPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();














     }

     //show previous history
     void showprevoiusHistory()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("ReportPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         ReportPageController reportPageController=loader.getController();
         reportPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();
     }

    //doctor signup page
     void showDoctorSignUpPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorSignUp.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorSignUpController doctorSignUpController=loader.getController();
         doctorSignUpController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();
     }
     //this page show doctor login page
     void showDoctorLogInPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorLogInPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorLogInController doctorLogInController=loader.getController();
         doctorLogInController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }

     //doctor homepage
     void showDoctorHomePage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorHomePage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorHomePageController doctorHomePageController=loader.getController();
         doctorHomePageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();
     }

     //this method can show doctor profile page
     void showDoctorProfilePage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorProfilePage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorProfilePageController doctorProfilePageController=loader.getController();
         doctorProfilePageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }

     //this method updata docotor profile
     void showDoctorUpdateProfilePage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorUpdateProfilePage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorUpdateProfilePageController doctorUpdateProfilePageController=loader.getController();
         doctorUpdateProfilePageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();
     }


     void showDoctorViewAppoinmentPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("DoctorViewAppoinmentPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         DoctorViewAppoinmentPageController doctorViewAppoinmentPageController=loader.getController();
         doctorViewAppoinmentPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }
     void showDoctorAddReportPage()
     {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(getClass().getResource("PatientPrescribtionPage.fxml"));

         Parent root = null;
         try {
             root = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         PatientPrescribtionPageController patientPrescribtionPageController=loader.getController();
         patientPrescribtionPageController.setPage(this);

         primaryStage.setTitle("Welcome to Our Hospital");
         primaryStage.setScene(new Scene(root, 1030, 760));
         primaryStage.show();

     }











    //contact us window
    void showContactPage()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Contact.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContactController contactWindow_controller=loader.getController();
        contactWindow_controller.setPage(this);

        primaryStage.setTitle("Welcome to Our Hospital");
        primaryStage.setScene(new Scene(root, 1220, 760));
        primaryStage.show();
    }












}
