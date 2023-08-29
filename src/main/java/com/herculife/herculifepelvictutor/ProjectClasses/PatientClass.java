package com.herculife.herculifepelvictutor.ProjectClasses;

import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import com.herculife.herculifepelvictutor.ProjectSettings.Time_Stamp;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientClass implements Serializable {
    ArrayList<TrainingClass> trainingClasses = new ArrayList<>();
    private String patientUniqueID = "N/A";
    private String mrn = "N/A";
    private String patientID = "N/A";
    private String firstName = "N/A";
    private String lastName = "N/A";
    private String fullName = "N/A";
    private String gender = "N/A";
    private String dob = "N/A";
    private String dobDay = "N/A";
    private String dobMonth = "N/A";
    private String dobYear = "N/A";
    private String nationality = "N/A";
    private String email = "N/A";
    private String phoneNumber = "N/A";
    private String prePhoneNumber = "N/A";
    private String fullPhoneNumber = "N/A";
    private String createdTimeAndDate = "N/A";

    public PatientClass() {
    }

    public PatientClass(String patientID, String firstName, String lastName, String gender, String dob, String nationality) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
    }

    public void continueCreating() {
        generateUniqueIDAndTimeStamp();
        amendFullName();
        amendFullPhoneNumber();
        amendFullDOB();
    }

    public String amendFullDOB() {
        this.dob = dobDay + "/" + dobMonth + "/" + dobYear;
        return dob;
    }

    public String generateUniqueIDAndTimeStamp() {
        this.createdTimeAndDate = new Time_Stamp().getFullTimeAndDate();
        this.patientUniqueID = MyGoTo.hashing(firstName + lastName + dob);
        return patientUniqueID;
    }

    public String amendFullName() {
        this.fullName = firstName + " " + lastName;
        return fullName;
    }

    public String amendFullPhoneNumber() {
        if (phoneNumber.equals("N/A")) {
            this.fullPhoneNumber = "N/A";
        } else {
            this.fullPhoneNumber = prePhoneNumber + " " + phoneNumber;
        }
        return fullPhoneNumber;

    }

    public ArrayList<TrainingClass> addTraining(TrainingClass training) {
        this.trainingClasses.add(training);
        return this.trainingClasses;
    }


    public void setContactInfo(String email, String phoneNumber, String prePhoneNumber) {
        if (!email.isEmpty()) {
            this.email = email;
        }
        if (!phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
        if (!prePhoneNumber.isEmpty()) {
            this.prePhoneNumber = prePhoneNumber;
        }
    }

    public String getPatientUniqueID() {
        return patientUniqueID;
    }

    public void setPatientUniqueID(String patientUniqueID) {
        this.patientUniqueID = patientUniqueID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<TrainingClass> getTrainings() {
        return trainingClasses;
    }

    public void setTrainings(ArrayList<TrainingClass> trainings) {
        this.trainingClasses = trainings;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrePhoneNumber() {
        return prePhoneNumber;
    }

    public void setPrePhoneNumber(String prePhoneNumber) {
        this.prePhoneNumber = prePhoneNumber;
    }

    public String getDobDay() {
        return dobDay;
    }

    public void setDobDay(String dobDay) {
        this.dobDay = dobDay;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public void setDobMonth(String dobMonth) {
        this.dobMonth = dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public void setDobYear(String dobYear) {
        this.dobYear = dobYear;
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    @Override
    public String toString() {
        return "PatientClass{" +
                "patientUniqueID='" + patientUniqueID + '\'' +
                ", mrn='" + mrn + '\'' +
                ", patientID='" + patientID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", dobDay='" + dobDay + '\'' +
                ", dobMonth='" + dobMonth + '\'' +
                ", dobYear='" + dobYear + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", prePhoneNumber='" + prePhoneNumber + '\'' +
                ", trainings=" + trainingClasses +
                '}';
    }

    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    public String getCreatedTimeAndDate() {
        return createdTimeAndDate;
    }

    public void setCreatedTimeAndDate(String createdTimeAndDate) {
        this.createdTimeAndDate = createdTimeAndDate;
    }
}
