package com.zafiru.characters;

import com.zafiru.observables.Health;
import com.zafiru.observers.HealthBar;

public class Troll extends ICharacter {

    public Troll() {
        setType("Troll");
        setHealth(new Health(140));
        getHealth().addObserver(new HealthBar(getType()));
    }
}
