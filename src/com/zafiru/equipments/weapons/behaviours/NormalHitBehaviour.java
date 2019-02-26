package com.zafiru.equipments.weapons.behaviours;

public class NormalHitBehaviour implements IWeaponBehaviour {

    @Override
    public int calculateDamage(int damage) {
        return damage;
    }
}
