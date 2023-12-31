package com.herculife.herculifeLunaEMG.ProjectSettings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mervick.aes_everywhere.Aes256;
import com.herculife.herculifeLunaEMG.Controllers.SplashController;
import com.herculife.herculifeLunaEMG.ProjectClasses.ChartPoint;
import com.herculife.herculifeLunaEMG.ProjectClasses.SignalAnalytics;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.herculife.herculifeLunaEMG.Controllers.SplashController.ActiveUser;
import static com.herculife.herculifeLunaEMG.HerculifeLunaEMGApplication.MainStage;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.*;


public class MyGoTo {

    // Function to write data to a file
    public static final int GENERAL_LOG = 0;
    public static final int ERROR_LOG = 1;
    public static final String LOG_NewPatient = "New Patient added to the database (";
    private static final String SECRET_KEY = "Adib Ghannam"; //

    public static void exitApp(Class c) {
        if (c == SplashController.class) {
            System.exit(0);
        } else {
            MyGoTo.logIt(0, "User: " + ActiveUser.getName() + " Closed the App Correctly", c);
            System.exit(0);
        }


    }

    public static String hashing(String ID) {
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(ID.getBytes(StandardCharsets.UTF_8));
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        String b = hexString.toString();
        StringBuilder b2 = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            b2.append(b.charAt(63 - i));
        }
        String b3 = b2.substring(32) + b2.substring(0, 32);
        // H1+ H2        -->    // H2 + H1
        // Q1+Q2+Q3+Q4   -->    // Q4+Q3+Q2+Q1
        return b3.substring(48) + b3.substring(32, 48) + b3.substring(16, 32) + b3.substring(0, 16);
    }

    public static void logIt(int type, String data, Class c) {
        String typeName = "";
        String fileName = "";
        switch (type) {
            case 0 -> {
                fileName = "HerculifeLunaEMG.log";
                typeName = "LOG";
            }
            case 1 -> {
                fileName = "Error.log";
                typeName = "Error";
            }
        }

        String s = new Time_Stamp().getLogTime() + " , " + typeName + " , " + c.descriptorString().substring(1, c.descriptorString().length() - 1)
                + " , " + data + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logIt(int type, String data, String c) {
        String typeName = "";
        String fileName = "";
        switch (type) {
            case 0 -> {
                fileName = "HerculifeLunaEMG.log";
                typeName = "LOG";
            }
            case 1 -> {
                fileName = "Error.log";
                typeName = "Error";
            }
        }

        String s = new Time_Stamp().getLogTime() + " , " + typeName + " , " + c
                + " , " + data + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to read data from a file
    public static String logRead(int type) {
        String fileName = switch (type) {
            case 0 -> "HerculifeLunaEMG.log";
            case 1 -> "Error.log";
            default -> "";
        };
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static String convertObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MyGoTo.logIt(0, "Object converted to Json file", MyGoTo.class);
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            MyGoTo.logIt(1, e.getMessage(), MyGoTo.class);
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MyGoTo.logIt(0, "Json file converted to Object", MyGoTo.class);
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            MyGoTo.logIt(1, e.getMessage(), MyGoTo.class);
            return null;
        }
    }

    public static String encrypt(String toBeEncrypted) throws Exception {
        MyGoTo.logIt(0, "Patient Encryption initiated", MyGoTo.class);
        return Aes256.encrypt(toBeEncrypted, SECRET_KEY);
    }

    public static String decrypt(String toBeDecrypted) throws Exception {
        MyGoTo.logIt(0, "Patient Decryption initiated", MyGoTo.class);
        return Aes256.decrypt(toBeDecrypted, SECRET_KEY);
    }

    public static String printDouble2Decimals(double value) {
        // Create a DecimalFormat object with the desired format
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        return decimalFormat.format(value);
    }

    private static double interpolateY(double targetX, XYChart.Series<Number, Number> series) {
        // Find the nearest data points
        XYChart.Data<Number, Number> lower = null;
        XYChart.Data<Number, Number> upper = null;

        for (XYChart.Data<Number, Number> data : series.getData()) {
            if (data.getXValue().doubleValue() <= targetX) {
                lower = data;
            } else {
                upper = data;
                break;
            }
        }

        // Perform linear interpolation
        double x0 = lower.getXValue().doubleValue();
        double x1 = upper.getXValue().doubleValue();
        double y0 = lower.getYValue().doubleValue();
        double y1 = upper.getYValue().doubleValue();

        return (y0 + (targetX - x0) * (y1 - y0) / (x1 - x0));
    }

    private static int roundUp(double d) {
        return (int) Math.ceil(d);
    }

    public static String twoDecimals(double number) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(number);
    }

    public static double roundDoubleToTwoDecimals(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(number));
    }

    public static boolean isDouble(double number) {
        return number != (int) number;
    }

    public static String returnTrainingType(int i) {
        switch (i) {
            case BASIC_TRAINING_ID -> {
                return "Basic Training";
            }
            case ADVANCE_TRAINING_ID -> {
                return "Advanced Training";
            }
            case STABILITY_TRAINING_ID -> {
                return "Stability Training";
            }
            case BLADDER_TRAINING_ID -> {
                return "Bladder Training";
            }
            default -> {
                return "Training";
            }
        }
    }

    public static SignalAnalytics analyzeTheSignal(ArrayList<ChartPoint> signal, int samplingRate, int threshold) {
        SignalAnalytics signalAnalytics = new SignalAnalytics();
        ArrayList<ChartPoint> allHighest = new ArrayList<>();
        ArrayList<ChartPoint> allLowest = new ArrayList<>();
        signalAnalytics.setN(signal.size());
        signalAnalytics.setSampleRate(samplingRate);
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalSum = 0;
        int aboveThresholdPointsCount = 0;
        for (ChartPoint chartPoint : signal) {
            totalSum += chartPoint.getY();
            if (chartPoint.getY() > high) {
                high = chartPoint.getY();
            }
            if (chartPoint.getY() < low) {
                low = chartPoint.getY();
            }

            if (chartPoint.getY() >= threshold){
                aboveThresholdPointsCount++;
            }
        }

        for (ChartPoint chartPoint : signal) {
            if (chartPoint.getY() == high) {
                allHighest.add(chartPoint);
            }
            if (chartPoint.getY() == low) {
                allLowest.add(chartPoint);
            }
        }
        signalAnalytics.setHighestValue(high);
        signalAnalytics.setLowestValue(low);
        signalAnalytics.setAllHighestPoints(allHighest);
        signalAnalytics.setAllLowestPoints(allLowest);
        signalAnalytics.setAverage(roundDoubleToTwoDecimals(totalSum / signal.size()));
        signalAnalytics.setDuration((double) signal.size() * samplingRate / 1000);
        signalAnalytics.setAbovethresholdPercent(roundDoubleToTwoDecimals((double) aboveThresholdPointsCount /signal.size()*100));
        return signalAnalytics;
    }

    public static void printArrayList(ArrayList<?> arrayList) {
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }

    public static void exportToCSV(ArrayList<ChartPoint> data) {
        try (FileWriter writer = new FileWriter("output.csv")) {
            for (ChartPoint chartPoint : data) {
                writer.append(String.valueOf(chartPoint.getX()));
                writer.append(",");
                writer.append(String.valueOf(chartPoint.getY()));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStageSettings(Stage stage) {
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setTitle(AppName);
        stage.getIcons().add(new Image("appIcon.png"));
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }

    public void logOut(Class c) {
        try {
            logIt(0, "User: " + ActiveUser.getName() + " Signed Out", c);
            Stage stage = MainStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(SplashController.RESOURCE_NAME));
            stage.setScene(new Scene(loader.load()));
            new MyGoTo().setStageSettings(stage);
            stage.show();

        } catch (IOException e) {
            MyGoTo.logIt(1, e.getMessage(), c);
            throw new RuntimeException(e);
        }
    }

    public void changeSceneTo(String resource) {
        try {
            Stage stage = MainStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            stage.setScene(new Scene(loader.load()));
            new MyGoTo().setStageSettings(stage);
            stage.show();
        } catch (IOException e) {
            MyGoTo.logIt(1, e.getMessage(), resource);
            throw new RuntimeException(e);
        }
    }

    public void popUpScene(String resource) {
        try {
            Stage stage = new Stage();
            Parent root = new FXMLLoader(getClass().getResource(resource)).load();
            stage.setScene(new Scene(root, 500, 600));
            stage.setResizable(false);
            stage.setTitle(AppName);
            stage.show();
        } catch (IOException e) {
            MyGoTo.logIt(1, e.getMessage(), resource);
            throw new RuntimeException(e);
        }
    }

    public String convertsSecondsToMinutes(int seconds) {
        if (seconds > 60) {
            int min = seconds / 60;
            double sec = seconds % 60;
            if (isDouble(sec)) {
                return min + " Min " + sec + " seconds";
            } else {
                return min + " Min " + (int) sec + " seconds";
            }
        } else {
            return String.valueOf(seconds);
        }
    }

    public void startTimer(String timerName, int seconds) {
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = seconds; i > 0; i--) {
                        System.out.println(timerName + ": Remaining " + convertsSecondsToMinutes(i));
                        Thread.sleep(1000); // Sleep for 1 second
                    }
                    System.out.println("Time's  up!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start(); // Start the timer thread 0135031707
    }
}
