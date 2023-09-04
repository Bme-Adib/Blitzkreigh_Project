package com.herculife.herculifeLunaEMG;

import com.herculife.herculifeLunaEMG.Controllers.SplashController;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.AppName;

public class HerculifeLunaEMGApplication extends Application {

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