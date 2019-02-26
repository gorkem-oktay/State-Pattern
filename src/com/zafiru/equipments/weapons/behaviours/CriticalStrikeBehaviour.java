package com.zafiru.equipments.weapons.behaviours;

import java.util.Random;

public class CriticalStrikeBehaviour implements IWeaponBehaviour {

    @Override
    public int calculateDamage(int damage) {

        int isCriticalStrike = new Random().nextInt(101);

        if (isCriticalStrike > 70) {
            System.out.println("Critical Strike!!!");
            return damage * 3;
        }

        return damage;
    }
}
