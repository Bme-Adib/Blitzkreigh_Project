package com.herculife.herculifeLunaEMG.Controllers.TrainingControllers;

import com.herculife.herculifeLunaEMG.Controllers.AboutLunaEMG;
import com.herculife.herculifeLunaEMG.Controllers.PostTrainingDashboard;
import com.herculife.herculifeLunaEMG.Controllers.SelectTraining;
import com.herculife.herculifeLunaEMG.ProjectClasses.ChartPoint;
import com.herculife.herculifeLunaEMG.ProjectClasses.SignalAnalytics;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import static com.herculife.herculifeLunaEMG.Controllers.UserListController.selectedPatient;
import static com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo.exportToCSV;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;

public class AdvancedTrainingSetUp implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "TrainingViews/AdvancedTrainingSetUp.fxml";
    public static ArrayList<ChartPoint> EMGTraining = new ArrayList<>();
    private final XYChart.Series<Number, Number> testSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> testHighSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> testLowSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> thresholdLine = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> averageLine = new XYChart.Series<>();
    private int threshold = 20;
    double totalSeconds = 26;
    int interval = 40;
    int zoom = 12;

    int correction = 1000 / interval;
    double runningI = totalSeconds * correction;
    double chartXWidth = (double) zoom / 2 * correction;
    @FXML
    private Button startTrainingButton;
    @FXML
    private Label TradeMarkText;
    @FXML
    private Label dob;
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
    private LineChart<Number, Number> trainingChart;
    @FXML
    private NumberAxis trainingChartXAxis;
    @FXML
    private Label thresholdValue;
    @FXML
    private Label signalAnalyticsLabel;
    double finalI = 0;
    Thread timerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (double i = 0; i < runningI; i += 1) {
                    finalI = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            thresholdLine.getData().clear();
                            thresholdLine.getData().add(new XYChart.Data<>(0,threshold));
                            thresholdLine.getData().add(new XYChart.Data<>(runningI,threshold));
                            double rand = ThreadLocalRandom.current().nextInt(10, 100 + 1);
                            testSeries.setName("EMG");
                            testSeries.getData().add(new XYChart.Data<Number, Number>(finalI / correction, rand));
                            EMGTraining.add(new ChartPoint(finalI / correction, rand));
                            if (totalSeconds > (chartXWidth * 2 / correction)) {
                                if (finalI > chartXWidth) {
                                    if (finalI >= (runningI - chartXWidth)) {
                                        trainingChartXAxis.setUpperBound((double) runningI / correction);
                                    } else {
                                        trainingChartXAxis.setLowerBound(0 + (-(chartXWidth - finalI)) / correction);
                                        trainingChartXAxis.setUpperBound((double) chartXWidth / correction + finalI / correction);
                                    }
                                } else {
                                    trainingChartXAxis.setLowerBound(0);
                                    trainingChartXAxis.setUpperBound((chartXWidth * 2) / correction);
                                }
                            } else {
                                trainingChartXAxis.setLowerBound(0);
                                trainingChartXAxis.setUpperBound(totalSeconds);
                            }
                        }
                    });
                    Thread.sleep(interval); // Sleep for 0.05 second
                }
                SignalAnalytics signalAnalytics = MyGoTo.analyzeTheSignal(EMGTraining,interval);
                System.out.println(signalAnalytics);

                exportToCSV(EMGTraining);
                markPoints(signalAnalytics);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private void markPoints(SignalAnalytics signalAnalytics) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                signalAnalyticsLabel.setText(signalAnalytics.toString());
                trainingChart.getData().add(testLowSeries);
                trainingChart.getData().add(testHighSeries);
                trainingChart.getData().add(averageLine);
                for (ChartPoint chartPoint : signalAnalytics.getAllHighestPoints()){
                    testHighSeries.getData().add((new XYChart.Data<Number, Number>(chartPoint.getX(), chartPoint.getY())));
                }
                for (ChartPoint chartPoint : signalAnalytics.getAllLowestPoints()){
                    testLowSeries.getData().add((new XYChart.Data<Number, Number>(chartPoint.getX(), chartPoint.getY())));
                }
                averageLine.getData().add(new XYChart.Data<>(0,signalAnalytics.getAverage()));
                averageLine.getData().add(new XYChart.Data<>(runningI,signalAnalytics.getAverage()));
                thresholdLine.getData().clear();
                thresholdSlider.setVisible(false);
                System.out.println(EMGTraining.get(0));
            }
        });

    }

    @FXML
    private Slider zoomSlider;
    @FXML
    private Slider thresholdSlider;
    @FXML
    private NumberAxis trainingChartYAxis;

    @FXML
    void aboutLunaEMGPopUp() {
        new MyGoTo().popUpScene(AboutLunaEMG.RESOURCE_NAME);
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
        TradeMarkText.setText(Strings.TradeMarkText);
        setUpPatientDetails();
        drawLine();
    }

    private void drawLine() {
        trainingChart.setAnimated(false);
        trainingChart.getData().add(testSeries);
        trainingChart.getData().add(thresholdLine);
        trainingChartXAxis.setAutoRanging(false);
        trainingChartXAxis.setLowerBound(0);
        trainingChartXAxis.setUpperBound(3);
        trainingChartXAxis.setTickUnit(1);

        trainingChartYAxis.setAutoRanging(false);
        trainingChartYAxis.setLowerBound(0);
        trainingChartYAxis.setUpperBound(130);
        trainingChartYAxis.setTickUnit(5);

        timerThread.start(); // Start the timer thread
    }


    private void setUpPatientDetails() {
        mrn.setText(selectedPatient.getMrn());
        firstName.setText(selectedPatient.getFirstName());
        lastName.setText(selectedPatient.getLastName());
        id.setText(selectedPatient.getPatientID());
        dob.setText(selectedPatient.getDob());
        gender.setText(selectedPatient.getGender());
    }

    public void zoomChangeSlider(javafx.scene.input.MouseEvent mouseEvent) {
        zoom = (int) zoomSlider.getValue();
        chartXWidth = (double) zoom / 2 * correction;
    }

    @FXML
    void startTrainingFunction() {
        new MyGoTo().changeSceneTo(PostTrainingDashboard.RESOURCE_NAME);
    }
    boolean toggleView = true;
    @FXML
    void goBackButton() {
        if (toggleView){
            trainingChartXAxis.setLowerBound(0);
        }else{
            trainingChartXAxis.setLowerBound(totalSeconds - 2*((double) chartXWidth / correction));
        }
        toggleView=!toggleView;
    }


    public void thresholdSliderFunction() {
        thresholdValue.setText(String.valueOf((int)thresholdSlider.getValue()));
        threshold = (int) thresholdSlider.getValue();

    }
}
