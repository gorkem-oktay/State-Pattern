package com.zafiru.equipments.armors;

import com.zafiru.equipments.EquipmentSlot;

public class Cuirass extends IArmor {

    public Cuirass() {
        setName("Cuirass");
        setSlot(EquipmentSlot.CHEST);
        setProtection(1);
    }
}
