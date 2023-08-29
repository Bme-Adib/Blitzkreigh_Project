package com.herculife.herculifepelvictutor.Controllers;

import com.herculife.herculifepelvictutor.ProjectClasses.PatientClass;
import com.herculife.herculifepelvictutor.ProjectSettings.CountryList;
import com.herculife.herculifepelvictutor.ProjectSettings.MYSQL;
import com.herculife.herculifepelvictutor.ProjectSettings.MyGoTo;
import com.herculife.herculifepelvictutor.ProjectSettings.Strings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.validation.ValidationSupport;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static com.herculife.herculifepelvictutor.ProjectSettings.Strings.FxmlPre;

public class CreateNewPatient implements Initializable {

    public static final String RESOURCE_NAME = FxmlPre + "CreateNewPatient.fxml";
    private ValidationSupport validationSupport;
    private final PatientClass patient = new PatientClass();

    @FXML
    private Label TradeMarkText;

    @FXML
    private Button createNewPatientAdd;

    @FXML
    private DatePicker createNewPatientDOB;

    @FXML
    private TextField createNewPatientEmail;

    @FXML
    private Label createNewPatientError;

    @FXML
    private TextField createNewPatientID;
    @FXML
    private TextField createNewPatientMRN;
    @FXML
    private TextField createNewPatientFirstName;

    @FXML
    private TextField createNewPatientLastName;

    @FXML
    private ImageView createNewPatientLogo;

    @FXML
    private ComboBox<String> createNewPatientNationality;

    @FXML
    private TextField createNewPatientPhoneNumber;

    @FXML
    private ComboBox<String> createNewPatientPhoneNumberPre;

    @FXML
    private Button exitButton;

    @FXML
    private MenuItem fileMenu_Close;

    @FXML
    private ToggleButton femaleToggle;

    @FXML
    private ToggleButton maleToggle;

    @FXML
    void createNewPatientAddFunction(MouseEvent event) {
        String errorMsg = "";
        String errorMsg2 = "";
        createNewPatientError.setText("");

        if (!createNewPatientEmail.getText().isEmpty()) {
            if (createNewPatientEmail.getText().contains("@") && createNewPatientEmail.getText().contains(".")) {
                patient.setEmail(createNewPatientEmail.getText().trim());
            } else {
                errorMsg += "Please Use Valid Email\n";
            }
        }

        if (!createNewPatientPhoneNumber.getText().isEmpty()) {
            patient.setPhoneNumber(createNewPatientPhoneNumber.getText().trim());
            patient.setPrePhoneNumber(createNewPatientPhoneNumberPre.getSelectionModel().getSelectedItem());
        }
        patient.amendFullPhoneNumber();

        if (femaleToggle.isSelected()) {
            patient.setGender("Female");
        } else {
            patient.setGender("Male");
        }
        if (createNewPatientNationality.getSelectionModel().getSelectedIndex() == 0) {
            errorMsg2 = "Please Fill all required fields";
        } else {
            patient.setNationality(createNewPatientNationality.getSelectionModel().getSelectedItem());
        }


        if (!createNewPatientFirstName.getText().isEmpty()) {
            patient.setFirstName(createNewPatientFirstName.getText().trim());
        } else {
            errorMsg2 = "Please Fill all required fields";
        }
        if (!createNewPatientLastName.getText().isEmpty()) {
            patient.setLastName(createNewPatientLastName.getText().trim());
        } else {
            errorMsg2 = "Please Fill all required fields";
        }
        if (!createNewPatientDOB.getEditor().getText().isEmpty()) {
            LocalDate localDate = createNewPatientDOB.getValue();
            patient.setDobDay(localDate.format(DateTimeFormatter.ofPattern("dd")));
            patient.setDobMonth(localDate.format(DateTimeFormatter.ofPattern("MM")));
            patient.setDobYear(localDate.format(DateTimeFormatter.ofPattern("yyyy")));
            patient.setDob(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            errorMsg2 = "Please Fill all required fields";
        }

        if (!createNewPatientID.getText().isEmpty()) {
            patient.setPatientID(createNewPatientID.getText().trim());
        } else {
            errorMsg2 = "Please Fill all required fields";
        }
        if (!createNewPatientMRN.getText().isEmpty()) {
            patient.setMrn(createNewPatientMRN.getText().trim());
        }
        createNewPatientError.setText(errorMsg2 + errorMsg);
        createNewPatientError.setText(errorMsg2 + errorMsg);
        if (errorMsg.isEmpty() && errorMsg2.isEmpty()) {
            CreatePatient();
        }

    }

    private void CreatePatient() {
        patient.amendFullName();
        patient.generateUniqueIDAndTimeStamp();
        try {
            if (new MYSQL().writePatientToDB(patient)) {
                MyGoTo.logIt(0, MyGoTo.LOG_NewPatient + patient.getPatientUniqueID() + ")", CreateNewPatient.class);
                new MyGoTo().changeSceneTo(UserListController.RESOURCE_NAME);
            } else {
                createNewPatientError.setText("Error while creating new patient");
                MyGoTo.logIt(1, "Error while creating new patient", CreateNewPatient.class);
            }
        } catch (Exception e) {
            MyGoTo.logIt(1, e.getMessage(), CreateNewPatient.class);
            throw new RuntimeException(e);
        }
    }


    @FXML
    void goBackButton(MouseEvent event) {
        new MyGoTo().changeSceneTo(UserListController.RESOURCE_NAME);
    }

    @FXML
    void exitButtonAction(MouseEvent event) {
        MyGoTo.exitApp(CreateNewPatient.class);
    }

    @FXML
    void fileMenu_CloseAction(ActionEvent event) {
        MyGoTo.exitApp(CreateNewPatient.class);
    }

    @FXML
    void CreateNewPatientNationalityChanged(ActionEvent event) {
        int index = createNewPatientNationality.getSelectionModel().getSelectedIndex();
        createNewPatientPhoneNumberPre.getSelectionModel().select(index);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //General
        TradeMarkText.setText(Strings.TradeMarkText);
        Image logo = new Image("herculife.png");
        createNewPatientLogo.setImage(logo);
        createNewPatientError.setText("");

        //Specific

        createNewPatientNationality.setItems(new CountryList().getCountries());
        createNewPatientNationality.getSelectionModel().select(0);

        createNewPatientPhoneNumberPre.setItems(new CountryList().getCountriesCode());
        createNewPatientPhoneNumberPre.getSelectionModel().select(0);


        maleToggle.setSelected(true);

        maleToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                femaleToggle.setSelected(!t1);
            }
        });

        femaleToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                maleToggle.setSelected(!t1);
            }
        });

        createNewPatientPhoneNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    createNewPatientPhoneNumber.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
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
    void aboutPelvicTutorPopUp(ActionEvent event) {
        new MyGoTo().popUpScene(AboutPelvicTutor.RESOURCE_NAME);
    }

    @FXML
    void fileMenu_logOut(ActionEvent event) {
        new MyGoTo().logOut(CreateNewPatient.class);
    }
}
