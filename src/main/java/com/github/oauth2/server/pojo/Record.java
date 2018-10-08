package com.github.oauth2.server.pojo;


import org.hibernate.Transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import com.sun.javafx.beans.IDProperty;curl -v https://api.testpay.com/payments/payment \
//        -H "Content-Type: application/json" \
//        -H "Authorization: Bearer <Access-Token>" \
//        -d '{
//        "intent": "order",
//        "notification_url": "https://example.com/your_notification_url",
//        "payer": {
//        "email": "test@example.com"
//        },
//        "transaction": {
//        "external_id": “123456789”
//        "amount": {
//        "value": "7.47",
//        "currency": "USD"
//        },
//        "description": “The payment transaction description”
//        }
//        }'
@Entity
public class Record {
    @Id
    @GeneratedValue
    private int id;

    @Column
    String intent;

    @Column
    String notification_url;

    @Column
    Payer payer;

    @Column
    TransactionDetails transaction;

    public Record(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public TransactionDetails getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionDetails transaction) {
        this.transaction = transaction;
    }


    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getNotification_url() {
        return notification_url;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }
}
