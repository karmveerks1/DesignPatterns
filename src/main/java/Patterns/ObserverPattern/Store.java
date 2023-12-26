package Patterns.ObserverPattern;

import Patterns.ObserverPattern.observable.IphoneObservableImpl;
import Patterns.ObserverPattern.observable.StockObservable;
import Patterns.ObserverPattern.observer.EmailAlertObserverImpl;
import Patterns.ObserverPattern.observer.MobileAlertObserverImpl;
import Patterns.ObserverPattern.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        // So we have a iphone which we want to observe
        // And we have 3 observers for iphone , one through email and 2 through phone
        StockObservable iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver n1 = new EmailAlertObserverImpl("asdf@gmail.com", iphoneObservable);
        NotificationAlertObserver n2 = new MobileAlertObserverImpl("7231968711", iphoneObservable);
        NotificationAlertObserver n3 = new MobileAlertObserverImpl("783345687", iphoneObservable);

        iphoneObservable.add(n1);
        iphoneObservable.add(n2);
        iphoneObservable.add(n3);

        iphoneObservable.setStockCount(10);
        iphoneObservable.remove(n2);
        System.out.println("StockCount is:" + iphoneObservable.getStockCount());
        iphoneObservable.setStockCount(5);
    }
}
