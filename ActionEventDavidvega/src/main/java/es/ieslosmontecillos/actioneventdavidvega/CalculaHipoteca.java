package es.ieslosmontecillos.actioneventdavidvega;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculaHipoteca extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        escenarioPrincipal.setTitle("Calculadora de Hipoteca");

        // Crear el grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene escena = new Scene(grid, 325, 275);
        escenarioPrincipal.setScene(escena);

        // Campos de entrada de datos
        Label tasaInteresAnual = new Label("Tasa de interés anual:");
        grid.add(tasaInteresAnual, 0, 1);

        TextField campoTasaInteresAnual = new TextField();
        grid.add(campoTasaInteresAnual, 1, 1);

        Label numeroAnios = new Label("Número de años:");
        grid.add(numeroAnios, 0, 2);

        TextField campoNumeroAnios = new TextField();
        grid.add(campoNumeroAnios, 1, 2);

        Label montoPrestamo = new Label("Monto del préstamo:");
        grid.add(montoPrestamo, 0, 3);

        TextField campoMontoPrestamo = new TextField();
        grid.add(campoMontoPrestamo, 1, 3);

        Label pagoMensual = new Label("Pago mensual:");
        grid.add(pagoMensual, 0, 4);

        TextField campoPagoMensual = new TextField();
        campoPagoMensual.setEditable(false);
        grid.add(campoPagoMensual, 1, 4);

        Label pagoTotal = new Label("Pago total:");
        grid.add(pagoTotal, 0, 5);

        TextField campoPagoTotal = new TextField();
        campoPagoTotal.setEditable(false);
        grid.add(campoPagoTotal, 1, 5);

        // Botón para calcular
        Button botonCalcular = new Button("Calcular");
        HBox cajaBoton = new HBox(10);
        cajaBoton.setAlignment(Pos.BOTTOM_RIGHT);
        cajaBoton.getChildren().add(botonCalcular);
        grid.add(cajaBoton, 1, 6);

        // Acción del botón utilizando una expresión Lambda
        botonCalcular.setOnAction(e -> {
            try {
                double tasaAnual = Double.parseDouble(campoTasaInteresAnual.getText());
                int anios = Integer.parseInt(campoNumeroAnios.getText());
                double prestamo = Double.parseDouble(campoMontoPrestamo.getText());

                // Cálculo de la tasa mensual
                double tasaMensual = tasaAnual / 100 / 12;

                // Cálculo del pago mensual
                double pagoMensualCalculado = (prestamo * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -12 * anios));
                pagoMensualCalculado = Math.round(pagoMensualCalculado * 100.0) / 100.0;

                // Cálculo del pago total
                double pagoTotalCalculado = pagoMensualCalculado * 12 * anios;
                pagoTotalCalculado = Math.round(pagoTotalCalculado * 100.0) / 100.0;

                // Mostrar los resultados en los campos correspondientes
                campoPagoMensual.setText(String.valueOf(pagoMensualCalculado));
                campoPagoTotal.setText(String.valueOf(pagoTotalCalculado));

            } catch (NumberFormatException ex) {
                campoPagoMensual.setText("Entrada no válida");
                campoPagoTotal.setText("Entrada no válida");
            }
        });

        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
