package com.herculife.herculifeLunaEMG.Controllers;


import java.io.IOException;
import java.io.InputStream;
import com.fazecast.jSerialComm.*;

public class Arduino {

    public static void main(String[] args) {
        // Find and open the serial port (modify portName and baud rate according to your setup)
        String portName = "COM5"; // Change to your port name (e.g., COM3, /dev/ttyUSB0, etc.)
        int baudRate = 9600; // Change to match the baud rate set in your Arduino code

        SerialPort serialPort = SerialPort.getCommPort(portName);
        serialPort.setBaudRate(baudRate);

        if (serialPort.openPort()) {
            System.out.println("Serial port opened successfully.");

            // Get input stream from the serial port
            InputStream inputStream = serialPort.getInputStream();

            try {
                // Read data from the serial port
                while (true) {
                    if (inputStream.available() > 0) {
                        int data = inputStream.read();
                        System.out.print((char) data); // Assuming ASCII data; you can process as needed
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to open the serial port.");
        }
    }
}