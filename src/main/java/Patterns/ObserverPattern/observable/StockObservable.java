package Patterns.ObserverPattern.observable;

import Patterns.ObserverPattern.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();
    public void setStockCount(int stockCount);

    public int getStockCount();

}
