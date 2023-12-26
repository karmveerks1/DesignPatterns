package Patterns.ObserverPattern.observable;

import Patterns.ObserverPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    List<NotificationAlertObserver> alertObserverList = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver observer) {
        alertObserverList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        alertObserverList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : alertObserverList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newAddedStockCount) {
        if(stockCount == 0){
            if(newAddedStockCount > 0) {
                notifySubscribers();
            }
            else {
                System.out.println("Please Wait for the stock");
            }
        }
        stockCount = stockCount + newAddedStockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
