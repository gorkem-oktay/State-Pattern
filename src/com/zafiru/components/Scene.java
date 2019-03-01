package com.zafiru.components;

import java.util.ArrayList;

public class Scene {

    private Camera camera;
    private ArrayList<Sprite> sprites;

    public Scene(){
        sprites = new ArrayList<>();
    }

    public void open(String name){
        System.out.println("Opening " + name + " Scene");
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }
}
