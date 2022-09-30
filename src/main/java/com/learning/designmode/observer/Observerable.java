package com.learning.designmode.observer;

/**
 * @author: mufei
 * @date: 2022/9/30 16:41
 * @Description:
 */
public interface Observerable {

     void registerObserver(Observer o);

     void removeObserver(Observer o);

     void notifyObserver();
}
