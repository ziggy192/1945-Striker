package models;

import Utils.utils;
import controllers.PlayerBulletController;
import models.Bullet;
import models.Plane;
import views.PlayerBulletView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/4/2016.
 */
public class PlayerPlane extends Plane {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int MAX_BULLET_NUM = 10;

    ArrayList<PlayerBulletController> bulletControllerArrayList = new ArrayList<>();



//    ArrayList<models.Bullet> bArr = new ArrayList<>();
//    models.Bullet b;

    //location exactly at the middle of the plane


    public PlayerPlane(int x, int y) {
        super(x, y);
    }

    public ArrayList<PlayerBulletController> getBulletControllerArrayList() {
        return bulletControllerArrayList;
    }

    public void newBulletController() {
        PlayerBulletController b = new PlayerBulletController(
                new PlayerBullet(getX(), getY() - Bullet.HEIGHT / 2 - HEIGHT / 2),
                new PlayerBulletView(utils.loadImageFromRes("bullet.png")));
        bulletControllerArrayList.add(b);
    }




    public boolean hasBullet() {
        return true;
    };



}
