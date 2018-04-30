package com.ultrawelfare.testshell.commands;

import com.ultrawelfare.sshellcreator.Command;
import com.ultrawelfare.testshell.data.Config;

public class CmdSetUsername extends Command {


    public CmdSetUsername(String cmdName) {
        super(cmdName);
        
    }

    @Override
    public void onExecute(String[] args) {
        Config.Username = args[1];
    }
}
