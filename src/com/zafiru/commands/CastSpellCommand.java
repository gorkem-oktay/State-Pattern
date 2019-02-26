package com.zafiru.commands;

import com.zafiru.characters.ICharacter;
import com.zafiru.spells.ISpell;

public class CastSpellCommand implements ICommand {

    private ICharacter character;
    private ISpell spell;

    public CastSpellCommand(ICharacter character, ISpell spell) {
        this.character = character;
        this.spell = spell;
    }

    @Override
    public void execute() {
        character.cast(spell);
    }
}
