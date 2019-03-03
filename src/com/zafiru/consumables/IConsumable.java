package com.zafiru.consumables;

import com.zafiru.characters.ICharacter;

public abstract class IConsumable {

    private String name;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean hasEnough(){
        return getAmount() > 0;
    }

    public void decreaseAmount(){
        amount--;
        System.out.println(amount + " " + name + " left");
    }

    public abstract void updateStats(ICharacter character);

    public void addBuff(){}

    public final void consume(ICharacter character){
        if(hasEnough()){
            System.out.println("Consumed " + name);
            decreaseAmount();
            updateStats(character);
            addBuff();
        } else {
            System.out.println("There is not enough item to consume.");
        }
    }
}
