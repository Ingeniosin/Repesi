package me.juan.repesi.screen;

import lombok.Getter;
import me.juan.repesi.Main;
import me.juan.repesi.screen.screens.index.Index;

import java.util.HashMap;

public class ScreenManager {

    @Getter
    public HashMap<String, Screen> screenArrayList;

    public ScreenManager() {
        screenArrayList = new HashMap<>();
        screenArrayList.put("index", new Index());
        log("Screen manager loaded correctly.");
    }

    public void log(String msg) {
        Main.log("[screen] " + msg);
    }

    public Screen getIndex() {
        return screenArrayList.get("index");
    }

}
