package es.ieslosmontecillos.anonymusinnerclassdavidvega;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousInnerClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea los botones
        Button btnNuevo = new Button("Nuevo");
        Button btnAbrir = new Button("Abrir");
        Button btnGuardar = new Button("Guardar");
        Button btnImprimir = new Button("Imprimir");

        // Agrega eventos a cada botón usando clases anónimas
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nuevo Proceso");
            }
        });

        btnAbrir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Abrir proceso");
            }
        });

        btnGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Guardar proceso");
            }
        });

        btnImprimir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Imprimir proceso");
            }
        });

        // Crea un contenedor para los botones
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(btnNuevo, btnAbrir, btnGuardar, btnImprimir);
        hbox.setAlignment(Pos.CENTER);

        // Crea la escena con el contenedor
        Scene scene = new Scene(hbox, 375, 75);
        primaryStage.setTitle("AnnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
