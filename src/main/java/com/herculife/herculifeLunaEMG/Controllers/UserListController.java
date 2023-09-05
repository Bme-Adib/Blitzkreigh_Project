package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.ProjectClasses.PatientClass;
import com.herculife.herculifeLunaEMG.ProjectSettings.MYSQL;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.Controllers.SplashController.ActiveUser;
import static com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo.convertObjectToJson;
import static com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo.encrypt;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;


public class UserListController implements Initializable {
    public static final String RESOURCE_NAME = FxmlPre + "UserList.fxml";
    private static final HashMap<String, String> patientsEncryption = new HashMap<>();
    public static PatientClass selectedPatient;
    public static String selectedPatientDataString;
    @FXML
    private Label TradeMarkText;
    @FXML
    private Button createNewPatient;
    @FXML
    private AnchorPane confirmDeletePanel;
    @FXML
    private Label confirmLabel;
    @FXML
    private Button confirmNo;
    @FXML
    private Button confirmYes;
    @FXML
    private Button exitButton;

    @FXML
    private TableView<PatientClass> patientsTable;
    @FXML
    private TableColumn<PatientClass, String> patientTable_id;
    @FXML
    private TableColumn<PatientClass, String> patientTable_mrn;
    @FXML
    private TableColumn<PatientClass, String> patientTable_dob;
    @FXML
    private TableColumn<PatientClass, String> patientTable_fName;
    @FXML
    private TableColumn<PatientClass, String> patientTable_gender;
    @FXML
    private TableColumn<PatientClass, String> patientTable_lName;
    @FXML
    private TableColumn<PatientClass, String> patientTable_nationality;
    @FXML
    private TableColumn<PatientClass, String> patientTable_no;
    @FXML
    private Button selectPatient;
    private ArrayList<PatientClass> allPatients;
    private PatientClass deleteIndex;
    private String Adib="";

    @FXML
    void createNewPatientButton(MouseEvent event) {
        new MyGoTo().changeSceneTo(CreateNewPatient.RESOURCE_NAME);
    }

    @FXML
    void selectPatientButton(MouseEvent event) throws Exception {
        selectedPatient = allPatients.get(patientsTable.getSelectionModel().getSelectedIndex());
        selectedPatientDataString = encrypt(convertObjectToJson(selectedPatient));
        new MyGoTo().changeSceneTo(MainPatientDashboard.RESOURCE_NAME);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);
        confirmDeletePanel.setVisible(false);
        setTable();
        getPatientsList();
        patientsTable.getSelectionModel().clearAndSelect(patientsTable.getItems().size() - 1);
        patientsTable.setPlaceholder(new Label("No Users in Database"));
    }

    private void setTable() {

    }

    private void getPatientsList() {
        patientsTable.getItems().clear();
        patientTable_no.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PatientClass, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PatientClass, String> patientClassStringCellDataFeatures) {
                return new ReadOnlyObjectWrapper(patientsTable.getItems().indexOf(patientClassStringCellDataFeatures.getValue()) + 1);
            }
        });
        patientTable_id.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("patientID"));
        patientTable_mrn.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("mrn"));
        patientTable_fName.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("firstName"));
        patientTable_lName.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("lastName"));
        patientTable_gender.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("gender"));
        patientTable_nationality.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("nationality"));
        patientTable_dob.setCellValueFactory(new PropertyValueFactory<PatientClass, String>("dob"));

        ObservableList<PatientClass> patientObservableList = patientsTable.getItems();

        allPatients = new ArrayList<>();
//        for (int i=0;i<60;i++){
//            allPatients.add(new PatientClass());
//        }
//        patientObservableList.addAll(allPatients);
        try {
            MYSQL mysql = new MYSQL();
            allPatients = mysql.readAllPatientsFromDB(patientsEncryption);
            patientObservableList.addAll(allPatients);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        patientsTable.setItems(patientObservableList);

    }

    @FXML
    void confirmNoFunction() {
        confirmDeletePanel.setVisible(false);
    }

    @FXML
    void confirmYesFunction() {
        try {
            MYSQL mysql = new MYSQL();
            mysql.deletePatientAt(patientsEncryption.get(deleteIndex.getPatientUniqueID()));
            getPatientsList();
            confirmDeletePanel.setVisible(false);
            MyGoTo.logIt(0, "User: " + ActiveUser.getName() + " Deleted the patient (" + deleteIndex.getFullName() + ")", UserListController.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void deletePatientFunction() throws Exception {

        deleteIndex = patientsTable.getSelectionModel().getSelectedItem();
        confirmLabel.setText("Confirm deleting user (" + patientsTable.getSelectionModel().getSelectedItem().getFullName() + ")");
        confirmDeletePanel.setVisible(true);
    }


    @FXML
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(UserListController.class);
    }

    @FXML
    void helpDesk(ActionEvent event) {

    }

    @FXML
    void tutorialCreateNewPatient(ActionEvent event) {

    }

    @FXML
    void tutorialSetUpParameters(ActionEvent event) {

    }

    @FXML
    void aboutLunaEMGPopUp(ActionEvent event) {
        new MyGoTo().popUpScene(AboutLunaEMG.RESOURCE_NAME);
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(UserListController.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(UserListController.class);
    }
}
