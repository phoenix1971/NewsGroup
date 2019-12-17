/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author saad
 */
public class START extends Application {

    public static Scene LogInScene, HomeScene,FacultyScene , OOPcourseScene,OOPnewsFeed, DScourseScene,DSnewsFeed, DLDnewsFeed, DLDcourseScene, DMcourseScene,DMnewsFeed, NotificationScene, ProfileScene;
    public static String USERNAME = null , USERID ;
    public static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        Parent LogIn = FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent Home = FXMLLoader.load(getClass().getResource("HOME.fxml"));
        Parent MyProfile = FXMLLoader.load(getClass().getResource("MyProfile.fxml"));
        Parent Notification = FXMLLoader.load(getClass().getResource("Notification.fxml"));
        Parent OOPcourse = FXMLLoader.load(getClass().getResource("OOPcourse.fxml"));
        Parent DLDcourse = FXMLLoader.load(getClass().getResource("DLDcourseScene.fxml"));
        Parent DScourse = FXMLLoader.load(getClass().getResource("DScourseScene.fxml"));
        Parent DMcourse = FXMLLoader.load(getClass().getResource("DMcourseScene.fxml"));
        Parent OOPnewsfeeD = FXMLLoader.load(getClass().getResource("OOPnewsfeed.fxml"));
        Parent DLDnewsfeeD = FXMLLoader.load(getClass().getResource("DLDnewsfeed.fxml"));
        Parent DSnewsfeeD = FXMLLoader.load(getClass().getResource("DSnewsfeed.fxml"));
        Parent DMnewsfeeD = FXMLLoader.load(getClass().getResource("DMnewsfeed.fxml"));
        Parent FacultY = FXMLLoader.load(getClass().getResource("Faculty.fxml"));

        LogInScene = new Scene(LogIn);
        HomeScene = new Scene(Home);
        ProfileScene = new Scene(MyProfile);
        NotificationScene = new Scene(Notification);
        OOPcourseScene = new Scene(OOPcourse);
        DScourseScene = new Scene(DScourse);
        DMcourseScene = new Scene(DMcourse);
        DLDcourseScene = new Scene(DLDcourse);
        OOPnewsFeed = new Scene( OOPnewsfeeD ) ;
        DLDnewsFeed = new Scene( DLDnewsfeeD ) ;
        DSnewsFeed = new Scene( DSnewsfeeD ) ;
        DMnewsFeed = new Scene( DMnewsfeeD ) ;
        FacultyScene = new Scene( FacultY ) ;
        window.setScene(LogInScene);

        window.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("yo yo Client ");
        launch(args);
    }

}
