package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements TaskQueueObservable {
    private final List<TaskQueueObserver> observers;
    private final ArrayDeque<Task> tasks;
    private final String name;

    public TaskQueue(String name) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayDeque<>();
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.offer(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(TaskQueueObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(TaskQueueObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(TaskQueueObserver observer) {
        observers.remove(observer);
    }

    public ArrayDeque<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public List<TaskQueueObserver> getObservers() {
        return observers;
    }
}
