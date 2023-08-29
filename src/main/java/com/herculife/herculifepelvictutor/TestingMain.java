package com.herculife.herculifepelvictutor;

import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;

public class TestingMain {

    public static void main(String[] args) {
        new MyGoTo().startTimer("Timer 1", 125);

        new MyGoTo().startTimer("Timer 2", 35);
    }
}