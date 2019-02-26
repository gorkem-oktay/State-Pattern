package com.zafiru.observers;

import com.zafiru.observables.Health;
import com.zafiru.observables.IObservable;

public class HealthBar implements IObserver {

    private String name;

    public HealthBar(String name) {
        this.name = name;
    }

    @Override
    public void updated(IObservable observable, Object value) {
        if (observable instanceof Health) {
            System.out.println(name + " received " + value + " damage and " + ((Health) observable).getValue() + " health left");
        }
    }
}
