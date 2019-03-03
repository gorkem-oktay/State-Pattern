package com.zafiru.observers;

import com.zafiru.observables.IObservable;
import com.zafiru.observables.Mana;

public class ManaBar implements IObserver {

    @Override
    public void updated(IObservable observable, Object value) {
        if (observable instanceof Mana) {
            if((int)value > 0){
                System.out.println("Gained " + value + " mana, now have " + ((Mana) observable).getValue());
            } else {
                System.out.println(((Mana) observable).getValue() + " mana left");
            }
        }
    }
}
