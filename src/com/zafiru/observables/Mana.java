package com.zafiru.observables;

public class Mana extends IObservable {

    private int value;

    public Mana(int value) {
        this.value = value;
    }

    public void decrease(int value) {
        this.value -= value;
        notifyAll(-value);
    }

    public void increase(int value){
        this.value += value;
        notifyAll(value);
    }

    public int getValue() {
        return value;
    }
}
