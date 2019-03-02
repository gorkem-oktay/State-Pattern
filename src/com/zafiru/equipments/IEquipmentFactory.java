package com.zafiru.equipments;

import com.zafiru.equipments.armors.ArmorFactory;
import com.zafiru.equipments.armors.ArmorIterator;
import com.zafiru.equipments.armors.IArmor;
import com.zafiru.equipments.weapons.IWeapon;
import com.zafiru.equipments.weapons.WeaponFactory;
import com.zafiru.equipments.weapons.WeaponIterator;

import java.util.Iterator;
import java.util.Map;

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

    public static Iterator getIterator(Class type, Map<EquipmentSlot, IEquipment> equipments) {
        if (type == IWeapon.class) {
            return new WeaponIterator(equipments);
        } else if (type == IArmor.class) {
            return new ArmorIterator(equipments);
        } else {
            return null;
        }
    }
}
