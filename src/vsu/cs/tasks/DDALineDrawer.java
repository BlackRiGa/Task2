package vsu.cs.tasks;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    public void drawLine(PixelDrawer pd, int x1, int y1, int x2, int y2, Color c) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        double D = Math.max(Math.abs(dx), Math.abs(dy));
        double DY = (double) dy / D;
        double DX = (double) dx / D;

        for (int i = 0; i <= D; i++) {
            pd.drawPixel(x1 + (int) (DX * i), y1 + (int) (DY * i), c);
        }
    }
}