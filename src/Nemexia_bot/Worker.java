package Nemexia_bot;

import java.awt.AWTException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker extends Thread {

    boolean[] flags;
    boolean[] res;
    boolean[] prom;
    boolean[] war;
    private volatile boolean start = false;

    Worker(boolean[] flags, boolean[] res, boolean[] prom, boolean[] war) {
        this.flags = flags;
        this.prom = prom;
        this.res = res;
        this.war = war;
    }
    
    
    public final void stop_t(){
        start = true;
    }
    @Override
    public void run() {
        Resourse_worker res_worker = new Resourse_worker(res);
        Prom_worker prom_worker = new Prom_worker(prom);
        War_worker war_worker = new War_worker(war);
        Science_worker sciense_worker = new Science_worker();
        try {
            while (!start) {
                Random rnd = new Random();
                int temp;
                int r = rnd.nextInt(5);
                if ((r == 1) && (flags[0])) {
                    temp = res_worker.work();
                    if (temp == -2) {
                        r = 4;
                        for (int i = 0; i < rnd.nextInt(5); i++) {
                            Thread.sleep(rnd.nextInt(60000));
                        }

                    }
                    for (int i = 0; i < rnd.nextInt(5); i++) {
                        Thread.sleep(rnd.nextInt(60000));
                    }

                }
                if ((r == 2) && (flags[1])) {
                    temp = prom_worker.work();
                        if (temp == -2) {
                        r = 4;
                        for (int i = 0; i < rnd.nextInt(5); i++) {
                            Thread.sleep(rnd.nextInt(60000));
                        }

                    }
                    for (int i = 0; i < rnd.nextInt(5); i++) {
                        Thread.sleep(rnd.nextInt(60000));
                    }
                }
                if ((r == 3) && (flags[2])) {
                    temp = war_worker.work();
                    if (temp == -2) {
                        r = 4;
                        for (int i = 0; i < rnd.nextInt(5); i++) {
                            Thread.sleep(rnd.nextInt(60000));
                        }

                    }
                    for (int i = 0; i < rnd.nextInt(5); i++) {
                        Thread.sleep(rnd.nextInt(60000));
                    }
                }
                if ((r == 4) && (flags[3])) {
                    sciense_worker.work();
                    for (int i = 0; i < rnd.nextInt(5); i++) {
                        Thread.sleep(rnd.nextInt(60000));
                    }

                }
            }
        } catch (InterruptedException ex) {
        } catch (AWTException ex) {
        }
    }
}
