package com.github.oauth2.server.pojo;

import java.util.Currency;

public class Amount {

    private String value;
    private String currency;

    //If one of these methods throw exception - we have invalid amount
    Amount(String value, String currency) throws InvalidAmountException {

        if (value.length() > 10) {
            throw new InvalidAmountException();
        }
        double res = Double.parseDouble(value);

        Currency curr = Currency.getInstance(currency);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

class InvalidAmountException extends Exception {
}
