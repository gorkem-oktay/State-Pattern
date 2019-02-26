package com.zafiru.characters;

import com.zafiru.observables.Health;
import com.zafiru.observables.Mana;
import com.zafiru.observers.HealthBar;
import com.zafiru.observers.ManaBar;

public class Knight extends ICharacter{

    public Knight(){
        setType("Knight");
        setHealth(new Health(100));
        getHealth().addObserver(new HealthBar(getType()));
        setMana(new Mana(100));
        getMana().addObserver(new ManaBar());
    }
}
