package models;

import Utils.utils;
import controllers.EnemyBulletController;
import controllers.PlayerBulletController;
import models.Bullet;
import models.Plane;
import views.EnemyBulletView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/8/2016.
 */
public class EnemyPlane extends Plane {

    public static final int FIRE_RATE = 3;
    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int MAX_BULLET_NUM = 10;
    private static final double MOVE_SPEED = 1;


    ArrayList<EnemyBulletController> bulletControllerArrayList = new ArrayList<>();
    public EnemyPlane(int x, int y) {
        super(x, y);

    }

    public ArrayList<EnemyBulletController> getBulletControllerArrayList() {
        return bulletControllerArrayList;
    }
    public void newBullet(){
        EnemyBulletController b = new EnemyBulletController(
                new EnemyBullet(getX(),getY() + HEIGHT / 2 + Bullet.HEIGHT / 2),
                new EnemyBulletView(utils.loadImageFromRes("bullet.png")));
        bulletControllerArrayList.add(b);
    }
    public boolean hasBullet() {
        return true;
    }


}