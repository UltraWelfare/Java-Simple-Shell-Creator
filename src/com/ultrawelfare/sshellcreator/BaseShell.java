package com.ultrawelfare.sshellcreator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

@SuppressWarnings("unused")
public class BaseShell {
    private String name;
    private final BufferedReader inputStream;
    private final ArrayList<Command> commands = new ArrayList<>();

    public void registerCmd(Command cmd) {
        boolean exists = commands.stream().anyMatch(command -> command.getCmdName().equals(cmd.getCmdName()));
        boolean existsClass = commands.stream().anyMatch(command -> command.getClass() == cmd.getClass());

        if (exists || existsClass) {
            System.err.println("Couldn't register command as it already exists");
            return;
        }
        commands.add(cmd);
    }


    public void openConsole() {
        while (true) {
            System.out.print(name + " >> ");

            String in;
            try {
                in = inputStream.readLine();
                if(in.equals("exit")) { break; }
            } catch (Exception e) {
                continue;
            }

            String[] split = in.split(" ");
            String command0 = split[0];
            Optional<Command> result = commands.stream().filter(command -> command.getCmdName().equals(command0)).findFirst();
            if (!result.isPresent()) {
                System.out.println(ShellStrings.UNKNOWN_COMMAND);
                continue;
            }
            result.get().execute(split);
        }
    }

    public BaseShell(String name) {
        setName(name);

        this.inputStream = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
