package es.ieslosmontecillos.keyeventdavidvega;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class KeyEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crea un objeto Text con la posición (20, 20) y el texto "A"
        Text texto = new Text(20, 20, "A");

        // Registra el manejador de eventos para las teclas presionadas
        texto.setOnKeyPressed((evento) -> {
            KeyCode keyCode = evento.getCode();

            // Mueve el texto según la tecla presionada
            switch (keyCode) {
                case UP:
                    texto.setY(texto.getY() - 10); // Mover hacia arriba
                    break;
                case DOWN:
                    texto.setY(texto.getY() + 10); // Mover hacia abajo
                    break;
                case LEFT:
                    texto.setX(texto.getX() - 10); // Mover hacia la izquierda
                    break;
                case RIGHT:
                    texto.setX(texto.getX() + 10); // Mover hacia la derecha
                    break;
                default:
                    // Asigna la tecla pulsada si es letra o dígito
                    String keyChar = evento.getText();
                    if (keyChar.length() == 1) {
                        texto.setText(keyChar);
                    }
                    break;
            }
        });

        // Crea un contenedor
        Pane root = new Pane();
        root.getChildren().add(texto);

        // Crea la escena
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("KeyEvent");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Establece el foco en el objeto Text para que pueda recibir eventos de teclado
        texto.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
