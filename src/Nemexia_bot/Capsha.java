package Nemexia_bot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Capsha {
    ArrayList<Integer> capsha_colors = new ArrayList();
    Capsha(){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("img/capsha.bmp"));
                    } catch (IOException ex) {}
        for(int x = 0; x < img.getWidth(); x++)
            for(int y = 0; y < img.getHeight(); y++){
                int col = img.getRGB(x, y);
                if (capsha_colors.indexOf(col) == -1){
                    capsha_colors.add(col);
                }
            }
    }
    
        public void click_capsha() throws AWTException{
        Robot rob = new Robot();
        rob.delay(1000);
        BufferedImage sc = rob.createScreenCapture(new Rectangle(0, 0, 1366, 768));
        ArrayList<Point> koord = new ArrayList();
        for(int x = 655; x < 745; x++)
            for(int y = 360; y < 400; y++)
                if(capsha_colors.indexOf(sc.getRGB(x, y)) == -1)
                    koord.add(new Point(x,y,true));
        int norm_x = 0; int norm_y = 0;
        //System.out.println(koord.size());
        if(koord.size() < 500){
            for(int i = 0; i < koord.size(); i++){
                norm_x += koord.get(i).x;
                norm_y += koord.get(i).y;
            }
            norm_x = norm_x / koord.size();
            norm_y = norm_y / koord.size();
            rob.mouseMove(norm_x, norm_y);
                rob.delay(200);
                rob.mousePress(InputEvent.BUTTON1_MASK);
                rob.delay(200);
                rob.mouseRelease(InputEvent.BUTTON1_MASK);
                rob.delay(200);
                rob.mouseMove(0, 0);
                rob.delay(5000);
                
        }
        
    }
}
