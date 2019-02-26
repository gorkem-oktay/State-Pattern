package com.zafiru.observers;

import com.zafiru.observables.IObservable;
import com.zafiru.observables.Mana;

public class ManaBar implements IObserver {

    @Override
    public void updated(IObservable observable, Object value) {
        if (observable instanceof Mana) {
            System.out.println(((Mana) observable).getValue() + " mana left");
        }
    }
}
