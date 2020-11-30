package me.juan.repesi.screen.screens.index;

import lombok.Getter;
import lombok.Setter;
import me.juan.repesi.screen.Screen;

import javax.swing.*;

public class Index extends Screen {

    @Getter
    @Setter
    private ScreenIndex screenIndex;

    public Index() {
        screenIndex = new ScreenIndex();
    }


    @Override
    public void enable() {
        if (screenIndex == null) screenIndex = new ScreenIndex();

        screenIndex.get();
    }

    @Override
    public void disable() {
        if (screenIndex == null) return;

        screenIndex.setVisible(false);
        screenIndex = null;
    }

    @Override
    public JFrame getFrame() {
        return screenIndex;
    }
}
