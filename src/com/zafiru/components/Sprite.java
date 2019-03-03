package com.zafiru.components;

public class Sprite extends ViewComponent {

    private String file;

    public Sprite(){}
    public Sprite(String file){
        this.file = file;
    }

    public void setFile(String file){
        this.file = file;
    }

    public String getFile(){
        return file;
    }

    public void playAnimation(String animation){
        System.out.println(file + " is playing: " + animation);
    }

    @Override
    public void draw() {
        System.out.println("Drawing sprite: " + file);
    }
}
