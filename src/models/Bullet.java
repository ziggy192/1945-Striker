package models;

import java.awt.*;

/**
 * Created by Nghia on 10/4/2016.
 */
public class Bullet {
    public static final int WIDTH = 17;
    public static final int HEIGHT = 33;
    private static final int SPEED = 10;
    private int x;
    private int y;

    public Bullet() {

    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean exists() {
        if (this == null) return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void increaseY(int dy){
        y+=dy;
    }


//    public void drawImage(Graphics g) {
////        g.d
//        g.drawImage(image, x-(WIDTH/2)*direction, y-(HEIGHT/2)*direction, WIDTH*direction, HEIGHT*direction, null);
////        g.drawImage();
//
//    }


}

