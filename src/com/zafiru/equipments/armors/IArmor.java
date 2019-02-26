package com.zafiru.equipments.armors;

import com.zafiru.equipments.IEquipment;

public abstract class IArmor extends IEquipment {

    private int protection = 0;

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}
