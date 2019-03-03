package com.zafiru.consumables;

import com.zafiru.characters.ICharacter;

public class HealthPotion extends IConsumable {

    public HealthPotion(){
        setName("Health Potion");
    }

    @Override
    public void updateStats(ICharacter character) {
        character.getHealth().increase(10);
    }
}
