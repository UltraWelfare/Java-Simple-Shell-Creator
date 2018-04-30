package com.ultrawelfare.testshell;

import com.ultrawelfare.sshellcreator.BaseShell;
import com.ultrawelfare.testshell.commands.cmdhello.CmdSayHello;
import com.ultrawelfare.testshell.commands.CmdSetUsername;

class App {
    public static void main(String[] args) {
        BaseShell sh = new BaseShell("Test");
        sh.registerCmd(new CmdSayHello("hello"));
        sh.registerCmd(new CmdSetUsername("setusername"));
        sh.openConsole();
    }
}
