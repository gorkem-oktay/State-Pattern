package com.zafiru.commands;

import com.zafiru.characters.ICharacter;

public class AttackCommand implements ICommand {

    private ICharacter character;

    public AttackCommand(ICharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.hit();
    }
}
