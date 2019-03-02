package com.zafiru.equipments.weapons;

import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.IEquipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class WeaponIterator implements Iterator {

    private Map<EquipmentSlot, IEquipment> equipments;
    private EquipmentSlot[] keys;
    private ArrayList<EquipmentSlot> weaponSlots;
    private int position = 0;

    public WeaponIterator(Map equipments){
        this.equipments = equipments;
        this.keys = (EquipmentSlot[]) equipments.keySet().toArray(new EquipmentSlot[0]);
        this.weaponSlots = new ArrayList<>();
        this.weaponSlots.addAll(
                Arrays.asList(
                        EquipmentSlot.TWO_HAND,
                        EquipmentSlot.RIGHT_HAND,
                        EquipmentSlot.LEFT_HAND
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
        } else if (weaponSlots.contains(keys[position])) {
            return true;
        } else {
            position++;
            return hasNext();
        }
    }

    @Override
    public Object next() {
        IWeapon item = (IWeapon) equipments.get(keys[position]);
        position++;
        return item;
    }


}
