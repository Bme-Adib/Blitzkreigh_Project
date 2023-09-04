package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.ProjectClasses.TrainingClass;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Time_Stamp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo.returnTrainingType;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;

public class TrainingHistory implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "TrainingHistory.fxml";
    ArrayList<TrainingHistoryCell> allCells = new ArrayList<>();
    ArrayList<CheckBox> allCheckBoxes = new ArrayList<>();
    ArrayList<TrainingClass> previousTrainings = new ArrayList<>();
    @FXML
    private AnchorPane LeftBox;
    @FXML
    private AnchorPane RightBox;
    @FXML
    private AnchorPane TopBox;
    @FXML
    private Label TradeMarkText;
    @FXML
    private Label age;
    @FXML
    private ImageView bgImage;
    @FXML
    private Label dob;
    @FXML
    private Label email;
    @FXML
    private AnchorPane exitAndBottomText;
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
    private MenuBar topMenuBar;
    @FXML
    private Button trainingHistory;
    @FXML
    private AnchorPane trainingHistoryBox;
    @FXML
    private AnchorPane trainingHistoryBoxBackground;
    @FXML
    private VBox trainingsPanel;
    @FXML
    private ScrollPane trainingPanelScroll;
    @FXML
    private Label viewCO;
    @FXML
    private Label viewContractionTime;
    @FXML
    private Label viewDecontractionCo;
    @FXML
    private Label viewDecontractionTime;
    @FXML
    private Label viewDifficultyLevel;
    @FXML
    private Label viewFinalM;
    @FXML
    private Label viewHoldingCo;
    @FXML
    private Label viewHoldingTime;
    @FXML
    private Label viewInitialM;
    @FXML
    private Label viewMaxStrength;
    @FXML
    private Label viewMuscleStrength;
    @FXML
    private Label viewPauses;
    @FXML
    private Label viewRelaxationCo;
    @FXML
    private Label viewRelaxationTime;
    @FXML
    private Label viewReps;
    @FXML
    private Label viewSets;
    @FXML
    private Label viewSurveyAnswer1;
    @FXML
    private Label viewSurveyAnswer2;
    @FXML
    private Label viewTimeStamp;
    @FXML
    private Label viewTrainingTarget;
    @FXML
    private Label viewTrainingTime;
    @FXML
    private Label viewTrainingType;

    @FXML
    void trainingHistory(MouseEvent event) {

    }

    public ArrayList<Integer> getCheckedBoxes() {
        ArrayList<Integer> checkedBoxesToPrint = new ArrayList<>();
        for (int i = previousTrainings.size() - 1; i >= 0; i--) {
            if (allCheckBoxes.get(i).isSelected()) {
                checkedBoxesToPrint.add(allCheckBoxes.size() - 1 - i);
            }
        }
        return checkedBoxesToPrint;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillPatient();
        previousTrainings = selectedPatient.getTrainings();
        for (int i = previousTrainings.size() - 1; i >= 0; i--) {
            CheckBox checkBox = new CheckBox((i + 1) + ". " + returnTrainingType(previousTrainings.get(i).getType()) + "\n      " + previousTrainings.get(i).getTimeStamp() + "");
            checkBox.setId("prev" + i);
            allCheckBoxes.add(checkBox);
            checkBox.setAlignment(Pos.CENTER_LEFT);
            checkBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getClickCount() == 1) {
                        checkBox.setSelected(false);
                        showInfo(Integer.parseInt(checkBox.getId().substring(4)));
                    }
                    if (mouseEvent.getClickCount() == 2) {
                        checkBox.setSelected(true);
                    }
                }
            });

            checkBox.getStyleClass().add("previousTrainingCheckBox");
            checkBox.getStyleClass().add("inputText");
            trainingsPanel.getChildren().add(checkBox);


//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource(TrainingHistoryCell.RESOURCE_NAME));
//                AnchorPane trainingsBox = fxmlLoader.load();
//                TrainingHistoryCell cell = fxmlLoader.getController();
//                cell.setValues("Adib", "Ghannam");
//                allCells.add(cell);
//                trainingsPanel.getChildren().add(trainingsBox);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }

            //TODO: Listener to the Vbox to get which item check lastly
            //TODO: Find a Way to separate click and check
        }
    }

    private void showInfo(int checkBoxIndex) {
        TrainingClass selectedTraining = previousTrainings.get(checkBoxIndex);
        viewTimeStamp.setText(selectedTraining.getTimeStamp());
        viewTrainingType.setText(returnTrainingType(selectedTraining.getType()));
        viewTrainingTime.setText(String.valueOf(selectedTraining.getTrainingTime()));
        viewRelaxationCo.setText(selectedTraining.getRelaxationCoordination() + "%");
        viewDecontractionCo.setText(selectedTraining.getDeContractionCoordination() + "%");
        viewHoldingCo.setText(selectedTraining.getHoldingCoordination() + "%");
        viewDecontractionCo.setText(selectedTraining.getDeContractionCoordination() + "%");
        viewCO.setText(selectedTraining.getTimeStamp() + "%");
        viewInitialM.setText(String.valueOf(selectedTraining.getInitialMuscleTone()));
        viewFinalM.setText(String.valueOf(selectedTraining.getFinalMuscleTone()));
        viewMaxStrength.setText(String.valueOf(selectedTraining.getMaxMuscleStrength()));
        viewMuscleStrength.setText(String.valueOf(selectedTraining.getMuscleStrength()));
        viewTrainingTarget.setText(selectedTraining.getTrainingTarget() + "%");
        viewRelaxationTime.setText(selectedTraining.getRelaxationTime() + " Sec");
        viewContractionTime.setText(selectedTraining.getContractionTime() + " Sec");
        viewHoldingTime.setText(selectedTraining.getHoldingTime() + " Sec");
        viewDecontractionTime.setText(selectedTraining.getDeContractionTime() + " Sec");
        viewReps.setText(String.valueOf(selectedTraining.getNumberOfReps()));
        viewSets.setText(String.valueOf(selectedTraining.getNumberOfSets()));
        viewDifficultyLevel.setText(String.valueOf(selectedTraining.getDifficultyLevel()));
        viewPauses.setText(selectedTraining.getPausesBetweenSets() + " Sec");
        viewSurveyAnswer1.setText(selectedTraining.getSurveyAnswer1());
        viewSurveyAnswer2.setText(String.valueOf(selectedTraining.getSurveyAnswer2()));
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
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(TrainingHistory.class);
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
    void aboutPelvicTutorPopUp(ActionEvent event) {
        new MyGoTo().popUpScene(AboutPelvicTutor.RESOURCE_NAME);
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(TrainingHistory.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(TrainingHistory.class);
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

}
