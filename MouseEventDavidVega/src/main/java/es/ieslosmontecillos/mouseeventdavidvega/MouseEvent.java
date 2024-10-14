package es.ieslosmontecillos.mouseeventdavidvega;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class MouseEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea un objeto de texto
        Text texto = new Text("Programming is fun");
        texto.setX(100); // Posición inicial X
        texto.setY(50); // Posición inicial Y


        // Asigna el evento de arrastre usando expresiones lambda
        texto.setOnMouseDragged((evento) -> {
            // Actualiza la posición del texto según las coordenadas del ratón
            texto.setX(evento.getX());
            texto.setY(evento.getY());
        });

        // Crea un contenedor
        Pane root = new Pane();
        root.getChildren().add(texto);

        // Crea la escena
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setTitle("MouseEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}