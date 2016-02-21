package Nemexia_bot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class Finder {
    public Point find(BufferedImage img, int x1, int y1, int x2, int y2) throws AWTException {
        Robot rob = new Robot();
        rob.delay(1000);
        BufferedImage sc = rob.createScreenCapture(new Rectangle(0, 0, 1366 , 768));
        int fin_x = 0;
        int fin_y = 0;
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                boolean log = true;
                for (int dx = 0; dx < img.getWidth(); dx++) {
                    if (log) {
                        for (int dy = 0; dy < img.getHeight(); dy++) {
                            if (sc.getRGB(x + dx, y + dy) != img.getRGB(dx, dy)) {
                                log = false;
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (log) {
                    return new Point(x + img.getWidth() / 2, y + img.getHeight() / 2, true);
                }
            }
        }
        return new Point(0, 0, false);
    }


}
