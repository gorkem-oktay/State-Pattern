package com.zafiru.equipments.weapons;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.weapons.behaviours.NormalHitBehaviour;

public class Dagger extends IWeapon {

    public Dagger(){
        setName("Dagger");
        setSlot(EquipmentSlot.RIGHT_HAND);
        setDamage(4);
        setBehaviour(new NormalHitBehaviour());
    }
}
