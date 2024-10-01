module es.ieslosmontecillos.animation_vegadavid {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.animation_vegadavid to javafx.fxml;
    exports es.ieslosmontecillos.animation_vegadavid;
}