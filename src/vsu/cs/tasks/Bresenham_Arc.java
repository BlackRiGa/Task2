package vsu.cs.tasks;

import java.awt.*;

public class Bresenham_Arc implements PixelDrawer1 {
    private int x0;
    private int y0;
    private int lSA;
    private int SSA;
    private Color lAC;
    private Color SAC;

    public Bresenham_Arc(int x0, int y0, int lSA, int SSA, Color SAC, Color lAC) {
        this.x0 = x0;
        this.y0 = y0;
        this.lSA = lSA;
        this.SSA = SSA;
        this.lAC = lAC;
        this.SAC = SAC;
    }

    void putpixel(int x, int y, Graphics2D g, Color color)
    {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }

    void pixel(int x, int y, int _x, int _y, Graphics2D g, Color color)
    {
        putpixel(x + _x, y + _y, g, color);
        putpixel(x - _x, y + _y, g, color);
    }

    private void draw_Ellipse(int x, int y, int lSA, int SSA, Graphics2D g) {
        int _x = 0,_y = SSA, a_sqr = lSA * lSA, b_sqr = SSA * SSA;
        int delta = 4 * b_sqr * ((_x + 1) * (_x + 1)) + a_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * a_sqr * b_sqr;
        while (a_sqr * (2 * _y - 1) > 2 * b_sqr * (_x + 1))
        {
            pixel(x, y, _x, _y, g, lAC);
            _x++;
            if (delta < 0)
            {
                delta += 4 * b_sqr * (2 * _x + 3);
            } else
            {
                delta = delta - 8 * a_sqr * (_y - 1) + 4 * b_sqr * (2 * _x + 3);
                _y--;
            }
        }
        delta = b_sqr * ((2 * _x + 1) * (2 * _x + 1)) + 4 * a_sqr * ((_y + 1) * (_y + 1)) - 4 * a_sqr * b_sqr;

        while (_y + 1 != 0)
        {
            pixel(x, y, _x, _y, g, SAC);
            _y--;
            if (delta < 0)
            {
                delta += 4 * a_sqr * (2 * _y + 3);
            } else
            {
                delta = delta - 8 * b_sqr * (_x + 1) + 4 * a_sqr * (2 * _y + 3);
                _x++;
            }
        }
    }


    public void draw(Graphics2D g) {
        draw_Ellipse(x0, y0, lSA, SSA, g);
    }
}