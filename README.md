# State Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_State pattern_**, allows an object to alter its behaviour when its internal state changes. The object will appear to change its class.

### Description
We want to add a new feature to our games. Our character will have stances and corresponding to these stances, his damage output, protection value will change. For example, if he changes his stance to attack, his damage will be increased but his protection will be reduced and opposites for defence stance.

At first look, there seems, we need to add some if checks to damage calculations for stances. Hmm, for every stances? and if we want to add new ones, new if checks should be added too? That doesn't look like a good approach. Lets think about it. We have a state that changes and with this change, some calculations will be changed too. So we need to encapsulate this, there are lots of changes. Then lets define an interface for this state.

```java
public interface IStance {

    int getDamageAddition();

    int getProtectionAddition();
}
```

There are two depending properties for states, so we have two methods for each of them. Then we will create our concrete classes.

```java
public class NormalStance implements IStance {

    @Override
    public int getDamageAddition() {
        return 0;
    }

    @Override
    public int getProtectionAddition() {
        return 0;
    }
}
```
```java
public class AttackStance implements IStance {

    @Override
    public int getDamageAddition() {
        return 4;
    }

    @Override
    public int getProtectionAddition() {
        return -4;
    }
}
```
```java
public class DefenceStance implements IStance {

    @Override
    public int getDamageAddition() {
        return -4;
    }

    @Override
    public int getProtectionAddition() {
        return 4;
    }
}
```

NormalStance does nothing, it is just a default state. On the other hand, AttackStance increase damage, reduce protection and opposites for DefenceStance. Then lets actually change calculations.

```java
public abstract class ICharacter extends Sprite {

    // Other methods
    
    private IStance mStance = new NormalStance();

    public IStance getStance() {
            return mStance;
    }
    
    public void setStance(IStance stance) {
        System.out.println("Stance changed to: " + stance.getClass().getSimpleName());
        this.mStance = stance;
    }

    public void hit() {
        IWeapon weapon = getWeapon();

        if (getTarget() != null && weapon != null) {
            int damage = weapon.calculateDamage() + getStance().getDamageAddition();
            getTarget().takeHit(damage);
        }
    }
 
    private void takeHit(int damage){
        Iterator iterator = IEquipmentFactory.getIterator(IArmor.class, equipments);
        int totalArmor = getStance().getProtectionAddition();
        while(iterator.hasNext()){
            totalArmor += ((IArmor)iterator.next()).getProtection();
        }
        int calculatedDamage = totalArmor > damage ? 0 : damage - totalArmor;
        getHealth().decrease(calculatedDamage);

    }
}
```

That's it. We just added our state's values to corresponding places. We don't know which state we are in or care about it. If we want to add new states, the new class will be created and assigned. We don't need to touch calculation codes here.

Lastly lets run it.

```java
goblin.hit();
ourKnight.hit();
ourKnight.setStance(new NormalStance());
goblin.hit();
ourKnight.hit();
ourKnight.setStance(new AttackStance());
goblin.hit();
ourKnight.hit();
ourKnight.setStance(new DefenceStance());
goblin.hit();
ourKnight.hit();
```

And output will be;

```java
Knight received 3 damage and 110 health left
Goblin received 16 damage and 44 health left
Stance changed to: NormalStance
Knight received 3 damage and 107 health left
Goblin received 16 damage and 28 health left
Stance changed to: AttackStance
Knight received 7 damage and 100 health left
Goblin received 20 damage and 8 health left
Stance changed to: DefenceStance
Knight received 0 damage and 100 health left
Goblin received 12 damage and -4 health left
```

That's all. We implemented **_State Pattern_** successfully.