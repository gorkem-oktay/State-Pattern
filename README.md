# Iterator Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
**_Iterator pattern_**, provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

### Description
Hmm.. We forgot something about the combat system. Weapon damage was calculated but we didn't include armors. It is not too late lets add it too.

We hold all the equipments in a map, slots as keys and equipments as values. We just need to loop through map and calculate the total protection value. But while looping, we need to check every item if it is a weapon or an armor. And if it is an armor, we will add protection, else skip to next item. I think there is a better way. We can implement our own iterator. It can loop through just what we want and ignore others. It sounds good lets do this.

Java has in-built iterator interface that collections use. It has 4 method, but we need to implement just 2 of them, hasNext() and next().

```java
public class ArmorIterator implements Iterator {

    private Map<EquipmentSlot, IEquipment> equipments;
    private EquipmentSlot[] keys;
    private ArrayList<EquipmentSlot> armorSlots;
    private int position = 0;

    public ArmorIterator(Map equipments){
        this.equipments = equipments;
        this.keys = (EquipmentSlot[]) equipments.keySet().toArray(new EquipmentSlot[0]);
        this.armorSlots = new ArrayList<>();
        this.armorSlots.addAll(
                Arrays.asList(
                        EquipmentSlot.CHEST,
                        EquipmentSlot.HEAD,
                        EquipmentSlot.FOOT,
                        EquipmentSlot.LEGS,
                        EquipmentSlot.HAND
                )
        );
    }

    @Override
    public boolean hasNext() {
        if (keys.length <= position) {
            return false;
        } else if(keys[position] == null) {
            position++;
            return hasNext();
        } else if (armorSlots.contains(keys[position])) {
            return true;
        } else {
            position++;
            return hasNext();
        }
    }

    @Override
    public Object next() {
        IArmor item = (IArmor) equipments.get(keys[position]);
        position++;
        return item;
    }
}
```

In constructor, a reference is taken for equipments and its keys are extracted to an array to make it easier to loop. Then a list is created to hold armor's slots.

In hasNext(), it checks if there is another element left. If there is and it is not an armor, it just skips that item and checks next element until it is end of the collection.

In next(), it just increase counter and returns the armor.

And that's it. Our iterator is ready to use. We can do this for weapons too. And then with help of our old friend Factory Method, they can be initialized.

```java
public abstract class IEquipmentFactory {

    // Other methods

    public static Iterator getIterator(Class type, Map<EquipmentSlot, IEquipment> equipments) {
        if (type == IWeapon.class) {
            return new WeaponIterator(equipments);
        } else if (type == IArmor.class) {
            return new ArmorIterator(equipments);
        } else {
            return null;
        }
    }
}
```

And now we can actually use it, also as a bonus, we got cleaner getWeapon() method.

```java
public abstract class ICharacter extends Sprite {

    // Other methods

    public void hit() {
        IWeapon weapon = getWeapon();

        if (getTarget() != null && weapon != null) {
            int damage = weapon.calculateDamage();
            getTarget().takeHit(damage);
        }
    }

    private void takeHit(int damage){
        Iterator iterator = IEquipmentFactory.getIterator(IArmor.class, equipments);
        int totalArmor = 0;
        while(iterator.hasNext()){
            totalArmor += ((IArmor)iterator.next()).getProtection();
        }
        int calculatedDamage = totalArmor > damage ? 0 : damage - totalArmor;
        getHealth().decrease(calculatedDamage);
    }
    
    public IWeapon getWeapon() {
        Iterator iterator = IEquipmentFactory.getIterator(IWeapon.class, equipments);
        if(iterator.hasNext()){
            return (IWeapon) iterator.next();
        } else {
            return null;
        }
    }
}
```

With iterator pattern, while iterating through a collection, we don't know or care which collection type it is. We just ask for next item and that's all.