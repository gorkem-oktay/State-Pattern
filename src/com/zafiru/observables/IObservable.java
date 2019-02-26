package com.zafiru.observables;

import com.zafiru.observers.IObserver;

import java.util.ArrayList;

public abstract class IObservable {

    private ArrayList<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyAll(Object value) {
        observers.forEach(observer -> {
            observer.updated(this, value);
        });
    }
}
