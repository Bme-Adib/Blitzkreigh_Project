package com.herculife.herculifepelvictutor.Controllers.TrainingControllers;

import com.herculife.herculifepelvictutor.Controllers.AboutPelvicTutor;
import com.herculife.herculifepelvictutor.Controllers.PostTrainingDashboard;
import com.herculife.herculifepelvictutor.Controllers.SelectTraining;
import com.herculife.herculifepelvictutor.ProjectClasses.TrainingClass;
import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import com.herculife.herculifepelvictutor.ProjectSettings.Strings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifepelvictutor.Controllers.SelectTraining.currentTrainingObject;
import static com.herculife.herculifepelvictutor.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.FxmlPre;

public class BasicTrainingSetUp implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "TrainingViews/BasicTrainingSetUp.fxml";
    private final XYChart.Series<Number, Number> trainingSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> topMarginSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> botMarginSeries = new XYChart.Series<>();
    private final String percentUnit = " %";
    private final String timeUnit = " sec";
    private final String repsUnit = " Reps";
    private final String setsUnit = " Sets";
    @FXML
    private VBox HoldingTime;
    @FXML
    private VBox RelaxationBlock;
    @FXML
    private Button startTrainingButton;
    @FXML
    private Label sliderText1;
    @FXML
    private Label sliderText2;
    @FXML
    private Label sliderText3;
    @FXML
    private Label sliderText4;
    @FXML
    private Label sliderText5;
    @FXML
    private Label sliderText6;
    @FXML
    private Label sliderText7;
    @FXML
    private Label sliderText8;
    @FXML
    private Label sliderText9;
    @FXML
    private Label sliderValue1;
    @FXML
    private Label sliderValue2;
    @FXML
    private Label sliderValue3;
    @FXML
    private Label sliderValue4;
    @FXML
    private Label sliderValue5;
    @FXML
    private Label sliderValue6;
    @FXML
    private Label sliderValue7;
    @FXML
    private Label sliderValue8;
    @FXML
    private Label sliderValue9;
    @FXML
    private Label TradeMarkText;
    @FXML
    private VBox afterContractionSpikes;
    @FXML
    private Label dob;
    @FXML
    private AnchorPane backgroundForTop;
    @FXML
    private ImageView bgImage;
    @FXML
    private VBox contractionBlock;
    @FXML
    private VBox decontractionBlock;
    @FXML
    private Button exitButton;
    @FXML
    private MenuItem fileMenu_Close;
    @FXML
    private Label totalRepTime;
    @FXML
    private Label totalSetTime;
    @FXML
    private Label totalTrainingTime;
    @FXML
    private Label firstName;
    @FXML
    private Label gender;
    @FXML
    private Label id;
    @FXML
    private Label lastName;
    @FXML
    private AnchorPane mainStuff;
    @FXML
    private Label mrn;
    @FXML
    private VBox reps;
    @FXML
    private AnchorPane root;
    @FXML
    private VBox sets;
    @FXML
    private Slider slider1;
    @FXML
    private Slider slider2;
    @FXML
    private Slider slider3;
    @FXML
    private Slider slider4;
    @FXML
    private Slider slider5;
    @FXML
    private Slider slider6;
    @FXML
    private Slider slider7;
    @FXML
    private Slider slider8;
    @FXML
    private Slider slider9;
    @FXML
    private MenuBar topMenuBar;
    @FXML
    private LineChart<Number, Number> trainingChart;
    @FXML
    private NumberAxis trainingChartXAxis;
    @FXML
    private NumberAxis trainingChartYAxis;
    @FXML
    private VBox trainingTargetBlock;
    private double maxTrainingValue;
    private int relaxationTime;
    private double contractionTime;
    private double decontractionTime;
    private double holdingTime;
    private int targetTrainingValue;
    private int handeCap;
    private double handeCapDiff;
    private double oneTrainingInSec;

    @FXML
    void aboutPelvicTutorPopUp(ActionEvent event) {
        new MyGoTo().popUpScene(AboutPelvicTutor.RESOURCE_NAME);
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(BasicTrainingSetUp.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(BasicTrainingSetUp.class);
    }

    @FXML
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(BasicTrainingSetUp.class);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);
        setUpPatientDetails();
        updateTimes();
        setUpSliders();
        setUpChart();
        setDefaults();
        updateSliderToDefaultTexts();
    }

    private void setDefaults() {
        targetTrainingValue = 60;
        relaxationTime = 8;
        contractionTime = 3;
        holdingTime = 3;
        decontractionTime = 3;
        handeCap = 15;

        slider1.setValue(targetTrainingValue);       //Target
        slider2.setValue(relaxationTime);       //Relaxation
        slider3.setValue(contractionTime);       //Contraction
        slider4.setValue(holdingTime);       //Holding
        slider5.setValue(decontractionTime);       //Decontraction
        slider6.setValue(3);       //Sets
        slider7.setValue(10);       //Reps
        slider8.setValue(30);       //Pause

        updateTimes();
        updateChart();
    }

    private void setUpChart() {
        trainingChart.setTitle("Basic Pelvic Training");
        updateChart();
    }

    private void updateChart() {
        trainingSeries.getData().clear();
        topMarginSeries.getData().clear();
        botMarginSeries.getData().clear();
        //Basic Training DataSet 6 Points
        int xPoint1 = 0;
        int yPoint1 = 0;
        double xPoint2 = relaxationTime / 2;
        int yPoint2 = 0;
        double xPoint3 = xPoint2 + contractionTime;
        int yPoint3 = targetTrainingValue;
        double xPoint4 = xPoint3 + holdingTime;
        int yPoint4 = targetTrainingValue;
        double xPoint5 = xPoint4 + decontractionTime;
        int yPoint5 = 0;
        double xPoint6 = xPoint5 + relaxationTime / 2;
        int yPoint6 = 0;

        double endPointX = xPoint6;

        trainingSeries.getData().add(new XYChart.Data<>(xPoint1, yPoint1));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint2, yPoint2));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint3, yPoint3));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint4, yPoint4));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint5, yPoint5));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint6, yPoint6));

        trainingChart.getData().add(trainingSeries);

        trainingChartXAxis.setAutoRanging(false);
        trainingChartXAxis.setLowerBound(0);
        trainingChartXAxis.setUpperBound(endPointX);
        trainingChartXAxis.setTickUnit(1);

        trainingChartYAxis.setAutoRanging(false);
        trainingChartYAxis.setLowerBound(-handeCap - 20);
        trainingChartYAxis.setUpperBound(120);
        trainingChartYAxis.setTickUnit(5);

        handeCapDiff = handeCap / 20.0;
        System.out.println(handeCapDiff);

        int xPointHT1 = 0;
        int yPointHT1 = handeCap;

        double xPointHT2 = relaxationTime / 2 - handeCapDiff;
        int yPointHT2 = handeCap;

        double xPointHT3 = xPoint2 + contractionTime - handeCapDiff;
        int yPointHT3 = targetTrainingValue + handeCap;

        double xPointHT4 = xPoint3 + holdingTime + handeCapDiff;
        int yPointHT4 = targetTrainingValue + handeCap;

        double xPointHT5 = xPoint4 + decontractionTime + handeCapDiff;
        int yPointHT5 = handeCap;

        double xPointHT6 = xPoint5 + relaxationTime / 2;
        int yPointHT6 = handeCap;

        topMarginSeries.getData().addAll(
                new XYChart.Data<>(xPointHT1, yPointHT1),
                new XYChart.Data<>(xPointHT2, yPointHT2),
                new XYChart.Data<>(xPointHT3, yPointHT3),
                new XYChart.Data<>(xPointHT4, yPointHT4),
                new XYChart.Data<>(xPointHT5, yPointHT5),
                new XYChart.Data<>(xPointHT6, yPointHT6)
        );

        trainingChart.getData().add(topMarginSeries);

        int xPointHB1 = 0;
        int yPointHB1 = -handeCap;

        double xPointHB2 = relaxationTime / 2 + handeCapDiff;
        int yPointHB2 = -handeCap;

        double xPointHB3 = xPoint2 + contractionTime + handeCapDiff;
        int yPointHB3 = targetTrainingValue - handeCap;

        double xPointHB4 = xPoint3 + holdingTime - handeCapDiff;
        int yPointHB4 = targetTrainingValue - handeCap;

        if (xPointHB3 > xPointHB4) {
            double temp = (xPointHB3 + xPointHB4) / 2;
            xPointHB3 = temp;
            xPointHB4 = temp;
        }

        double xPointHB5 = xPoint4 + decontractionTime - handeCapDiff;
        int yPointHB5 = -handeCap;

        double xPointHB6 = xPoint5 + relaxationTime / 2;
        int yPointHB6 = -handeCap;

        botMarginSeries.getData().addAll(
                new XYChart.Data<>(xPointHB1, yPointHB1),
                new XYChart.Data<>(xPointHB2, yPointHB2),
                new XYChart.Data<>(xPointHB3, yPointHB3),
                new XYChart.Data<>(xPointHB4, yPointHB4),
                new XYChart.Data<>(xPointHB5, yPointHB5),
                new XYChart.Data<>(xPointHB6, yPointHB6)
        );

        trainingChart.getData().add(botMarginSeries);

    }

    private void updateTimes() {
        double oneRep = slider2.getValue() + slider3.getValue() + slider4.getValue() + slider5.getValue();      //Spikes add here
        double oneSet = (oneRep * slider7.getValue());
        int oneSetMin;
        int oneSetRemainingSec;

        if (oneSet >= 60) {
            oneSetMin = (int) (oneSet / 60);
            oneSetRemainingSec = (int) (oneSet % 60);
            totalSetTime.setText(oneSetMin + " Min " + oneSetRemainingSec + " Sec");
        } else {
            totalSetTime.setText((int) oneSet + " Sec");
        }

        oneTrainingInSec = (oneSet * slider6.getValue()) + (slider8.getValue() * (slider6.getValue() - 1));

        if (oneTrainingInSec >= 60) {
            int oneTrainingMin = (int) (oneTrainingInSec / 60);
            int oneTrainingRemainingSec = (int) (oneTrainingInSec % 60);
            totalTrainingTime.setText(oneTrainingMin + " Min " + oneTrainingRemainingSec + " Sec");
        } else {
            totalTrainingTime.setText((int) oneTrainingInSec + " Sec ");
        }

        totalRepTime.setText((int) oneRep + " Sec");

        relaxationTime = (int) slider2.getValue();
        contractionTime = (int) slider3.getValue();
        holdingTime = (int) slider4.getValue();
        decontractionTime = (int) slider5.getValue();

    }

    private void setUpPatientDetails() {
        mrn.setText(selectedPatient.getMrn());
        firstName.setText(selectedPatient.getFirstName());
        lastName.setText(selectedPatient.getLastName());
        id.setText(selectedPatient.getPatientID());
        dob.setText(selectedPatient.getDob());
        gender.setText(selectedPatient.getGender());
    }

    private void setUpSliders() {
        sliderText1.setText("1. Target Strength Level");
        sliderText2.setText("2. Relaxation Time");
        sliderText3.setText("3. Contraction Time");
        sliderText4.setText("4. Holding Time");
        sliderText5.setText("5. Decontraction Time");
        sliderText7.setText("6. Repetitions");
        sliderText6.setText("7. Sets");
        sliderText8.setText("8. Pause Between Sets");
        sliderText9.setText("9. Difficulty Level");
    }

    @FXML
    void sliderFunction1(MouseEvent event) {
        sliderValue1.textProperty().setValue((int) slider1.getValue() + " %");
        targetTrainingValue = (int) (slider1.getValue());
        updateChart();
    }

    @FXML
    void sliderFunction2(MouseEvent event) {
        sliderValue2.textProperty().setValue((int) slider2.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction3(MouseEvent event) {
        sliderValue3.textProperty().setValue((int) slider3.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction4(MouseEvent event) {
        sliderValue4.textProperty().setValue((int) slider4.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction5(MouseEvent event) {
        sliderValue5.textProperty().setValue((int) slider5.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction6(MouseEvent event) {
        sliderValue6.textProperty().setValue((int) slider6.getValue() + setsUnit);
        updateTimes();
//        updateChart();
    }

    @FXML
    void sliderFunction7(MouseEvent event) {
        sliderValue7.textProperty().setValue((int) slider7.getValue() + repsUnit);
        updateTimes();
        startTrainingButton.setDisable(slider7.getValue() == 0);
//        updateChart();
    }

    @FXML
    void sliderFunction8(MouseEvent event) {
        sliderValue8.textProperty().setValue((int) slider8.getValue() + timeUnit);
        updateTimes();
//        updateChart();
    }

    @FXML
    void sliderFunction9(MouseEvent event) {
        sliderValue9.textProperty().setValue((int) slider9.getValue() + percentUnit);
        handeCap = (int) slider9.getValue();
//        updateTimes();
        updateChart();
    }

    private void setTrainingParameters() {
        currentTrainingObject = new TrainingClass();
        currentTrainingObject.setTrainingParameters(TrainingClass.ADVANCED_TRAINING, targetTrainingValue, relaxationTime,
                contractionTime, holdingTime, decontractionTime, (int) slider7.getValue(),
                (int) slider6.getValue(), (int) slider8.getValue(), (int) slider9.getValue(), oneTrainingInSec);
        System.out.println(currentTrainingObject.toString());
    }

    @FXML
    void startTrainingFunction(MouseEvent event) {
        setTrainingParameters();
        new MyGoTo().changeSceneTo(PostTrainingDashboard.RESOURCE_NAME);
    }

    @FXML
    void goBackButton(MouseEvent event) {
        new MyGoTo().changeSceneTo(SelectTraining.RESOURCE_NAME);
    }

    private void updateSliderToDefaultTexts() {
        sliderValue1.textProperty().setValue((int) slider1.getValue() + " %");
        sliderValue2.textProperty().setValue((int) slider2.getValue() + timeUnit);
        sliderValue3.textProperty().setValue((int) slider3.getValue() + timeUnit);
        sliderValue4.textProperty().setValue((int) slider4.getValue() + timeUnit);
        sliderValue5.textProperty().setValue((int) slider5.getValue() + timeUnit);
        sliderValue6.textProperty().setValue((int) slider6.getValue() + setsUnit);
        sliderValue7.textProperty().setValue((int) slider7.getValue() + repsUnit);
        sliderValue8.textProperty().setValue((int) slider8.getValue() + timeUnit);
        sliderValue9.textProperty().setValue((int) slider9.getValue() + percentUnit);
    }

}
