package me.juan.repesi.screen.screens.index;

import lombok.Getter;
import me.juan.repesi.Main;
import me.juan.repesi.task.CountDownTask;
import me.juan.repesi.task.ProgressTask;

import javax.swing.*;

@Getter
public class ScreenIndex extends JFrame {

    private Thread thread;
    private JPanel Panel;
    private JLabel labelRepesi;
    private JProgressBar Progressbar;


    public ScreenIndex() {
        super("Repesi");
        setContentPane(Panel);
    }

    public void get() {
        setSize(780, 500);
        setVisible(true);
        run();
    }

    private void run() {
        new ProgressTask(30_000, Progressbar) {
            @Override
            public void onFinish() {

            }
        };
        new CountDownTask(30, 4) {
            @Override
            public void onUpdate() {
                labelRepesi.setText(getTimeLeft()+"'s");
            }

            @Override
            public void onFinish() {

            }
        };

    }

}
