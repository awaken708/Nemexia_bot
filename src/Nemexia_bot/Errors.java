package Nemexia_bot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Errors {
    private Capsha capsha = new Capsha();
    private BufferedImage[] img = new BufferedImage[12];

    Errors() {
        try {
            img[0] = ImageIO.read(new File("img/full.bmp"));
            img[1] = ImageIO.read(new File("img/not_possible.bmp"));
            
            img[2] = ImageIO.read(new File("img/mut.bmp"));
            img[3] = ImageIO.read(new File("img/science+.bmp"));
            img[4] = ImageIO.read(new File("img/close.bmp"));
            img[5] = ImageIO.read(new File("img/ok.bmp"));
            
            

        } catch (IOException ex) {
        }
    }


    
    public int work() throws AWTException {
        Finder finder = new Finder();
        int delay = 0;
        capsha.click_capsha();
        for(int i = 0; i < 6; i++){
            Point temp_p = finder.find(img[i], 0, 0, 1365 - img[i].getWidth(), 767 - img[i].getHeight());
            if(temp_p.log){
                if(i == 0){
                    delay = - 2;
                }
                if(i == 1){
                    delay = - 1;
                }
                if(i > 1){
                    click(temp_p);
                }
            }
        }
        //System.out.print(delay);
        return delay;
    }

    public void click(Point p) throws AWTException {
        Robot rob = new Robot();
        rob.mouseMove(p.x, p.y);
        rob.delay(200);
        rob.mousePress(InputEvent.BUTTON1_MASK);
        rob.delay(200);
        rob.mouseRelease(InputEvent.BUTTON1_MASK);
        rob.delay(200);
        rob.mouseMove(0, 0);
        rob.delay(2000);
    }
}
