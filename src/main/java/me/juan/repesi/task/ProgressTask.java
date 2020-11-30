package me.juan.repesi.task;


import javax.swing.*;

public abstract class ProgressTask extends Thread {

    private final JProgressBar progressBar;
    private final int rate;
    private int speed = 0;

    public ProgressTask(int time, JProgressBar progressBar) {
        this.progressBar = progressBar;
        this.speed = (time*2 / 100);
        this.rate = 1;
        start();
    }

    public ProgressTask(JProgressBar progressBar, int rate) {
        this.progressBar = progressBar;
        this.rate = rate;

        start();
    }


    public ProgressTask(JProgressBar progressBar, int rate, int speed) {
        this.progressBar = progressBar;
        this.rate = rate;
        this.speed = speed;

        start();
    }

    public abstract void onFinish();

    @Override
    public void run() {
        int progress = 0;
        while (progress < 100) {
            progress = progress + rate;
            try {
                if (speed == 0) {
                    if (progress > 100) Thread.sleep(100);
                    else Thread.sleep(100 - progress);
                } else Thread.sleep(speed);

            } catch (InterruptedException ignored) {
            }
            progressBar.setValue(Math.min(progress, 100));
        }
        try {
            Thread.sleep(150);
        } catch (InterruptedException ignored) {
        }
        onFinish();
        stop();
        destroy();
    }
}
