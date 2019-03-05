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