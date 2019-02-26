package com.zafiru.equipments.armors;

import com.zafiru.equipments.EquipmentSlot;

public class Helmet extends IArmor {

    public Helmet() {
        setName("Helmet");
        setSlot(EquipmentSlot.HEAD);
        setProtection(1);
    }
}
