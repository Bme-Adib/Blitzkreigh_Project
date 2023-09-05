package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import com.herculife.herculifeLunaEMG.ProjectSettings.Time_Stamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifeLunaEMG.ProjectClasses.TrainingClass.*;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;

public class MainPatientDashboard implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "MainPatientDashboard.fxml";

    int basicTC = 0;
    int advancedTC = 0;
    int bladderTC = 0;
    int stabilityTC = 0;
    @FXML
    private Label TradeMarkText;
    @FXML
    private PieChart pieTrainingsCount;
    @FXML
    private Label basicTrainingCount;
    @FXML
    private Label advancedTrainingCount;
    @FXML
    private Label bladderTrainingCount;
    @FXML
    private Label stabilityTrainingCount;
    @FXML
    private Label age;
    @FXML
    private ImageView bgImage;
    @FXML
    private Label dob;
    @FXML
    private Label email;
    @FXML
    private Button exitButton;
    @FXML
    private MenuItem fileMenu_Close;
    @FXML
    private Label firstName;
    @FXML
    private Label gender;
    @FXML
    private Label id;
    @FXML
    private Label lastName;
    @FXML
    private VBox logOut;
    @FXML
    private Label mrn;
    @FXML
    private Label nationality;
    @FXML
    private Label phoneNumber;
    @FXML
    private AnchorPane root;
    @FXML
    private Button startNewTraining;
    @FXML
    private AnchorPane topBanner;
    @FXML
    private MenuBar topMenuBar;
    @FXML
    private Button trainingHistory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);

        fillPatient();

        ObservableList<PieChart.Data> trainingCount = FXCollections.observableArrayList(
                new PieChart.Data("Basic Training", basicTC),
                new PieChart.Data("Advanced Training", advancedTC),
                new PieChart.Data("Bladder Training", bladderTC),
                new PieChart.Data("Stability Training", stabilityTC)
        );

        basicTrainingCount.setText(basicTC + " Time(s)");
        advancedTrainingCount.setText(advancedTC + " Time(s)");
        bladderTrainingCount.setText(bladderTC + " Time(s)");
        stabilityTrainingCount.setText(stabilityTC + " Time(s)");

//        pieTrainingsCount.setTitle("Training Count");
        pieTrainingsCount.setData(trainingCount);
        pieTrainingsCount.setLegendVisible(false);
        pieTrainingsCount.setLabelsVisible(true);
        pieTrainingsCount.setStartAngle(180);

    }

    private void fillPatient() {
        mrn.setText(selectedPatient.getMrn());
        firstName.setText(selectedPatient.getFirstName());
        lastName.setText(selectedPatient.getLastName());
        dob.setText(selectedPatient.getDob());
        nationality.setText(selectedPatient.getNationality());
        id.setText(selectedPatient.getPatientID());
        gender.setText(selectedPatient.getGender());
        email.setText(selectedPatient.getEmail());
        phoneNumber.setText(selectedPatient.getFullPhoneNumber());
        calcAge();
        countTrainings();
    }

    private void calcAge() {
        int currentYear = Integer.parseInt(new Time_Stamp().getYear());
        int patientYear = Integer.parseInt(selectedPatient.getDobYear());
        age.setText(currentYear - patientYear + " Years");
    }

    private void countTrainings() {
        for (int i = 0; i < selectedPatient.getTrainings().size(); i++) {
            switch (selectedPatient.getTrainings().get(i).getType()) {
                case BASIC_TRAINING:
                    basicTC++;
                    break;
                case ADVANCED_TRAINING:
                    advancedTC++;
                    break;
                case BLADDER_TRAINING:
                    bladderTC++;
                    break;
                case STABILITY_TRAINING:
                    stabilityTC++;
                    break;
            }
        }
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(MainPatientDashboard.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(MainPatientDashboard.class);
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

    @FXML
    void aboutLunaEMGPopUp(ActionEvent event) {
        new MyGoTo().popUpScene(AboutLunaEMG.RESOURCE_NAME);
    }


    @FXML
    void logOut(MouseEvent event) {
        new MyGoTo().changeSceneTo(UserListController.RESOURCE_NAME);
    }

    @FXML
    void startNewTraining(MouseEvent event) {
        new MyGoTo().changeSceneTo(SelectTraining.RESOURCE_NAME);
    }

    @FXML
    void trainingHistory(MouseEvent event) {
        new MyGoTo().changeSceneTo(TrainingHistory.RESOURCE_NAME);

    }

    @FXML
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(MainPatientDashboard.class);
    }

}
