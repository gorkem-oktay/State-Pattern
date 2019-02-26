package com.zafiru.equipments.weapons;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.weapons.behaviours.CriticalStrikeBehaviour;

public class Sword extends IWeapon {

    public Sword(){
        setName("Sword");
        setSlot(EquipmentSlot.RIGHT_HAND);
        setDamage(10);
        setBehaviour(new CriticalStrikeBehaviour());
    }
}
