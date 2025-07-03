package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Cup {

    private final Ball ball;
    private BufferedImage image;

    /*
     * TODO: Add some variables to keep track of the
     *  competitor's position
     */
    private int x;
    private int y;
    private int cupWidth = 100;
    private int cupHeight = 100;
    private String name;
    private String IMAGE = "https://www.clipartmax.com/png/full/27-275541_upside-down-plastic-cup.png";


    public Cup(int x, int startingYValue, String name) {
        image = Display.loadImage(IMAGE);
        this.x = x;
        this.y = startingYValue;
        this.name = name;
        int ballX = (cupWidth - Ball.width) / 2;
        this.ball = new Ball(x + ballX, y);
    }

    private boolean hasBall;

    public void setHasBall(boolean hasBall) {
        this.hasBall = hasBall;
    }

    public boolean isHasBall() {
        return hasBall;
    }

    public boolean cupClicked;


    public boolean isCupClicked(int mouseX, int mouseY) {

        if (mouseX >= x && mouseX <= x + cupWidth && mouseY >= y && mouseY <= y + cupHeight) {

            if (cupClicked == false) {
                this.y -= 100;
                cupClicked = true;
            }else {
                this.y += 100;
                cupClicked = false;
            }

            return true;
        }

        return false;
    }

    public void update() {
        /*
         * TODO: Move the competitor some distance each game frame
         *  - for random distance: new Random().nextInt(10);
         */
//        this.x = this.x + new Random().nextInt(10);
    }

    public void draw(Graphics g) {
        /*
         * TODO: Replace int literals with variables as needed
         */
        //                 x,           y,  width, height


        if (isHasBall()){
            ball.draw(g);

        }
        g.drawImage(image, this.x, this.y, cupWidth, cupHeight, null);
    }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }
}
