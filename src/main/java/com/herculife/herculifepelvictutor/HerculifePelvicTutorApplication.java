package com.herculife.herculifepelvictutor;

import com.herculife.herculifepelvictutor.Controllers.SplashController;
import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.AppName;

public class HerculifePelvicTutorApplication extends Application {

    public static Stage MainStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource(SplashController.RESOURCE_NAME)).load();
        Scene scene = new Scene(root);
        MainStage = stage;
        new MyGoTo().setStageSettings(stage);
        stage.setTitle(AppName);
        stage.setScene(scene);
        stage.show();
    }
}