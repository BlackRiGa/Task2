package vsu.cs.tasks;

import javax.swing.*;
import java.awt.*;

class DrawPanel extends JPanel {

    private Point[] pts = {
            new Point( 50, 260),
            new Point( 250,  400),

    };

    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        PixelDrawer pd = new GraphicsPixelDrawer(gr);

        LineDrawer ld2 = new DDALineDrawer();
        ld2.drawLine(pd, 600, 50, 650, 400, Color.BLACK);

        PixelDrawer1 ld = new BresenhamLineDrawer(20, 52, 300, 400);
        ld.draw((Graphics2D) g);

        PixelDrawer1 ld1=new WULineDrawer(pts[0],pts[1]);
        ld1.draw((Graphics2D) g);

//        BresenhamCircle l1= new BresenhamCircle();
//        l1.BresenhamCircle(150, 400, 110, g);
//
//        DrawWuCircle l3 = new DrawWuCircle();
//        DrawWuCircle.drawWuCircle(g,500,400,110);
//
//        Bresenham_Ellipse ellipse = new Bresenham_Ellipse(550, 150, 200,100,Color.BLACK,Color.BLACK);
//        ellipse.draw((Graphics2D) g);
//
//        Bresenham_Arc arc = new Bresenham_Arc(300, 550, 200,100,Color.BLACK,Color.BLACK);
//        arc.draw((Graphics2D) g);

    }
}
interface LineDrawer {
    void drawLine(PixelDrawer pd, int x1, int y1, int x2, int y2, Color c);
}
interface LineDrawer1 {
    void drawLine1(PixelDrawer pd, int x1, int y1, int x2, int y2, Graphics g);
}
 interface PixelDrawer {
    void drawPixel(int x, int y, Color color);
}
interface PixelDrawer1 {
    void draw(Graphics2D g);
}

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPanel panel = new DrawPanel();
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}




