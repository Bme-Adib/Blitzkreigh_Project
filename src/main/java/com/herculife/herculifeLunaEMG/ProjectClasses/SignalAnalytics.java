package com.herculife.herculifeLunaEMG.ProjectClasses;

import java.util.ArrayList;

public class SignalAnalytics {
    private int n;
    private int sampleRate;
    private double duration;
    private double highestValue;
    private double lowestValue;

    private double average;

    private ArrayList<ChartPoint> allHighestPoints;
    private ArrayList<ChartPoint> allLowestPoints;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getHighestValue() {
        return highestValue;
    }

    public void setHighestValue(double highestValue) {
        this.highestValue = highestValue;
    }

    public double getLowestValue() {
        return lowestValue;
    }

    public void setLowestValue(double lowestValue) {
        this.lowestValue = lowestValue;
    }

    public ArrayList<ChartPoint> getAllHighestPoints() {
        return allHighestPoints;
    }

    public void setAllHighestPoints(ArrayList<ChartPoint> allHighestPoints) {
        this.allHighestPoints = allHighestPoints;
    }

    public ArrayList<ChartPoint> getAllLowestPoints() {
        return allLowestPoints;
    }

    public void setAllLowestPoints(ArrayList<ChartPoint> allLowestPoints) {
        this.allLowestPoints = allLowestPoints;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "SignalAnalytics\n" +
                "{\n" +
                "n=" + n + " Samples\n" +
                "sampleRate = " + sampleRate + " Hz\n" +
                "duration = " + duration + " Seconds\n" +
                "highestValue = " + highestValue + " μv\n" +
                "lowestValue = " + lowestValue + " μv\n" +
                "average = " + average + " μv\n" +
                "}";
    }
}
