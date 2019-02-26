package com.zafiru.equipments.armors;

import com.zafiru.equipments.IEquipment;
import com.zafiru.equipments.IEquipmentFactory;

public class ArmorFactory extends IEquipmentFactory {

    @Override
    public IEquipment getEquipment(String name) {
        switch (name) {
            case "Helmet":
                return new Helmet();
            case "Cuirass":
                return new Cuirass();
            case "Pauldron":
                return new Pauldron();
            case "Gauntlet":
                return new Gauntlet();
            case "Greave":
                return new Greave();
            default:
                return null;
        }
    }
}
