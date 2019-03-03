package com.zafiru.components;

public abstract class ViewComponent {

    private float x, y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void add(ViewComponent component){
        throw new UnsupportedOperationException();
    }

    public void remove(ViewComponent component){
        throw new UnsupportedOperationException();
    }

    public ViewComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    public void draw(){
        throw new UnsupportedOperationException();
    }
}
