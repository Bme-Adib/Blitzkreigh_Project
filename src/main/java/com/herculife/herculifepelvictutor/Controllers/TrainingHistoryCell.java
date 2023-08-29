package com.herculife.herculifepelvictutor.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.FxmlPre;

public class TrainingHistoryCell {

    public static final String RESOURCE_NAME = FxmlPre + "TrainingHistoryCell.fxml";

    private String trainingDateText;
    private String trainingTypeText;

    @FXML
    private AnchorPane CellBackground;

    @FXML
    private AnchorPane MainCell;

    @FXML
    private CheckBox printPDF;

    @FXML
    private Label trainingDate;

    @FXML
    private Label trainingType;

    public TrainingHistoryCell() {
    }

    public TrainingHistoryCell(String date, String type) {
        this.trainingDate.setText(date);
        this.trainingType.setText(type);
    }

    public String getTrainingDateText() {
        return trainingDateText;
    }

    public void setTrainingDateText(String trainingDateText) {
        this.trainingDateText = trainingDateText;
    }

    public String getTrainingTypeText() {
        return trainingTypeText;
    }

    public void setTrainingTypeText(String trainingTypeText) {
        this.trainingTypeText = trainingTypeText;
    }

    public void setValues(String date,String type){
        trainingDate.setText(date);
        trainingType.setText(type);
    }

    public boolean isCellChecked(){
        return printPDF.isSelected();
    }

}
