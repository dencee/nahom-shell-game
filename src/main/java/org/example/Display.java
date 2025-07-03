package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;

public class Display extends JPanel implements ActionListener, MouseListener {



    JFrame frame;
    Timer timer;
    BufferedImage bgImage;
    private boolean isStarted;
    private int WIDTH = 800;
    private int HEIGHT = 600;
    private Cup cup1 = new Cup(150, 400, "cup1" );
    private Cup cup2 = new Cup(250, 400, "cup 2");
    private Cup cup3 = new Cup(350,400,"cup 3");

    private String IMAGE = "https://t4.ftcdn.net/jpg/01/96/17/93/360_F_196179368_0NcMt9TvP96652D73Zrqwh68yXbYPlLF.jpg";
    private String EFFECT_IMAGE = "https://www.clipartmax.com/png/middle/27-275541_upside-down-plastic-cup.png";
    private String BALL = "https://static.vecteezy.com/system/resources/thumbnails/050/176/674/small_2x/large-golden-ball-isolated-on-transparent-background-png.png";

    public void restCups(){
        cup1 = new Cup(150, 400, "cup1" );
         cup2 = new Cup(250, 400, "cup 2");
         cup3 = new Cup(350,400,"cup 3");

    }

    public void setBallInCup(int cupNum) {
        if (cupNum == 1){
            cup1.setHasBall(true);

        }else if (cupNum == 2){
            cup2.setHasBall(true);

        }else if(cupNum == 3){
            cup3.setHasBall(true);

        }

    }
    Display(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setTitle("shellGame");
        frame.add(this);
        frame.addMouseListener(this);
        frame.pack();
        bgImage = loadImage(IMAGE);

        timer = new Timer(1000 / 60, this);
        timer.start();

//        competitors = new ArrayList<Competitor>();

        repaint();
    }
    public void showFrame(){
        frame.setVisible(true);
    }

    public void startRace(){
        isStarted = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBackground(g);
        drawCups(g);

    }

    void drawBackground(Graphics g){
        g.drawImage(bgImage, 0, 0, WIDTH, HEIGHT, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static BufferedImage loadImage(String imageFileURL) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(URI.create(imageFileURL).toURL());
        } catch (Exception e){
            System.out.println("Unable to find file: " + imageFileURL);
            e.printStackTrace();
        }

        return image;
    }

    public ImageIcon loadLocalImage(String filename) {
        try {
            return new ImageIcon(ImageIO.read(new ShellGame().getClass().getResourceAsStream(filename)));
        } catch (IOException e) {

            return null;
        }
    }
    void drawCups(Graphics g){
        if( cup1 != null && cup2 != null && cup3 != null ) {
            cup1.update();
            cup2.update();
            cup3.update();
            cup1.draw(g);
            cup2.draw(g);
            cup3.draw(g);

        }


        }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cup1.isCupClicked(e.getX(), e.getY());
        cup2.isCupClicked(e.getX(), e.getY());
        cup3.isCupClicked(e.getX(), e.getY());


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


