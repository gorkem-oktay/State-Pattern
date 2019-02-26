package com.zafiru.spells;

public abstract class ISpell {

    private String name = "Unknown Spell";
    private int mana = 0;
    private int level = 0;
    private double castTime = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCastTime() {
        return castTime;
    }

    public void setCastTime(double castTime) {
        this.castTime = castTime;
    }

    public void cast(){
        System.out.println("Casted " + name + "!!!");
    }
}
