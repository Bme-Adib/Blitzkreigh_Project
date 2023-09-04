package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.ProjectClasses.UserClass;
import com.herculife.herculifeLunaEMG.ProjectSettings.MYSQL;
import com.herculife.herculifeLunaEMG.ProjectSettings.MyGoTo;
import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.ErrorLogIn;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;

public class SplashController implements Initializable {
    public static final String RESOURCE_NAME = FxmlPre + "SplashView.fxml";
    public static UserClass ActiveUser;
    private ArrayList<UserClass> users = new ArrayList<>();
    @FXML
    private ImageView splashLogo;

    @FXML
    private PasswordField splashPassword;

    @FXML
    private TextField splashUserName;

    @FXML
    private Label splashErrorLabel;
    @FXML
    private Label TradeMarkText;

    @FXML
    void exitButtonAction() {
        MyGoTo.exitApp(SplashController.class);
    }

    @FXML
    void fileMenu_CloseAction() {
        MyGoTo.exitApp(SplashController.class);
    }

    @FXML
    void splashLogInKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            logIN();
        }
    }


    @FXML
    void splashLogInMouse() {
        logIN();
    }

    private void logIN() {
        splashErrorLabel.setVisible(false);
        String username = splashUserName.getText().trim().toLowerCase();
        String password = splashPassword.getText().trim().toLowerCase();
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().toLowerCase().equals(username)) {
                if (users.get(i).getPassword().equals(password)) {
                    ActiveUser = users.get(i);
                    new MyGoTo().changeSceneTo(UserListController.RESOURCE_NAME);
//                    new MyGoTo().changeSceneTo(PostTrainingDashboard.RESOURCE_NAME);
                    break;
                }
            }
        }
        if (!found) {
            splashErrorLabel.setText("Username or Password is Invalid");
            splashErrorLabel.setVisible(true);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);
        try {
            MYSQL mysql = new MYSQL();
            users = mysql.readAllUsersFromDB();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Image logo = new Image("herculife.png");
        splashLogo.setImage(logo);
        splashErrorLabel.setText(ErrorLogIn);
        splashErrorLabel.setVisible(false);

        test();
    }

    private void test() {

    }

    @FXML
    void helpDesk() {

    }

    @FXML
    void tutorialCreateNewPatient() {

    }

    @FXML
    void tutorialSetUpParameters() {

    }

    @FXML
    void aboutPelvicTutorPopUp() {
        new MyGoTo().popUpScene(AboutPelvicTutor.RESOURCE_NAME);
    }
}
