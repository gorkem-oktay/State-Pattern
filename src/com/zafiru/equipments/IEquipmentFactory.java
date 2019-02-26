package com.zafiru.equipments;

import com.zafiru.equipments.armors.ArmorFactory;
import com.zafiru.equipments.weapons.WeaponFactory;

public abstract class IEquipmentFactory {

    public abstract IEquipment getEquipment(String name);

    public static IEquipmentFactory getFactory(EquipmentSlot slot) {
        switch (slot) {
            case RIGHT_HAND:
            case LEFT_HAND:
            case TWO_HAND:
                return new WeaponFactory();
            case CHEST:
            case FOOT:
            case HAND:
            case HEAD:
            case LEGS:
                return new ArmorFactory();
            default:
                return null;
        }
    }
}
