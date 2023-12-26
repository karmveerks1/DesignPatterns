package Patterns.ObserverPattern.observer;

import Patterns.ObserverPattern.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String mobileNumber;
    StockObservable stockObservable;

    public MobileAlertObserverImpl(String mobileNumber, StockObservable stockObservable) {
        this.mobileNumber = mobileNumber;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMobileCommunication(mobileNumber,"Item is back in stock, hurry up");
    }

    private void sendMobileCommunication(String mobileNumber, String message){
        System.out.println("Phone communication has been sent to this number:" + mobileNumber);
    }
}
