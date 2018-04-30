package com.ultrawelfare.sshellcreator;

import java.util.ArrayList;
import java.util.Optional;

public abstract class Command implements ICommand {
    private String cmdName;

    protected final ArrayList<Command> subcommands = new ArrayList<>();

    protected Command(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getCmdName() {
        return cmdName;
    }

    @SuppressWarnings("unused")
    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public void execute(String[] args){
        if(args.length > 1){
            Optional<Command> subCommand = subcommands.stream().filter(cmd -> cmd.getCmdName().equals(args[1])).findFirst();
            if(!subCommand.isPresent()) {
                onExecute(args);
            } else {
                String[] newArgs = new String[args.length - 1];
                System.arraycopy(args, 1, newArgs, 0, args.length - 1);
                subCommand.get().execute(newArgs);
            }
        } else {
            onExecute(args);
        }
    }
}
