package com.zafiru.components;

public class Sprite {

    private String file;

    public void setFile(String file){
        this.file = file;
    }

    public void setPosition(float x, float y){
        System.out.println("Position of " + file + " is set to X: " + x + ", Y: " + y);
    }

    public void playAnimation(String animation){
        System.out.println(file + " is playing: " + animation);
    }
}
