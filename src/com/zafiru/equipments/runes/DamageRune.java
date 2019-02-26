package com.zafiru.equipments.runes;

import com.zafiru.equipments.weapons.IWeapon;

public class DamageRune extends WeaponDecorator {

    public DamageRune(IWeapon weapon) {
        super(weapon);
        System.out.println("Added Damage Rune to " + getName());
    }

    @Override
    public int getDamage() {
        return getWeapon().getDamage() + 2;
    }
}
