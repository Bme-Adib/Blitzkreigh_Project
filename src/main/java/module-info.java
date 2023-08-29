module com.herculife.herculifepelvictutor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires mysql.connector.j;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires aes.everywhere.java;

    opens com.herculife.herculifepelvictutor to javafx.fxml;
    exports com.herculife.herculifepelvictutor;

    opens com.herculife.herculifepelvictutor.Controllers to javafx.fxml;
    exports com.herculife.herculifepelvictutor.Controllers;

    opens com.herculife.herculifepelvictutor.ProjectSettings to javafx.fxml;
    exports com.herculife.herculifepelvictutor.ProjectSettings;

    opens com.herculife.herculifepelvictutor.ProjectClasses to javafx.fxml;
    exports com.herculife.herculifepelvictutor.ProjectClasses;
    exports com.herculife.herculifepelvictutor.Controllers.TrainingControllers;
    opens com.herculife.herculifepelvictutor.Controllers.TrainingControllers to javafx.fxml;
}