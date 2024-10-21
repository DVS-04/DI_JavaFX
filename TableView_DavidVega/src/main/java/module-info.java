module es.ieslosmontecillos.tableview_davidvega {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.tableview_davidvega to javafx.fxml;
    exports es.ieslosmontecillos.tableview_davidvega;
}