package com.zafiru;

import com.zafiru.characters.*;
import com.zafiru.commands.AttackCommand;
import com.zafiru.commands.CastSpellCommand;
import com.zafiru.commands.MoveCommand;
import com.zafiru.components.*;
import com.zafiru.consumables.GreaterHealthPotion;
import com.zafiru.consumables.HealthPotion;
import com.zafiru.consumables.IConsumable;
import com.zafiru.consumables.ManaPotion;
import com.zafiru.core.AudioEngine;
import com.zafiru.core.CombatSceneFacade;
import com.zafiru.core.PhysicsEngine;
import com.zafiru.equipments.EquipmentSlot;
import com.zafiru.equipments.runes.DamageRune;
import com.zafiru.equipments.weapons.behaviours.DoubleStrikeBehaviour;
import com.zafiru.services.DatabaseService;
import com.zafiru.services.GameService;
import com.zafiru.services.IService;
import com.zafiru.services.ServiceAdapter;
import com.zafiru.settings.Preferences;
import com.zafiru.spells.Fireball;
import com.zafiru.spells.Frostbolt;
import com.zafiru.ui.AbilityPanel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String name = input.nextLine();

        Preferences.getInstance().set("name", name);

        ICharacter ourKnight = new Knight();
        ourKnight.setName((String)Preferences.getInstance().get("name"));
        ourKnight.equip(EquipmentSlot.RIGHT_HAND, "Dagger");

        System.out.println(Preferences.getInstance().get("name") + ", travels across countries to live an adventures life...");

        ICharacter evilGoblin = new Goblin();
        evilGoblin.equip(EquipmentSlot.TWO_HAND, "Club");

        System.out.println("Than suddenly a " + evilGoblin.getType() + " appears.");
        System.out.println("And attacks " + Preferences.getInstance().get("name"));

        evilGoblin.setTarget(ourKnight);
        evilGoblin.hit();

        System.out.println(Preferences.getInstance().get("name") + " tries to fight back");

        ourKnight.setTarget(evilGoblin);
        ourKnight.hit();
        ourKnight.getWeapon().setBehaviour(new DoubleStrikeBehaviour());
        ourKnight.hit();

        System.out.println("But he couldn't inflict much damage");
        System.out.println("then he saw a sword on the ground and grabs it");

        ourKnight.unequip(EquipmentSlot.RIGHT_HAND);
        ourKnight.equip(EquipmentSlot.RIGHT_HAND, "Sword");

        System.out.println("And fearlessly attack " + evilGoblin.getType());

        ourKnight.hit();

        System.out.println();
        System.out.println("After defating " + evilGoblin.getType());
        System.out.println(Preferences.getInstance().get("name") + " stops at the blacksmith to upgrade his sword");
        System.out.println("Then buys three damage rune and goes to training ground to test them");
        System.out.println();

        ICharacter dummy = new Dummy();

        ourKnight.setTarget(dummy);
        ourKnight.updateWeapon(new DamageRune(ourKnight.getWeapon()));
        ourKnight.hit();
        ourKnight.updateWeapon(new DamageRune(ourKnight.getWeapon()));
        ourKnight.hit();
        ourKnight.updateWeapon(new DamageRune(ourKnight.getWeapon()));
        ourKnight.hit();

        System.out.println();
        System.out.println("After testing his new sword returns to the blacksmith to get his helmet back from repair");
        System.out.println("It was finished and he immediately tries it to see how it was done");
        System.out.println();

        ourKnight.equip(EquipmentSlot.HEAD, "Helmet");
        ourKnight.equip(EquipmentSlot.CHEST, "Cuirass");
        ourKnight.equip(EquipmentSlot.LEGS, "Pauldron");
        ourKnight.equip(EquipmentSlot.HAND, "Gauntlet");
        ourKnight.equip(EquipmentSlot.FOOT, "Greave");

        System.out.println();

        AbilityPanel panel = new AbilityPanel();
        panel.setCommand(0, new MoveCommand(ourKnight));
        panel.setCommand(1, new AttackCommand(ourKnight));
        panel.setCommand(2, new CastSpellCommand(ourKnight, new Fireball()));

        panel.onButtonClick(0);
        panel.onButtonClick(1);
        panel.onButtonClick(2);


        System.out.println();

        panel.setCommand(0, new AttackCommand(ourKnight));
        panel.setCommand(1, new MoveCommand(ourKnight));
        panel.setCommand(2, new CastSpellCommand(ourKnight, new Frostbolt()));

        panel.onButtonClick(0);
        panel.onButtonClick(1);
        panel.onButtonClick(2);

        IService gameService = new ServiceAdapter(new GameService());
        gameService.sendRequest();
        String response = gameService.getResponse();
        System.out.println("Game Service Response: " + response);
        System.out.println();

        IService databaseService = new ServiceAdapter(new DatabaseService());
        databaseService.sendRequest();
        response = databaseService.getResponse();
        System.out.println("Database Service Response: " + response);

        System.out.println();
        System.out.println(Preferences.getInstance().get("name") + " hit the road again and suddenly a Troll appeared");

        ICharacter troll = new Troll();
        troll.setFile("Troll");
        troll.equip(EquipmentSlot.TWO_HAND, "Club");

        ourKnight.setFile("Knight");

        System.out.println();

        CombatSceneFacade combatSceneFacade = new CombatSceneFacade(
                new Scene(),
                new Camera(),
                ourKnight,
                troll,
                new PhysicsEngine(),
                new AudioEngine(),
                new ServiceAdapter(new DatabaseService()));

        combatSceneFacade.start();

        troll.setTarget(ourKnight);
        combatSceneFacade.getEnemy().playAnimation("Attack");
        troll.hit();

        ourKnight.setTarget(troll);
        combatSceneFacade.getPlayer().playAnimation("Attack");
        panel.onButtonClick(0);

        combatSceneFacade.getEnemy().playAnimation("Attack");
        troll.hit();

        combatSceneFacade.getPlayer().playAnimation("Attack");
        panel.onButtonClick(0);

        combatSceneFacade.getEnemy().playAnimation("Attack");
        troll.hit();

        combatSceneFacade.getPlayer().playAnimation("Attack");
        panel.onButtonClick(0);


        combatSceneFacade.end();

        IConsumable healthPotion = new HealthPotion();
        IConsumable manaPotion = new ManaPotion();
        IConsumable greaterHealthPotion = new GreaterHealthPotion();

        healthPotion.setAmount(2);
        manaPotion.setAmount(2);
        greaterHealthPotion.setAmount(2);

        ourKnight.consume(healthPotion);
        ourKnight.consume(manaPotion);
        ourKnight.consume(greaterHealthPotion);

        System.out.println();

        ViewComponent mainNode = new Node();
        mainNode.add(new Sprite("Main Sprite"));
        mainNode.add(new Label("Main Label 1"));
        mainNode.add(new Label("Main Label 2"));

        ViewComponent childNode = new Node();
        childNode.add(new Sprite("Child Sprite"));
        childNode.add(new Label("Child Label"));

        mainNode.add(childNode);

        mainNode.draw();
    }
}
