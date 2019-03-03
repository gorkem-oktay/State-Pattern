package com.zafiru.components;

public class Label extends ViewComponent {

    private String text;

    public Label(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println("Drawing label: " + text);
    }
}
