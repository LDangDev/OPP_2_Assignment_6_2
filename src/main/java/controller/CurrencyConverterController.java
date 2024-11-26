package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Currency;
import model.CurrencyModel;
import view.CurrencyConverterView;

public class CurrencyConverterController extends Application {
    private CurrencyModel model;
    private CurrencyConverterView view;

    @Override
    public void start(Stage primaryStage) {
        model = new CurrencyModel();
        view = new CurrencyConverterView();
        view.start(primaryStage);

        // Populate the combo boxes with currency abbreviations
        for (Currency currency : model.getCurrencies()) {
            view.getFromCurrencyBox().getItems().add(currency.getAbbreviation());
            view.getToCurrencyBox().getItems().add(currency.getAbbreviation());
        }

        // Set up event handling for the convert button using an anonymous inner class
        view.getConvertButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(view.getAmountField().getText());
            String fromAbbreviation = view.getFromCurrencyBox().getValue();
            String toAbbreviation = view.getToCurrencyBox().getValue();

            Currency fromCurrency = null;
            Currency toCurrency = null;

            for (Currency currency : model.getCurrencies()) {
                if (currency.getAbbreviation().equals(fromAbbreviation)) {
                    fromCurrency = currency;
                }
                if (currency.getAbbreviation().equals(toAbbreviation)) {
                    toCurrency = currency;
                }
            }

            if (fromCurrency == null || toCurrency == null) {
                throw new Exception("Currency not found");
            }

            double result = model.convert(amount, fromCurrency, toCurrency);
            view.getResultField().setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            view.getResultField().setText("Invalid amount");
        } catch (Exception ex) {
            view.getResultField().setText("Conversion error");
        }
    }

}