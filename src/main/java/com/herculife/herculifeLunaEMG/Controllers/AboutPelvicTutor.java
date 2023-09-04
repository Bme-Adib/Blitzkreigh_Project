package com.herculife.herculifeLunaEMG.Controllers;

import com.herculife.herculifeLunaEMG.ProjectSettings.Strings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.AboutPelvicPopUp;
import static com.herculife.herculifeLunaEMG.ProjectSettings.Strings.FxmlPre;

public class AboutPelvicTutor implements Initializable {
    public static final String RESOURCE_NAME = FxmlPre + "AboutPelvicTutor.fxml";
    @FXML
    private Label TradeMarkText;

    @FXML
    private AnchorPane root;

    @FXML
    private TextArea aboutTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TradeMarkText.setText(Strings.TradeMarkText);

        aboutTextField.setText(AboutPelvicPopUp);
    }

}
