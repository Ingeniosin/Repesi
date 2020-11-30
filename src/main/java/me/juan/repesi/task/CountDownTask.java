package me.juan.repesi.task;


import lombok.Getter;
import me.juan.repesi.utils.TimeUtil;

public abstract class CountDownTask implements Runnable {


    private int time, type;
    @Getter
    private Long remaining;

    public abstract void onUpdate();

    public abstract void onFinish();


    public CountDownTask(int time, int type) {
        this.time = time;
        this.type = type;
        this.remaining = Long.parseLong(String.valueOf(time*1000));
        run();
    }


    public String getTimeLeft() {
        if (this.getRemaining() >= 60_000) {
            return TimeUtil.millisToRoundedTime(this.getRemaining());
        } else {
            return TimeUtil.millisToSeconds(this.getRemaining());
        }
    }

    @Override
    public void run() {
        while (remaining > 0){
            int update = 0;
            switch (type){
                case 1:
                    update = 1000;
                    break;
                case 2:
                    update = 100;
                    break;
                case 3:
                    update = 10;
                    break;
                case 4:
                    update = 1;
                    break;
            }
            try { Thread.sleep(update);} catch (InterruptedException ignored) {  }
            remaining = remaining-update;
            onUpdate();
        }
        onFinish();
    }
}
