package com.zafiru.equipments.weapons.behaviours;

import java.util.Random;

public class DoubleStrikeBehaviour implements IWeaponBehaviour {

    @Override
    public int calculateDamage(int damage) {

        int isDoubleStrike = new Random().nextInt(101);

        if (isDoubleStrike > 30) {
            System.out.println("Double Strike!!!");
            return damage * 2;
        }

        return damage;
    }
}
