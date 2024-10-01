module es.ieslosmontecillos.form_vegadavid {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.form_vegadavid to javafx.fxml;
    exports es.ieslosmontecillos.form_vegadavid;
}