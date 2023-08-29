package com.herculife.herculifepelvictutor.Controllers.TrainingControllers;

import com.herculife.herculifepelvictutor.Controllers.AboutPelvicTutor;
import com.herculife.herculifepelvictutor.Controllers.PostTrainingDashboard;
import com.herculife.herculifepelvictutor.Controllers.SelectTraining;
import com.herculife.herculifepelvictutor.ProjectClasses.TrainingClass;
import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import com.herculife.herculifepelvictutor.ProjectSettings.Strings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import static com.herculife.herculifepelvictutor.Controllers.SelectTraining.currentTrainingObject;
import static com.herculife.herculifepelvictutor.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.FxmlPre;

public class AdvancedTrainingSetUp implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "TrainingViews/AdvancedTrainingSetUp.fxml";
    private final double shotTime = 0.5;
    private final XYChart.Series<Number, Number> trainingSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> topMarginSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> botMarginSeries = new XYChart.Series<>();
    private final double maxTrainingValue = 160;
    private final String percentUnit = " %";
    private final String timeUnit = " sec";
    private final String repsUnit = " Reps";
    private final String setsUnit = " Sets";
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
    private Label dob;
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
    private Label mrn;
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
    private LineChart<Number, Number> trainingChart;
    @FXML
    private NumberAxis trainingChartXAxis;
    @FXML
    private NumberAxis trainingChartYAxis;
    private int relaxationTime = 0;
    private double contractionTime = 0;
    private double decontractionTime = 0;
    private double holdingTime = 0;
    private int targetTrainingValue = 60;
    private int handeCap;
    private double oneTrainingInSec;

    @FXML
    void aboutPelvicTutorPopUp() {
        new MyGoTo().popUpScene(AboutPelvicTutor.RESOURCE_NAME);
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
        new MyGoTo().logOut(BasicTrainingSetUp.class);
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
        //TODO: Merge all controllers into one.
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
        trainingChart.setTitle("Advanced Pelvic Training");
        updateChart();
    }

    private void updateChart() {
        trainingSeries.getData().clear();
        topMarginSeries.getData().clear();
        botMarginSeries.getData().clear();
        //Advanced Training DataSet 11 Points
        int xPoint1 = 0;
        int yPoint1 = 0;
        double xPoint2 = relaxationTime / 2.0;
        int yPoint2 = 0;
        double xPoint3 = xPoint2 + contractionTime;
        int yPoint3 = targetTrainingValue;
        double xPoint4 = xPoint3 + holdingTime;
        int yPoint4 = targetTrainingValue;
        double xPoint5 = xPoint4 + decontractionTime;
        int yPoint5 = 0;
        double xPoint6 = xPoint5 + relaxationTime / 4.0;
        int yPoint6 = 0;
        double xPoint7 = xPoint6 + shotTime;
        int yPoint7 = targetTrainingValue;
        double xPoint8 = xPoint7 + shotTime;
        int yPoint8 = 0;
        double xPoint9 = xPoint8 + shotTime;
        int yPoint9 = targetTrainingValue;
        double xPoint10 = xPoint9 + shotTime;
        int yPoint10 = 0;
        double xPoint11 = xPoint10 + relaxationTime / 4.0;
        int yPoint11 = 0;

        trainingSeries.getData().add(new XYChart.Data<>(xPoint1, yPoint1));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint2, yPoint2));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint3, yPoint3));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint4, yPoint4));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint5, yPoint5));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint6, yPoint6));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint7, yPoint7));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint8, yPoint8));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint9, yPoint9));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint10, yPoint10));
        trainingSeries.getData().add(new XYChart.Data<>(xPoint11, yPoint11));


        trainingChart.getData().add(trainingSeries);

        trainingChartXAxis.setAutoRanging(false);
        trainingChartXAxis.setLowerBound(0);
        trainingChartXAxis.setUpperBound(xPoint11);
        trainingChartXAxis.setTickUnit(1);

        trainingChartYAxis.setAutoRanging(false);
        trainingChartYAxis.setLowerBound(-handeCap - 20);
        trainingChartYAxis.setUpperBound(120);
        trainingChartYAxis.setTickUnit(5);

        double handeCapDiff = handeCap / 20.0;

        int xPointHT1 = 0;
        int yPointHT1 = handeCap;

        double xPointHT2 = xPoint2 - handeCapDiff;
        int yPointHT2 = handeCap;

        double xPointHT3 = xPoint3 - handeCapDiff;
        int yPointHT3 = targetTrainingValue + handeCap;

        double xPointHT4 = xPoint4 + handeCapDiff;
        int yPointHT4 = targetTrainingValue + handeCap;

        double xPointHT5 = xPoint5 + handeCapDiff;
        int yPointHT5 = handeCap;

        double xPointHT6 = xPoint6 - handeCapDiff;
        int yPointHT6 = handeCap;

        if (xPointHT5 > xPointHT6) {
            double temp = (xPointHT6 + xPointHT5) / 2;
            xPointHT5 = temp;
            xPointHT6 = temp;
        }

        double xPointHT7 = xPoint7;
        int yPointHT7 = targetTrainingValue + handeCap;

        double xPointHT8 = xPoint8;
        int yPointHT8 = targetTrainingValue - handeCap / 2;

        if (handeCap >= 25) {
            yPointHT8 += handeCap / 2;
        }

        double xPointHT9 = xPoint9;
        int yPointHT9 = targetTrainingValue + handeCap;

        if (handeCap <= 10) {
            xPointHT7 -= 0.25;
            xPointHT9 += 0.25;
        }

        double xPointHT10 = xPoint10 + handeCapDiff;
        int yPointHT10 = handeCap;

        double xPointHT11 = xPoint11;
        int yPointHT11 = handeCap;

        topMarginSeries.getData().addAll(
                new XYChart.Data<>(xPointHT1, yPointHT1),
                new XYChart.Data<>(xPointHT2, yPointHT2),
                new XYChart.Data<>(xPointHT3, yPointHT3),
                new XYChart.Data<>(xPointHT4, yPointHT4),
                new XYChart.Data<>(xPointHT5, yPointHT5),
                new XYChart.Data<>(xPointHT6, yPointHT6),
                new XYChart.Data<>(xPointHT7, yPointHT7),
                new XYChart.Data<>(xPointHT8, yPointHT8),
                new XYChart.Data<>(xPointHT9, yPointHT9),
                new XYChart.Data<>(xPointHT10, yPointHT10),
                new XYChart.Data<>(xPointHT11, yPointHT11)
        );

        trainingChart.getData().add(topMarginSeries);

        int xPointHB1 = 0;
        int yPointHB1 = -handeCap;

        double xPointHB2 = xPoint2 + handeCapDiff;
        int yPointHB2 = -handeCap;

        double xPointHB3 = xPoint3 + handeCapDiff;
        int yPointHB3 = targetTrainingValue - handeCap;

        double xPointHB4 = xPoint4 - handeCapDiff;
        int yPointHB4 = targetTrainingValue - handeCap;

        if (xPointHB3 > xPointHB4) {
            double temp = (xPointHB3 + xPointHB4) / 2;
            xPointHB3 = temp;
            xPointHB4 = temp;
        }

        double xPointHB5 = xPoint5 - handeCapDiff;
        int yPointHB5 = -handeCap;

        double xPointHB6 = xPoint6 + handeCapDiff / 4;
        int yPointHB6 = -handeCap;

        double xPointHB7 = xPoint7;
        double yPointHB7;
        if (handeCap <= 15) {
            yPointHB7 = targetTrainingValue - handeCap * 2 - 0.5 * handeCap * 2;

        } else {
            yPointHB7 = targetTrainingValue - handeCap - 0.5 * handeCap;
        }

        double xPointHB8 = xPoint8;
        int yPointHB8 = -handeCap;

        double xPointHB9 = xPoint9;
        double yPointHB9;
        if (handeCap <= 15) {
            yPointHB9 = targetTrainingValue - handeCap * 2 - 0.5 * handeCap * 2;
        } else {
            yPointHB9 = targetTrainingValue - handeCap - 0.5 * handeCap;
        }


        double xPointHB10 = xPoint10 - handeCapDiff / 4;
        int yPointHB10 = -handeCap;

        double xPointHB11 = xPoint11;
        int yPointHB11 = -handeCap;

        botMarginSeries.getData().addAll(
                new XYChart.Data<>(xPointHB1, yPointHB1),
                new XYChart.Data<>(xPointHB2, yPointHB2),
                new XYChart.Data<>(xPointHB3, yPointHB3),
                new XYChart.Data<>(xPointHB4, yPointHB4),
                new XYChart.Data<>(xPointHB5, yPointHB5),
                new XYChart.Data<>(xPointHB6, yPointHB6),
                new XYChart.Data<>(xPointHB7, yPointHB7),
                new XYChart.Data<>(xPointHB8, yPointHB8),
                new XYChart.Data<>(xPointHB9, yPointHB9),
                new XYChart.Data<>(xPointHB10, yPointHB10),
                new XYChart.Data<>(xPointHB11, yPointHB11)
        );

        trainingChart.getData().add(botMarginSeries);

    }

    private void updateTimes() {
        double oneRep = slider2.getValue() + slider3.getValue() + slider4.getValue() + slider5.getValue() + 4 * shotTime;      //Spikes add here
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
    void sliderFunction1() {
        sliderValue1.textProperty().setValue((int) slider1.getValue() + " %");
        targetTrainingValue = (int) (slider1.getValue());
        updateChart();
    }

    @FXML
    void sliderFunction2() {
        sliderValue2.textProperty().setValue((int) slider2.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction3() {
        sliderValue3.textProperty().setValue((int) slider3.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction4() {
        sliderValue4.textProperty().setValue((int) slider4.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction5() {
        sliderValue5.textProperty().setValue((int) slider5.getValue() + timeUnit);
        updateTimes();
        updateChart();
    }

    @FXML
    void sliderFunction6() {
        sliderValue6.textProperty().setValue((int) slider6.getValue() + setsUnit);
        updateTimes();
//        updateChart();
    }

    @FXML
    void sliderFunction7() {
        sliderValue7.textProperty().setValue((int) slider7.getValue() + repsUnit);
        updateTimes();
        startTrainingButton.setDisable(slider7.getValue() == 0);
//        updateChart();
    }

    @FXML
    void sliderFunction8() {
        sliderValue8.textProperty().setValue((int) slider8.getValue() + timeUnit);
        updateTimes();
//        updateChart();
    }

    @FXML
    void sliderFunction9() {
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
    void startTrainingFunction() {
        setTrainingParameters();
        new MyGoTo().changeSceneTo(PostTrainingDashboard.RESOURCE_NAME);
    }

    @FXML
    void goBackButton() {
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
