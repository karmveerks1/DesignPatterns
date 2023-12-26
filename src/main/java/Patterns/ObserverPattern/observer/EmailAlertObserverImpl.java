package Patterns.ObserverPattern.observer;

import Patterns.ObserverPattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId,"Product is back in stock , hurry up!!");
    }
    private void sendEmail(String email, String message){
        System.out.println("Mail sent to this emailId:" + emailId);
    }
}
