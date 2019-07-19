package com.kodilla.patterns2.observer.homework;

public interface TaskQueueObservable {
    void registerObserver(TaskQueueObserver observer);
    void notifyObservers();
    void removeObserver(TaskQueueObserver observer);
}
