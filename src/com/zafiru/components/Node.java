package com.zafiru.components;

import java.util.ArrayList;

public class Node extends ViewComponent {

    private ArrayList<ViewComponent> components;

    public Node() {
        this.components = new ArrayList<>();
    }

    @Override
    public void add(ViewComponent component) {
        this.components.add(component);
    }

    @Override
    public void remove(ViewComponent component) {
        this.components.remove(component);
    }

    @Override
    public ViewComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public void draw() {
        System.out.println("Drawing node");
        components.forEach((viewComponent)->viewComponent.draw());
    }
}
