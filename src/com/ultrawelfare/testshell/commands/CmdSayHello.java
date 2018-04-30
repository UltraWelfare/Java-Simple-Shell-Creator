package com.ultrawelfare.testshell.commands;

import com.ultrawelfare.sshellcreator.Command;
import com.ultrawelfare.testshell.data.Config;

public class CmdSayHello extends Command {

    public CmdSayHello(String cmdName) {
        super(cmdName);
    }

    @Override
    public void onExecute(String[] args) {
        System.out.println("Hello " + Config.Username + " :D");
    }
}
