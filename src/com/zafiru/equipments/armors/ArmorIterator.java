package com.zafiru.equipments.armors;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.IEquipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class ArmorIterator implements Iterator {

    private Map<EquipmentSlot, IEquipment> equipments;
    private EquipmentSlot[] keys;
    private ArrayList<EquipmentSlot> armorSlots;
    private int position = 0;

    public ArmorIterator(Map equipments){
        this.equipments = equipments;
        this.keys = (EquipmentSlot[]) equipments.keySet().toArray(new EquipmentSlot[0]);
        this.armorSlots = new ArrayList<>();
        this.armorSlots.addAll(
                Arrays.asList(
                        EquipmentSlot.CHEST,
                        EquipmentSlot.HEAD,
                        EquipmentSlot.FOOT,
                        EquipmentSlot.LEGS,
                        EquipmentSlot.HAND
                )
        );
    }

    @Override
    public boolean hasNext() {
        if (keys.length <= position) {
            return false;
        } else if(keys[position] == null) {
            position++;
            return hasNext();
        } else if (armorSlots.contains(keys[position])) {
            return true;
        } else {
            position++;
            return hasNext();
        }
    }

    @Override
    public Object next() {
        IArmor item = (IArmor) equipments.get(keys[position]);
        position++;
        return item;
    }
}
