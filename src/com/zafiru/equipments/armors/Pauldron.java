package com.zafiru.equipments.armors;

import com.zafiru.equipments.EquipmentSlot;

public class Pauldron extends IArmor {

    public Pauldron() {
        setName("Pauldron");
        setSlot(EquipmentSlot.LEGS);
        setProtection(1);
    }
}
