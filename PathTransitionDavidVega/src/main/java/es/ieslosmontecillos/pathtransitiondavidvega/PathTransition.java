package es.ieslosmontecillos.pathtransitiondavidvega;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Path;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransition extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea un círculo que actuará como la ruta
        Circle circulo = new Circle(150, 150, 100); // Centro (150, 150), radio 100
        circulo.setFill(Color.TRANSPARENT);
        circulo.setStroke(Color.BLACK);

        // Crea un rectángulo que se moverá a lo largo del círculo
        Rectangle rectangulo = new Rectangle(40, 20, Color.YELLOW);

        // Crea un PathTransition para animar el rectángulo a lo largo de la ruta del círculo
        javafx.animation.PathTransition pathTransition = new javafx.animation.PathTransition();
        pathTransition.setRate(1); // Velocidad normal
        pathTransition.setCycleCount(javafx.animation.PathTransition.INDEFINITE); // Repetir indefinidamente
        pathTransition.setAutoReverse(false); // No reversar
        pathTransition.setDuration(Duration.millis(4000)); // Duración de 4000 ms

        // Definir la ruta que será el círculo
        Path path = new Path();
        path.getElements().add(new MoveTo(150, 50)); // Inicio en la parte superior del círculo
        for (int angle = 0; angle <= 360; angle++) {
            double rad = Math.toRadians(angle);
            double x = 150 + 100 * Math.cos(rad);
            double y = 150 + 100 * Math.sin(rad);
            path.getElements().add(new LineTo(x, y)); // Crear línea hasta el siguiente punto
        }

        pathTransition.setPath(path); // Asignar la ruta al PathTransition
        pathTransition.setNode(rectangulo); // Asignar el nodo que se moverá
        pathTransition.play(); // Iniciar la animación

        // Manejar eventos de mouse para pausar y reanudar la animación
        circulo.setOnMousePressed((MouseEvent event) -> {
            pathTransition.pause(); // Pausar la animación
        });

        circulo.setOnMouseReleased((MouseEvent event) -> {
            pathTransition.play(); // Reanudar la animación
        });

        // Crear un contenedor Pane y agregar el círculo y el rectángulo
        Pane root = new Pane();
        root.getChildren().addAll(circulo, rectangulo);

        // Crear la escena
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Animación Círculo y Rectángulo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
