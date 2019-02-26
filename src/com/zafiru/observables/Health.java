package com.zafiru.observables;

public class Health extends IObservable {

    private int value;

    public Health(int value) {
        this.value = value;
    }

    public void decrease(int value) {
        this.value -= value;
        notifyAll(value);
    }

    public int getValue() {
        return value;
    }
}
