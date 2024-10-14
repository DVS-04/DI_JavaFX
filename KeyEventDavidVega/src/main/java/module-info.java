module es.ieslosmontecillos.keyeventdavidvega {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.keyeventdavidvega to javafx.fxml;
    exports es.ieslosmontecillos.keyeventdavidvega;
}