package controllers;

import models.EnemyBullet;
import models.EnemyPlane;
import views.EnemyBulletView;


import java.awt.*;

/**
 * Created by Nghia on 10/10/2016.
 */
public class EnemyBulletController {
    private EnemyBullet enemyBullet;
    private EnemyBulletView enemyBulletView;

    public EnemyBulletController(EnemyBullet enemyBullet, EnemyBulletView enemyBulletView) {
        this.enemyBullet = enemyBullet;
        this.enemyBulletView = enemyBulletView;
    }
    public void fly (){
        enemyBullet.increaseY(EnemyBullet.SPEED);
    }
    public boolean update(Graphics g) {
        fly();
        //hardcode because couldnot access GameWindow
        if (enemyBullet.getY()>  800)
            return false;
        enemyBulletView.drawBullet(enemyBullet,g);
        return true;


    }
}
