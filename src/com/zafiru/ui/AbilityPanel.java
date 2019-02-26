package com.zafiru.ui;

import com.zafiru.commands.ICommand;
import com.zafiru.commands.NoCommand;

public class AbilityPanel {

    private ICommand[] buttons;

    public AbilityPanel(){
        buttons = new ICommand[10];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new NoCommand();
        }
    }

    public void setCommand(int slot, ICommand command) {
        buttons[slot] = command;
    }

    public void onButtonClick(int slot){
        buttons[slot].execute();
    }
}
