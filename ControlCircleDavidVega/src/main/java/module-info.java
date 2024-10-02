module es.ieslosmontecillos.controlcircledavidvega {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.controlcircledavidvega to javafx.fxml;
    exports es.ieslosmontecillos.controlcircledavidvega;
}