package com.zafiru.equipments.weapons;

import com.zafiru.equipments.IEquipment;
import com.zafiru.equipments.IEquipmentFactory;

public class WeaponFactory extends IEquipmentFactory {

    @Override
    public IEquipment getEquipment(String name) {
        switch (name) {
            case "Sword":
                return new Sword();
            case "Dagger":
                return new Dagger();
            case "Club":
                return new Club();
            default:
                return null;
        }
    }
}
