module es.ieslosmontecillos.helloworld_vegadavid {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.helloworld_vegadavid to javafx.fxml;
    exports es.ieslosmontecillos.helloworld_vegadavid;
}