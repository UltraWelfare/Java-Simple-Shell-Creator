package com.ultrawelfare.sshellcreator;

public abstract class Command implements ICommand {
    String cmdName;

    public Command(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }


}
