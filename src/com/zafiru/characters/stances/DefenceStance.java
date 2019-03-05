package com.zafiru.characters.stances;

public class DefenceStance implements IStance {

    @Override
    public int getDamageAddition() {
        return -4;
    }

    @Override
    public int getProtectionAddition() {
        return 4;
    }
}
