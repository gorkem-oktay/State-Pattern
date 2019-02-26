package com.zafiru.commands;

import com.zafiru.characters.ICharacter;

public class MoveCommand implements ICommand {

    private ICharacter character;

    public MoveCommand(ICharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.move();
    }
}
