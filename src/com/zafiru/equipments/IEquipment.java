package com.zafiru.equipments;

public abstract class IEquipment {

    private String name = "Unknown Item";
    private EquipmentSlot slot = EquipmentSlot.UNKNOWN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public void setSlot(EquipmentSlot slot) {
        this.slot = slot;
    }
}
