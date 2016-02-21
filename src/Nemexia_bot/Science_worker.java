package Nemexia_bot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Science_worker {
    private BufferedImage[] img = new BufferedImage[3];
    Science_worker(){
        try {
            img[0] = ImageIO.read(new File("img/science_awiable.bmp"));
            img[1] = ImageIO.read(new File("img/science2.bmp"));
            img[2] = ImageIO.read(new File("img/science+.bmp")); 
        } catch (IOException ex) {
        }
    }
    
    public void work() throws AWTException{
        Finder finder = new Finder();
        Errors err = new Errors();
        Robot rob = new Robot();
        Point p = finder.find(img[0],0, 0, 1365 - img[0].getWidth(), 767 - img[0].getHeight());
        if(p.log){
            err.click(p);
        for(int i = 0; i < 6; i++){
            rob.mouseMove(100, 100);
            rob.mouseWheel(2);
            p = finder.find(img[2],0, 0, 1365 - img[2].getWidth(), 767 - img[2].getHeight());
            if(p.log)
            err.click(p);
        }
        rob.mouseMove(100, 100);
        for(int i = 0; i < 1000; i++){
        rob.mouseWheel(-1);
        rob.delay(1);
        }
        
        
        p = finder.find(img[1],0, 0, 1365 - img[1].getWidth(), 767 - img[1].getHeight());
        if(p.log)
        err.click(p);
        for(int i = 0; i < 15; i++){
            rob.mouseMove(100, 100);
            rob.mouseWheel(2);
            p = finder.find(img[2],0, 0, 1365 - img[2].getWidth(), 767 - img[2].getHeight());
            if(p.log)
            err.click(p);
        }
        rob.mouseMove(100, 100);
        for(int i = 0; i < 1000; i++){
        rob.mouseWheel(-1);
        rob.delay(1);
        }
        rob.mouseMove(0, 0);
        }
        
    }
}
