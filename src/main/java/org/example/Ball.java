package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball {

    private static String BALL = "https://static.vecteezy.com/system/resources/thumbnails/050/176/674/small_2x/large-golden-ball-isolated-on-transparent-background-png.png";

    private static BufferedImage image = Display.loadImage(BALL);
    private int x;
    private int y;
    public static int width = 50;
    private int height = 50;

    public int getWidth() {
        return width;
    }

    public Ball(int x, int startingYValue) {
        this.x = x;
        this.y = startingYValue;
    }
    public void draw(Graphics g) {
        /*
         * TODO: Replace int literals with variables as needed
         */
        //                 x,           y,  width, height
        g.drawImage(image, this.x, this.y, width, height, null);
    }
}
