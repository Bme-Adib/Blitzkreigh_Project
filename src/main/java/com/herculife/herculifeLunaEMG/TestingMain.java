package com.herculife.herculifeLunaEMG;

import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;

public class TestingMain {

    public static void main(String[] args) {
        new MyGoTo().startTimer("Timer 1", 125);

        new MyGoTo().startTimer("Timer 2", 35);
    }
}