package com.herculife.herculifepelvictutor.ProjectSettings;

import com.herculife.herculifepelvictutor.ProjectClasses.PatientClass;
import com.herculife.herculifepelvictutor.ProjectClasses.UserClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo.*;
import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.PELVIC_DATABASE;

public class MYSQL {
    private final String DriverName = "com.mysql.cj.jdbc.Driver";
    private final String SQLUserName = "adib";
    private final String SQLPassword = "815010";
    private final Statement statement;
    private final Connection connection;

    //Function:

    public MYSQL() throws SQLException {
//        Class.forName(DriverName);
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + PELVIC_DATABASE + "?user=" + SQLUserName + "&password=" + SQLPassword + "&zeroDateTimeBehavior=convertToNull");
        this.statement = connection.createStatement();
    }

    public void printResultSet(ResultSet resultSet, boolean header) throws SQLException {
        int DBCCount = resultSet.getMetaData().getColumnCount();
        if (header) {
            System.out.print("Header: ");
            for (int j = 1; j <= DBCCount; j++) {
                System.out.print(resultSet.getMetaData().getColumnName(j) + "\t");
            }
            System.out.println("\n");
        }

        while (resultSet.next()) {
            for (int i = 1; i <= DBCCount; i++) {
                System.out.print(resultSet.getObject(i) + "\t");
            }
            System.out.println();
        }
    }

    public void generalQuery(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        printResultSet(resultSet, true);
    }

    public void updatePatient(String oldData, PatientClass patient) throws Exception {
        String newData = encrypt(convertObjectToJson(patient));
        newData = "'" + newData + "'";
        String SQLQuery = "UPDATE patients SET data=" + newData + " where data='" + oldData + "'";
        System.out.println(SQLQuery);
        PreparedStatement ps = null;
        ps = connection.prepareStatement(SQLQuery);
        int row = 0;
        row = ps.executeUpdate();
        System.out.println("rows changed: " + row);
    }

    public boolean writePatientToDB(PatientClass patient) throws Exception {
        String patientData = encrypt(convertObjectToJson(patient));
        PreparedStatement ps = null;
        String SQLQuery = "insert into patients (data, fullName) values (?,?)";
        ps = connection.prepareStatement(SQLQuery);
        ps.setString(1, patientData);     //data
        ps.setString(2, patient.getFullName());                     //fullName
        int row = 0;
        row = ps.executeUpdate();
        System.out.println("rows changed: " + row);
        if (row != 0) {
            MyGoTo.logIt(0, "new Patient added (" + patient.getPatientUniqueID() + ")", MYSQL.class);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<PatientClass> readPatientFromDB(int index) throws Exception {          //Check size to see if found
        ArrayList<PatientClass> patientClassArrayList = new ArrayList<>();
        PatientClass patient = new PatientClass();
        String SQLQuery = "select * from patients where no=" + index;
        ResultSet resultSet = statement.executeQuery(SQLQuery);
        while (resultSet.next()) {
            patientClassArrayList.add(convertJsonToObject(decrypt(resultSet.getString(3)), PatientClass.class));
        }
        return patientClassArrayList;
    }

    public ArrayList<PatientClass> readAllPatientsFromDB(HashMap<String, String> patientsEncryption) throws Exception {
        ArrayList<PatientClass> patientClassArrayList = new ArrayList<>();

        String SQLQuery = "select * from patients";
        ResultSet resultSet = statement.executeQuery(SQLQuery);
        while (resultSet.next()) {
            patientClassArrayList.add(convertJsonToObject(decrypt(resultSet.getString(3)), PatientClass.class));
            patientsEncryption.put(convertJsonToObject(decrypt(resultSet.getString(3)), PatientClass.class).getPatientUniqueID(), resultSet.getString(3));
        }
        System.out.println("Total Patients: " + patientClassArrayList.size());
        return patientClassArrayList;
    }

    public void deletePatientAt(String index) throws SQLException {
        System.out.println(index);
        statement.execute("delete from patients where data=" + "\"" + index + "\"");
    }

    public ArrayList<UserClass> readAllUsersFromDB() throws Exception {
        ArrayList<UserClass> usersArrayList = new ArrayList<>();

        String SQLQuery = "select * from users";
        ResultSet resultSet = statement.executeQuery(SQLQuery);
        while (resultSet.next()) {
            UserClass userClass = new UserClass(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            usersArrayList.add(userClass);
        }
        return usersArrayList;
    }

}



/*
create database herculife_pelvic_tutor_ag;
use herculife_pelvic_tutor_ag;
create table patients (no int not null auto_increment, fullName varchar(255), data text, primary key (no));
create table users (role varchar(255), name varchar(255), password varchar(255));
insert into users values ('admin','adib','815010');
insert into users values ('user','herculife','herculife');


insert into patients (data, fullName) values (?,?);
delete from patients where no>0;

ALTER TABLE patients MODIFY data varchar(1024);
ALTER TABLE patients RENAME COLUMN id TO no;

ALTER TABLE patients AUTO_INCREMENT = 0;

UPDATE patients SET no=1 where no=3;


CREATE TABLE `user_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
*/