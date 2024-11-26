package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverterView extends Application {
    private TextField amountField;
    private Label result;
    private ComboBox<String> fromCurrencyBox;
    private ComboBox<String> toCurrencyBox;
    private Button convertButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label amountLabel = new Label("Amount:");
        amountField = new TextField();
        Label fromLabel = new Label("From:");
        fromCurrencyBox = new ComboBox<>();
        Label toLabel = new Label("To:");
        toCurrencyBox = new ComboBox<>();
        convertButton = new Button("Convert");
        Label resultLabel = new Label("Result:");
        result = new Label();

        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrencyBox, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrencyBox, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(resultLabel, 0, 4);
        grid.add(result, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TextField getAmountField() {
        return amountField;
    }

    public Label getResultField() {
        return result;
    }

    public ComboBox<String> getFromCurrencyBox() {
        return fromCurrencyBox;
    }

    public ComboBox<String> getToCurrencyBox() {
        return toCurrencyBox;
    }

    public Button getConvertButton() {
        return convertButton;
    }

}
