package models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/8/2016.
 */
public abstract class Plane {



    private int x;
    private int y;



    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy){
        this.x+=dx;
        this.y+=dy;
    }
    public void increaseY(int dy){
        y+=dy;

    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }












}
