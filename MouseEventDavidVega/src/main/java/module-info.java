module es.ieslosmontecillos.mouseeventdavidvega {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.mouseeventdavidvega to javafx.fxml;
    exports es.ieslosmontecillos.mouseeventdavidvega;
}