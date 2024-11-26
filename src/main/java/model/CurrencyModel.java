package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
        // Hardcoded currencies
        currencies.add(new Currency("USD", "United States Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.85));
        currencies.add(new Currency("GBP", "British Pound", 0.75));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        // Calculate the conversion rate from 'from' currency to 'to' currency
        double rate = to.getRateToUSD() / from.getRateToUSD();
        return amount * rate;
    }
}
