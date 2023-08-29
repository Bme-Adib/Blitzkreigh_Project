package com.herculife.herculifepelvictutor.Controllers;

import com.herculife.herculifepelvictutor.Controllers.TrainingControllers.BasicTrainingSetUp;
import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import com.herculife.herculifepelvictutor.ProjectSettings.Strings;
import com.herculife.herculifepelvictutor.ProjectSettings.Time_Stamp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifepelvictutor.Controllers.SelectTraining.currentTrainingObject;
import static com.herculife.herculifepelvictutor.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.*;

public class PostTrainingDashboard implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "PostTrainingDashboard.fxml";
    @FXML
    AnchorPane survey;
    @FXML
    AnchorPane mainViewTop;
    @FXML
    AnchorPane mainViewBot;
    @FXML
    AnchorPane mainViewLeft;

    @FXML
    private Label TradeMarkText;
    @FXML
    private Label age;
    @FXML
    private Rectangle contractionBox;
    @FXML
    private Rectangle decontractionBox;
    @FXML
    private Label dob;
    @FXML
    private Label email;
    @FXML
    private Label firstName;
    @FXML
    private Label gender;
    @FXML
    private Label id;
    @FXML
    private Label lastName;
    @FXML
    private Label mrn;
    @FXML
    private Label nationality;
    @FXML
    private Label phoneNumber;
    @FXML
    private Rectangle relaxationBox;
    @FXML
    private RadioButton q1o7;
    @FXML
    private TextField q1o7Test;
    @FXML
    private Button qNextButton;
    @FXML
    private ToggleGroup q2;
    @FXML
    private ToggleGroup q1;
    @FXML
    private VBox totalCoordinationBox;
    @FXML
    private Label nameOfTheTest;
    @FXML
    private ImageView contractionIndicator;
    @FXML
    private Label contractionIndicatorText;
    @FXML
    private ImageView decontractionIndicator;
    @FXML
    private Label decontractionIndicatorText;
    @FXML
    private ImageView holdingIndicator;
    @FXML
    private Label holdingIndicatorText;
    @FXML
    private ImageView relaxationIndicator;
    @FXML
    private Label relaxationIndicatorText;
    @FXML
    private ImageView strengthIndicator;
    @FXML
    private Label strengthIndicatorText;
    @FXML
    private Label contractionTValue;
    @FXML
    private Label decontractionTValue;
    @FXML
    private Label difValue;
    @FXML
    private Label initialMuscleValue;
    @FXML
    private Label finalMuscleValue;
    @FXML
    private Label holdingTValue;
    @FXML
    private Label maxStrengthValue;
    @FXML
    private Label pausesValue;
    @FXML
    private Label relaxationTValue;
    @FXML
    private Label repsValue;
    @FXML
    private Label setsValue;
    @FXML
    private Label strengthValue;
    @FXML
    private Label targetValue;
    @FXML
    private Label trainingTValue;
    @FXML
    private Button goToPatientDashboard;
    private boolean q1Answered = false;
    private boolean q2Answered = false;

    @FXML
    void aboutPelvicTutorPopUp() {

    }

    @FXML
    void exitButtonAction() {
        MyGoTo.exitApp(BasicTrainingSetUp.class);
    }

    @FXML
    void fileMenu_CloseAction() {
        MyGoTo.exitApp(BasicTrainingSetUp.class);
    }

    @FXML
    void fileMenu_logOut() {
        new MyGoTo().logOut(PostTrainingDashboard.class);
    }

    @FXML
    void helpDesk() {

    }

    @FXML
    void tutorialCreateNewPatient() {

    }

    @FXML
    void tutorialSetUpParameters() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);
        fillPatient();
        setIndicatorPositioningLevels();
        setUpParameters();
        survey.setVisible(true);
        mainViewTop.setVisible(false);
        mainViewBot.setVisible(false);
        mainViewLeft.setVisible(false);
        goToPatientDashboard.setVisible(false);
    }

    private void setIndicatorPositioningLevels() {
        int relaxationCoValue = currentTrainingObject.getRelaxationCoordination();
        int contractionCoValue = currentTrainingObject.getContractionCoordination();
        int holdingCoValue = currentTrainingObject.getHoldingCoordination();
        int decontractionCoValue = currentTrainingObject.getDeContractionCoordination();

        int chartsOffset = 326;
        double chartMultiplier = 2.5;
        int chartTextOffset = -20;

        relaxationIndicator.relocate(0, chartsOffset - relaxationCoValue * chartMultiplier);
        relaxationIndicatorText.relocate(0, chartsOffset + chartTextOffset - relaxationCoValue * chartMultiplier);
        relaxationIndicatorText.setText("My Value\nis " + relaxationCoValue + "%");

        contractionIndicator.relocate(0, chartsOffset - contractionCoValue * chartMultiplier);
        contractionIndicatorText.relocate(0, chartsOffset + chartTextOffset - contractionCoValue * chartMultiplier);
        contractionIndicatorText.setText("My Value\nis " + contractionCoValue + "%");

        holdingIndicator.relocate(0, chartsOffset - holdingCoValue * chartMultiplier);
        holdingIndicatorText.relocate(0, chartsOffset + chartTextOffset - holdingCoValue * chartMultiplier);
        holdingIndicatorText.setText("My Value\nis " + holdingCoValue + "%");

        decontractionIndicator.relocate(0, chartsOffset - decontractionCoValue * chartMultiplier);
        decontractionIndicatorText.relocate(0, chartsOffset + chartTextOffset - decontractionCoValue * chartMultiplier);
        decontractionIndicatorText.setText("My Value\nis " + decontractionCoValue + "%");

        strengthIndicatorText.setText("My Strength\nis " + currentTrainingObject.getMuscleStrength());
    }

    private void setUpParameters() {
        switch (currentTrainingObject.getType()) {
            case BASIC_TRAINING_ID -> nameOfTheTest.setText("Basic Training");
            case ADVANCE_TRAINING_ID -> nameOfTheTest.setText("Advanced Training");
            case BLADDER_TRAINING_ID -> nameOfTheTest.setText("Bladder Training");
            case STABILITY_TRAINING_ID -> nameOfTheTest.setText("Stability Training");
            default -> nameOfTheTest.setText("Adib Training");
        }

        initialMuscleValue.setText(String.valueOf(currentTrainingObject.getInitialMuscleTone()));
        finalMuscleValue.setText(String.valueOf(currentTrainingObject.getFinalMuscleTone()));
        maxStrengthValue.setText(String.valueOf(currentTrainingObject.getMaxMuscleStrength()));
//        strengthValue.setText(String.valueOf(currentTrainingObject.getMuscleStrength()));
        targetValue.setText(currentTrainingObject.getTrainingTarget() + "%");
        relaxationTValue.setText(currentTrainingObject.getRelaxationTime() + " sec");
        contractionTValue.setText(currentTrainingObject.getContractionTime() + " sec");
        holdingTValue.setText(currentTrainingObject.getHoldingTime() + " sec");
        decontractionTValue.setText(currentTrainingObject.getDeContractionTime() + " sec");
        repsValue.setText(String.valueOf(currentTrainingObject.getNumberOfReps()));
        setsValue.setText(String.valueOf(currentTrainingObject.getNumberOfSets()));
        pausesValue.setText(currentTrainingObject.getPausesBetweenSets() + " sec");
        difValue.setText(currentTrainingObject.getDifficultyLevel() + "%");
        trainingTValue.setText(currentTrainingObject.getTrainingTimeText());
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
    }

    private void calcAge() {
        int currentYear = Integer.parseInt(new Time_Stamp().getYear());
        int patientYear = Integer.parseInt(selectedPatient.getDobYear());
        age.setText(currentYear - patientYear + " Years");
    }

    @FXML
    void q1Function() {
        q1Answered = true;
        qNextButton.setDisable(!q2Answered);

        if (q1o7.isSelected()) {
            q1o7Test.setDisable(false);
        } else {
            q1o7Test.setText("");
            q1o7Test.setDisable(true);
        }
    }

    @FXML
    void q2Function() {
        q2Answered = true;
        qNextButton.setDisable(!q1Answered);
    }

    @FXML
    void qNextButtonFunction() {
        RadioButton a = (RadioButton) q1.getSelectedToggle();
        RadioButton b = (RadioButton) q2.getSelectedToggle();
        String surveyQ1Answer;
        if (a.getText().equals("Other:")) {
            surveyQ1Answer = q1o7Test.getText();
        } else {
            surveyQ1Answer = a.getText();
        }
        int surveyQ2Answer = Integer.parseInt(b.getText());

        currentTrainingObject.setSurveyAnswers(surveyQ1Answer, surveyQ2Answer);
        System.out.println(currentTrainingObject.toString());

        survey.setVisible(false);
        mainViewTop.setVisible(true);
        mainViewBot.setVisible(true);
        mainViewLeft.setVisible(true);
        goToPatientDashboard.setVisible(true);
    }

    @FXML
    void goToPatientDashboardFunction() {
        new MyGoTo().changeSceneTo(MainPatientDashboard.RESOURCE_NAME);
    }


}
