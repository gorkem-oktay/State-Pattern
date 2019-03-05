package com.zafiru.characters.stances;

public class AttackStance extends IStance {

    @Override
    public int getDamageAddition() {
        return 4;
    }

    @Override
    public int getProtectionAddition() {
        return -4;
    }
}
