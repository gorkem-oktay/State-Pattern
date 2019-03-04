# Composite Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_Composite pattern_**, allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

### Description
Let's create some view (not actual view again). As you know views consist of many components. Generally, tree-hierarchy is used as their structure with nodes and leaves. Nodes can contain other nodes or leaves, but leaves are the last items of their branch. When they are drawn, the order is from root to bottom. First parents draw themselves, then let children do it themselves. That's why the children is always appears on top of their parents (if we won't specially change it). If you have any Android development experience, it is seen clearly in layouts' xml files.

So how was it achieved? Actually it is not as complicated as it sounds. And here is our **_Composite_** pattern to explain it. 

Before, we said, nodes and leaves, all of them draw themselves. And again multiple levels can be nested, a node in a node, and that in another one and so on... So we need to treat them uniformly. To do that, we will create an interface that has both nodes and leaves methods.

```java
public abstract class ViewComponent {

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
``` 

They are not implemented and throws exception. Because all subclasses will implement what they will use and if it tries to use others, an exception will be thrown for safety. Lets first implement leaf.

```java
public class Sprite extends ViewComponent {

    // Other methods (They are irrelevant to composite pattern, so don't concern yourself with them)

    @Override
    public void draw() {
        System.out.println("Drawing sprite: " + file);
    }
}
```

It is just a leaf. It won't has any children, it just draws itself. So don't need to implement other methods. And it is node's turn.

```java
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
```

In node, it will has children. So it has an array to keep its children, and relevant methods are implemented to add, remove, get. Also, it draws itself, then tells its children to draw themselves. 

That's it. Lets use it;

```java
ViewComponent mainNode = new Node();
mainNode.add(new Sprite("Main Sprite"));
mainNode.add(new Label("Main Label 1"));
mainNode.add(new Label("Main Label 2"));

ViewComponent childNode = new Node();
childNode.add(new Sprite("Child Sprite"));
childNode.add(new Label("Child Label"));

mainNode.add(childNode);

mainNode.draw();
```

And output will be;

```java
Drawing node
Drawing sprite: Main Sprite
Drawing label: Main Label 1
Drawing label: Main Label 2
Drawing node
Drawing sprite: Child Sprite
Drawing label: Child Label
```

It is actually easy, isn't it? We could actually use some different interface for nodes and leaves to get rid of exceptions and to separate responsibilities. However, with that way, we would lose transparency and there will be type checks for them. Both can be used, it is just a design decision.