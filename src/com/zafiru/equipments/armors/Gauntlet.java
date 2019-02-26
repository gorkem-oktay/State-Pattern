package com.zafiru.equipments.armors;

import com.zafiru.equipments.EquipmentSlot;

public class Gauntlet extends IArmor {

    public Gauntlet() {
        setName("Gauntlet");
        setSlot(EquipmentSlot.HAND);
        setProtection(1);
    }
}
