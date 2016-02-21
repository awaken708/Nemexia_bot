
package Nemexia_bot;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Prom_worker {
    
 private BufferedImage[] img = new BufferedImage[9];
    private boolean[] tupes = new boolean[7];

    Prom_worker(boolean[] tupes) {
        this.tupes = tupes;
        try {
            img[0] = ImageIO.read(new File("img/prom_tupe_1.bmp"));
            img[1] = ImageIO.read(new File("img/prom_tupe_2.bmp"));
            img[2] = ImageIO.read(new File("img/prom_tupe_3.bmp"));
            img[3] = ImageIO.read(new File("img/prom_tupe_4.bmp"));
            img[4] = ImageIO.read(new File("img/prom_tupe_5.bmp"));
            img[5] = ImageIO.read(new File("img/prom_tupe_6.bmp"));
            img[6] = ImageIO.read(new File("img/prom_tupe_7.bmp"));

            
            img[7] = ImageIO.read(new File("img/prom_zone.bmp")); 
            img[8] = ImageIO.read(new File("img/prom_awiable.bmp")); 
        } catch (IOException ex) {
        }
    }

    private ArrayList<Point> find_checked() throws AWTException{
        Finder finder = new Finder();
        ArrayList<Point> PO = new ArrayList();
        for (int i = 0; i < 7; i++) {
            if (tupes[i]) {
                Point temp_p = finder.find(img[i], 0, 0, 1365 - img[i].getWidth(), 767 - img[i].getHeight());
                if (temp_p.log) {
                    PO.add(new Point(temp_p.x, temp_p.y, temp_p.log));
                }
            }
        }
        return PO;
    }

    private void go_res_zone() throws AWTException{
        Finder finder = new Finder();
        Errors err = new Errors();
        err.click(finder.find(img[7], 0, 0, 400, 200));
    }
    
    public int work() throws AWTException{
        Errors err = new Errors();
        int delay = 0;
        delay = err.work();
        go_res_zone();
        ArrayList<Point> PO = find_checked();
        for(int i = 0; i < PO.size(); i++){
            err.click(PO.get(i));
            delay = err.work(); 
            if(delay == - 2)
                break;
        }
       return delay; 
    }
}
