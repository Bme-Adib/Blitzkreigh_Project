package com.herculife.herculifepelvictutor.ProjectSettings;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time_Stamp implements Serializable {

    public String getLogTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd , HH:mm:ss");
        return dateFormat.format(date);
    }

    public String getFullTimeAndDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        return dateFormat.format(date);
    }

    public String getYear() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyy");
        return dateFormat.format(date);
    }

    public long getSystemMillis() {
        return System.currentTimeMillis();
    }

}
