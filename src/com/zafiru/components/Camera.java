package com.zafiru.components;

public class Camera {

    public void move(){
        System.out.println("Camera moved");
    }

    public void setPosition(float x, float y){
        System.out.println("Position of camera is set to X: " + x + ", Y: " + y);
    }
}
