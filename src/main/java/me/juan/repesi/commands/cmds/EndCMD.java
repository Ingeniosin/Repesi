package me.juan.repesi.commands.cmds;

import me.juan.repesi.Main;
import me.juan.repesi.commands.Command;

public class EndCMD extends Command {
    public EndCMD() {
        super("end");
    }

    @Override
    public void run(String[] args) {
        log("Good bye.");
        Main.space();
        System.exit(0);
    }
}
