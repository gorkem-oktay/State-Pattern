package com.zafiru.commands;

import com.zafiru.characters.ICharacter;
import com.zafiru.characters.stances.IStance;

public class ChangeStanceCommand implements ICommand {

    ICharacter character;
    IStance stance;

    public ChangeStanceCommand(ICharacter character, IStance stance){
        this.character = character;
        this.stance = stance;
    }

    @Override
    public void execute() {
        character.setStance(stance);
    }
}
