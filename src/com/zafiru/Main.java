package com.zafiru;

import com.zafiru.characters.Dummy;
import com.zafiru.characters.Goblin;
import com.zafiru.characters.ICharacter;
import com.zafiru.characters.Knight;
import com.zafiru.commands.AttackCommand;
import com.zafiru.commands.CastSpellCommand;
import com.zafiru.commands.MoveCommand;
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
        System.out.println(Preferences.getInstance().get("name") + "stops at the blacksmith to upgrade his sword");
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
    }
}
