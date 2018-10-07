package com.github.oauth2.server.pojo;

public class TransactionDetails {

    private String externalId;
    private Amount amount;

    public TransactionDetails( String externalId, Amount amount){
        this.externalId = externalId;
        this.amount = amount;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
