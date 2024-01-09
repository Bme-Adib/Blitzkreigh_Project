module com.herculife.herculifeLunaEMG {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires mysql.connector.j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires aes.everywhere.java;
    requires com.fazecast.jSerialComm;

    opens com.herculife.herculifeLunaEMG to javafx.fxml;
    exports com.herculife.herculifeLunaEMG;

    opens com.herculife.herculifeLunaEMG.Controllers to javafx.fxml;
    exports com.herculife.herculifeLunaEMG.Controllers;

    opens com.herculife.herculifeLunaEMG.ProjectSettings to javafx.fxml;
    exports com.herculife.herculifeLunaEMG.ProjectSettings;

    opens com.herculife.herculifeLunaEMG.ProjectClasses to javafx.fxml;
    exports com.herculife.herculifeLunaEMG.ProjectClasses;
    exports com.herculife.herculifeLunaEMG.Controllers.TrainingControllers;
    opens com.herculife.herculifeLunaEMG.Controllers.TrainingControllers to javafx.fxml;
}