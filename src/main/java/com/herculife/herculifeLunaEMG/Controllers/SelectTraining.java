package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.Controllers.TrainingControllers.AdvancedTrainingSetUp;
import com.herculife.herculifeLunaEMG.Controllers.TrainingControllers.BasicTrainingSetUp;
import com.herculife.herculifeLunaEMG.Controllers.TrainingControllers.BladderTrainingSetUp;
import com.herculife.herculifeLunaEMG.Controllers.TrainingControllers.StabilityTrainingSetUp;
import com.herculife.herculifeLunaEMG.ProjectClasses.TrainingClass;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.*;

public class SelectTraining implements Initializable {
    public static final String RESOURCE_NAME = FxmlPre + "SelectTraining.fxml";


    public static int TrainingType = 0;

    public static TrainingClass currentTrainingObject;
    @FXML
    private Label TradeMarkText;
    @FXML
    private ImageView bgImage;
    @FXML
    private Button exitButton;
    @FXML
    private MenuItem fileMenu_Close;
    @FXML
    private AnchorPane root;
    @FXML
    private MenuBar topMenuBar;

    public SelectTraining() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);

    }

    @FXML
    void goBackButton(MouseEvent event) {
        new MyGoTo().changeSceneTo(MainPatientDashboard.RESOURCE_NAME);
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(SelectTraining.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(SelectTraining.class);
    }

    @FXML
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(SelectTraining.class);
    }


    @FXML
    void stabilityTrainingFunction(MouseEvent event) {
        TrainingType = STABILITY_TRAINING_ID;
        new MyGoTo().changeSceneTo(StabilityTrainingSetUp.RESOURCE_NAME);
    }

    @FXML
    void advancedTrainingFunction(MouseEvent event) {
        TrainingType = ADVANCE_TRAINING_ID;
        new MyGoTo().changeSceneTo(AdvancedTrainingSetUp.RESOURCE_NAME);
    }

    @FXML
    void basicTrainingFunction(MouseEvent event) {
        TrainingType = BASIC_TRAINING_ID;
        new MyGoTo().changeSceneTo(BasicTrainingSetUp.RESOURCE_NAME);
    }

    @FXML
    void bladderTrainingFunction(MouseEvent event) {
        TrainingType = BLADDER_TRAINING_ID;
        new MyGoTo().changeSceneTo(BladderTrainingSetUp.RESOURCE_NAME);
    }


    @FXML
    void aboutPelvicTutorPopUp(ActionEvent event) {

    }

    @FXML
    void helpDesk(ActionEvent event) {

    }

    @FXML
    void tutorialCreateNewPatient(ActionEvent event) {

    }

    @FXML
    void tutorialSetUpParameters(ActionEvent event) {

    }


}
