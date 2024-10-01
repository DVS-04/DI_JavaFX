module es.ieslosmontecillos.fancyform_vegadavid {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.fancyform_vegadavid to javafx.fxml;
    exports es.ieslosmontecillos.fancyform_vegadavid;
}