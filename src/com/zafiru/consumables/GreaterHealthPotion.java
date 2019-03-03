package com.zafiru.consumables;

import com.zafiru.characters.ICharacter;

public class GreaterHealthPotion extends IConsumable {

    public GreaterHealthPotion(){
        setName("Greater Health Potion");
    }

    @Override
    public void updateStats(ICharacter character) {
        character.getHealth().increase(20);
    }

    @Override
    public void addBuff() {
        System.out.println("Gained regeneration buff for 2 minutes");
    }
}
