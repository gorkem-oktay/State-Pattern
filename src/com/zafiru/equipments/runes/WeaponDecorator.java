package com.zafiru.equipments.runes;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.weapons.IWeapon;
import com.zafiru.equipments.weapons.behaviours.IWeaponBehaviour;

public class WeaponDecorator extends IWeapon {

    private IWeapon weapon;

    public WeaponDecorator(IWeapon weapon) {
        this.weapon = weapon;
    }

    public IWeapon getWeapon() {
        return weapon;
    }

    @Override
    public String getName() {
        return weapon.getName();
    }

    @Override
    public EquipmentSlot getSlot() {
        return weapon.getSlot();
    }

    @Override
    public IWeaponBehaviour getBehaviour() {
        return weapon.getBehaviour();
    }
}
