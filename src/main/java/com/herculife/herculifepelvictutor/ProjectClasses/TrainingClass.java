package com.herculife.herculifepelvictutor.ProjectClasses;

import com.herculife.herculifepelvictutor.ProjectSettings.Strings;
import com.herculife.herculifepelvictutor.ProjectSettings.Time_Stamp;

import java.util.ArrayList;

public class TrainingClass {
    public static final int BASIC_TRAINING = Strings.BASIC_TRAINING_ID;
    public static final int ADVANCED_TRAINING = Strings.ADVANCE_TRAINING_ID;
    public static final int BLADDER_TRAINING = Strings.BLADDER_TRAINING_ID;
    public static final int STABILITY_TRAINING = Strings.STABILITY_TRAINING_ID;
    //General
    private String timeStamp;
    private long timeStampMillis;
    private int type = -1;
    private ArrayList<Double> rawData = new ArrayList<>();
    //Calculated
    private int relaxationCoordination = 50;
    private int contractionCoordination = 60;
    private int holdingCoordination = 10;
    private int deContractionCoordination = 90;
    private int initialMuscleTone = -1;
    private int finalMuscleTone = -1;
    private int maxMuscleStrength = -1;
    private int muscleStrength = -1;
    //parameters
    private int trainingTarget = -1;
    private int relaxationTime = -1;
    private double contractionTime = -1;
    private double holdingTime = -1;
    private double deContractionTime = -1;
    private int numberOfReps = -1;
    private int numberOfSets = -1;
    private int pausesBetweenSets = -1;
    private int difficultyLevel = -1;
    private double trainingTime;
    private String trainingTimeText;
    private String surveyAnswer1 = "";
    private int surveyAnswer2 = -1;

    public TrainingClass() {
        timeStamp = new Time_Stamp().getFullTimeAndDate();
        timeStampMillis = new Time_Stamp().getSystemMillis();
    }

    public void setTrainingParameters(int type, int target, int relaxT, double contraT, double holdT,
                                      double decontraT, int reps, int sets, int pauses, int defL, double trainingTimeInSec) {
        this.type = type;
        this.trainingTarget = target;
        this.relaxationTime = relaxT;
        this.contractionTime = contraT;
        this.holdingTime = holdT;
        this.deContractionTime = decontraT;
        this.numberOfReps = reps;
        this.numberOfSets = sets;
        this.pausesBetweenSets = pauses;
        this.difficultyLevel = defL;
        this.trainingTime = trainingTimeInSec;
        convertSecToMin(trainingTimeInSec);
    }

    public void setSurveyAnswers(String answer1, int answer2) {
        this.surveyAnswer1 = answer1;
        this.surveyAnswer2 = answer2;
    }

    private void convertSecToMin(double trainingTimeInSec) {
        if (trainingTimeInSec > 60) {
            int temp = (int) (trainingTimeInSec / 60);
            int remain = (int) (trainingTimeInSec % 60);
            this.trainingTimeText = temp + " min " + remain + " sec";
        } else {
            this.trainingTimeText = trainingTimeInSec + " sec";
        }
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getTimeStampMillis() {
        return timeStampMillis;
    }

    public void setTimeStampMillis(long timeStampMillis) {
        this.timeStampMillis = timeStampMillis;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRelaxationCoordination() {
        return relaxationCoordination;
    }

    public void setRelaxationCoordination(int relaxationCoordination) {
        this.relaxationCoordination = relaxationCoordination;
    }

    public int getContractionCoordination() {
        return contractionCoordination;
    }

    public void setContractionCoordination(int contractionCoordination) {
        this.contractionCoordination = contractionCoordination;
    }

    public int getHoldingCoordination() {
        return holdingCoordination;
    }

    public void setHoldingCoordination(int holdingCoordination) {
        this.holdingCoordination = holdingCoordination;
    }

    public int getDeContractionCoordination() {
        return deContractionCoordination;
    }

    public void setDeContractionCoordination(int deContractionCoordination) {
        this.deContractionCoordination = deContractionCoordination;
    }

    public int getInitialMuscleTone() {
        return initialMuscleTone;
    }

    public void setInitialMuscleTone(int initialMuscleTone) {
        this.initialMuscleTone = initialMuscleTone;
    }

    public int getFinalMuscleTone() {
        return finalMuscleTone;
    }

    public void setFinalMuscleTone(int finalMuscleTone) {
        this.finalMuscleTone = finalMuscleTone;
    }

    public int getMaxMuscleStrength() {
        return maxMuscleStrength;
    }

    public void setMaxMuscleStrength(int maxMuscleStrength) {
        this.maxMuscleStrength = maxMuscleStrength;
    }

    public int getMuscleStrength() {
        return muscleStrength;
    }

    public void setMuscleStrength(int muscleStrength) {
        this.muscleStrength = muscleStrength;
    }

    public int getTrainingTarget() {
        return trainingTarget;
    }

    public void setTrainingTarget(int trainingTarget) {
        this.trainingTarget = trainingTarget;
    }

    public int getRelaxationTime() {
        return relaxationTime;
    }

    public void setRelaxationTime(int relaxationTime) {
        relaxationTime = relaxationTime;
    }

    public double getContractionTime() {
        return contractionTime;
    }

    public void setContractionTime(double contractionTime) {
        this.contractionTime = contractionTime;
    }

    public double getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(double holdingTime) {
        this.holdingTime = holdingTime;
    }

    public double getDeContractionTime() {
        return deContractionTime;
    }

    public void setDeContractionTime(double deContractionTime) {
        this.deContractionTime = deContractionTime;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(int numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public int getPausesBetweenSets() {
        return pausesBetweenSets;
    }

    public void setPausesBetweenSets(int pausesBetweenSets) {
        this.pausesBetweenSets = pausesBetweenSets;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getSurveyAnswer1() {
        return surveyAnswer1;
    }

    public void setSurveyAnswer1(String surveyAnswer1) {
        this.surveyAnswer1 = surveyAnswer1;
    }

    public int getSurveyAnswer2() {
        return surveyAnswer2;
    }

    public void setSurveyAnswer2(int surveyAnswer2) {
        this.surveyAnswer2 = surveyAnswer2;
    }

    public ArrayList<Double> getRawData() {
        return rawData;
    }

    public void setRawData(ArrayList<Double> rawData) {
        this.rawData = rawData;
    }

    public void addToRawData(double e) {
        this.rawData.add(e);
    }

    public double getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(double trainingTime) {
        this.trainingTime = trainingTime;
    }

    public String getTrainingTimeText() {
        return trainingTimeText;
    }

    public void setTrainingTimeText(String trainingTimeText) {
        this.trainingTimeText = trainingTimeText;
    }

    @Override
    public String toString() {
        return "Training{" +
                "timeStamp='" + timeStamp + '\'' +
                ", timeStampMillis=" + timeStampMillis +
                ", type=" + type +
                ", rawData=" + rawData +
                ", relaxationCoordination=" + relaxationCoordination +
                ", contractionCoordination=" + contractionCoordination +
                ", holdingCoordination=" + holdingCoordination +
                ", deContractionCoordination=" + deContractionCoordination +
                ", initialMuscleTone=" + initialMuscleTone +
                ", finalMuscleTone=" + finalMuscleTone +
                ", maxMuscleStrength=" + maxMuscleStrength +
                ", muscleStrength=" + muscleStrength +
                ", trainingTarget=" + trainingTarget +
                ", relaxationTime=" + relaxationTime +
                ", contractionTime=" + contractionTime +
                ", holdingTime=" + holdingTime +
                ", deContractionTime=" + deContractionTime +
                ", numberOfReps=" + numberOfReps +
                ", numberOfSets=" + numberOfSets +
                ", pausesBetweenSets=" + pausesBetweenSets +
                ", difficultyLevel=" + difficultyLevel +
                ", trainingTime=" + trainingTime +
                ", trainingTimeText='" + trainingTimeText + '\'' +
                ", surveyAnswer1='" + surveyAnswer1 + '\'' +
                ", surveyAnswer2=" + surveyAnswer2 +
                '}';
    }
}
