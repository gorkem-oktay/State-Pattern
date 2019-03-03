# Template Method Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_Template method pattern_**, defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

### Description
We will add some consumable to our game. There will be some variety of it, health potions, mana potions, foods, drinks... And there will be some functions to check the amount, to decrease it, to update status... Some of them will do the same jobs, and some of them differentiate. So lets check it out.

```java
public abstract class IConsumable {

    private String name;
    private int amount;

    // Getter setters;

    public boolean hasEnough(){
        return getAmount() > 0;
    }

    public void decreaseAmount(){
        amount--;
        System.out.println(getAmount() + " " + getName() + " left");
    }

    public abstract void updateStats(ICharacter character);

    public void addBuff(){}

    public final void consume(ICharacter character){
        if(hasEnough()){
            System.out.println("Consumed " + getName());
            decreaseAmount();
            updateStats(character);
            addBuff();
        } else {
            System.out.println("There is not enough item to consume.");
        }
    }
}
```

We have our consumable class, and we consume the item via consume() method. It has small algorithm to do some steps while consuming the item. First checks the amount, then decrease it, then update stats and lastly adds buffs. This method will be the standard for all the consumables and we don't want it to be changed. 
 
However, consumables will effect our character differently. Health potion will increase current health, mana potion will increase current mana and so on... So we let subclasses to implement updateStats() method.

```java
public class HealthPotion extends IConsumable {

    @Override
    public void updateStats(ICharacter character) {
        character.getHealth().increase(10);
    }
}
```
```java
public class ManaPotion extends IConsumable {

    @Override
    public void updateStats(ICharacter character) {
        character.getMana().increase(10);
    }
}
```

On the other hand, some potions may have some other functionality like adding buffes, but mainly not all of them. So addBuff() method is added for it. Normally, it does nothing by default and it is an empty method. But via overriding it, we can add some additional functionality to it. And they are called "hooks".

```java
public class GreaterHealthPotion extends IConsumable {

    @Override
    public void updateStats(ICharacter character) {
        character.getHealth().increase(20);
    }

    @Override
    public void addBuff() {
        System.out.println("Gained regeneration buff for 2 minutes");
    }
}

```

This is called Template Method Pattern. We have some defined algorithm and just some part of it will be implemented by subclasses or they will hook themselves to a part.