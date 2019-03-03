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
            if((int)value > 0){
                System.out.println("Gained " + value + " health, now have " + ((Health) observable).getValue());
            } else {
                System.out.println(name + " received " + ((int)value * -1) + " damage and " + ((Health) observable).getValue() + " health left");
            }
        }
    }
}
