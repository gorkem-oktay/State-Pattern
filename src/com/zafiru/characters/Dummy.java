package com.zafiru.characters;

import com.zafiru.observables.Health;
import com.zafiru.observers.HealthBar;

public class Dummy extends ICharacter {

    public Dummy() {
        setType("Dummy");
        setHealth(new Health(1000000));
        getHealth().addObserver(new HealthBar(getType()));
    }
}
