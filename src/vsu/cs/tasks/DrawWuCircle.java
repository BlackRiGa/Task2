package vsu.cs.tasks;

import java.awt.*;

class DrawWuCircle {

    public static void drawWuCircle(Graphics g, int _x, int _y, int radius)
    {
        PutPixel(g,  _x + radius, _y, 255);
        PutPixel(g,  _x, _y + radius, 255);
        PutPixel(g,  _x - radius + 1, _y, 255);
        PutPixel(g,  _x, _y - radius + 1, 255);

        float iy = 0;
        for (int x = 0; x <= radius * Math.cos(Math.PI / 4); x++)
        {
            iy = (float)Math.sqrt(radius * radius - x * x);

            PutPixel(g, _x - x, _y + IPart(iy), 255 - (int)(FPart(iy) * 255));
            PutPixel(g,  _x - x, _y + IPart(iy) + 1, (int)(FPart(iy) * 255));

            PutPixel(g,  _x + x, _y + IPart(iy), 255 - (int)(FPart(iy) * 255));
            PutPixel(g,  _x + x, _y + IPart(iy) + 1, (int)(FPart(iy) * 255));

            PutPixel(g,  _x + IPart(iy), _y + x, 255 - (int)(FPart(iy) * 255));
            PutPixel(g,  _x + IPart(iy) + 1, _y + x, (int)(FPart(iy) * 255));

            PutPixel(g,  _x + IPart(iy), _y - x, 255 - (int)(FPart(iy) * 255));
            PutPixel(g,  _x + IPart(iy) + 1, _y - x, (int)(FPart(iy) * 255));

            x++;

            PutPixel(g,  _x + x, _y - IPart(iy), (int)(FPart(iy) * 255));
            PutPixel(g, _x + x, _y - IPart(iy) + 1, 255 - (int)(FPart(iy) * 255));

            PutPixel(g,  _x - x, _y - IPart(iy), (int)(FPart(iy) * 255));
            PutPixel(g,  _x - x, _y - IPart(iy) + 1, 255 - (int)(FPart(iy) * 255));

            PutPixel(g,  _x - IPart(iy), _y - x, (int)(FPart(iy) * 255));
            PutPixel(g,  _x - IPart(iy) + 1, _y - x, 255 - (int)(FPart(iy) * 255));

            PutPixel(g,  _x - IPart(iy), _y + x, (int)(FPart(iy) * 255));
            PutPixel(g, _x - IPart(iy) + 1, _y + x, 255 - (int)(FPart(iy) * 255));

            x--;
        }
    }

    private static int IPart(float x)
    {
        return (int)x;
    }

    private static float FPart(float x)
    {
        while (x >= 0)
            x--;
        x++;
        return x;
    }
    private static void PutPixel(Graphics g, int x, int y, int alpha)
    {
        Color col = new Color(0, 0, 0,alpha );
        g.setColor(col);
        g.fillRect(x, y, 1,1);
    }
}