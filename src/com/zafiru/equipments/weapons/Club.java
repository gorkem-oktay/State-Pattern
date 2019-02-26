package com.zafiru.equipments.weapons;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.weapons.behaviours.NormalHitBehaviour;

public class Club extends IWeapon {

    public Club(){
        setName("Club");
        setSlot(EquipmentSlot.RIGHT_HAND);
        setDamage(8);
        setBehaviour(new NormalHitBehaviour());
    }
}
