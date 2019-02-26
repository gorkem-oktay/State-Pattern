package com.zafiru.equipments.weapons;

import com.zafiru.equipments.IEquipment;
import com.zafiru.equipments.weapons.behaviours.IWeaponBehaviour;

public abstract class IWeapon extends IEquipment {

    private int damage;
    private IWeaponBehaviour behaviour;

    public IWeaponBehaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(IWeaponBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int calculateDamage() {
        return getBehaviour().calculateDamage(getDamage());
    }
}
