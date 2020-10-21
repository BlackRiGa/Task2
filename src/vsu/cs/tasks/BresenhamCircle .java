package vsu.cs.tasks;

import java.awt.*;

class BresenhamCircle {

    public void BresenhamCircle(int center_x, int center_y, int radius, Graphics g){
        int x = 0;
        int  y = radius;
        int sigma = 0;
        int delta = 2 - 2 * radius;
        while (y >= 0){
            g.drawLine(center_x + x, center_y - y, center_x + x,center_y - y);
            g.drawLine(center_x - x, center_y - y, center_x - x, center_y - y);
            g.drawLine(center_x - x, center_y + y, center_x - x, center_y + y);
            g.drawLine(center_x + x, center_y + y, center_x + x, center_y + y);

            sigma = 2* (delta + y) - 1;
            if (delta < 0 && sigma <= 0) {
                x++;
                delta += x + 1;

            } else if (delta > 0 && sigma > 0) {
                y--;
                delta -= y + 1;

            } else {
                x++;
                delta += x - y;
                y--;
            }
        }
    }
}
