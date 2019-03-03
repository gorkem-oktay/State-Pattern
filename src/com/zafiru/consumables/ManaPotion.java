package com.zafiru.consumables;

import com.zafiru.characters.ICharacter;

public class ManaPotion extends IConsumable {

    public ManaPotion(){
        setName("Mana Potion");
    }

    @Override
    public void updateStats(ICharacter character) {
        character.getMana().increase(10);
    }
}
