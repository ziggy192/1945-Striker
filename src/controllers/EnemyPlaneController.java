package controllers;

import models.Bullet;
import models.EnemyPlane;
import views.EnemyPlaneView;

import java.awt.*;

/**
 * Created by Nghia on 10/10/2016.
 */
public class EnemyPlaneController {
    private static final int SPEED = 3;
    EnemyPlane enemyPlane;
    EnemyPlaneView enemyPlaneView;

    public EnemyPlaneController(EnemyPlane enemyPlane, EnemyPlaneView enemyPlaneView) {
        this.enemyPlane = enemyPlane;
        this.enemyPlaneView = enemyPlaneView;
    }

    public void moveDown() {
        enemyPlane.increaseY(SPEED);
    }

    public void fire() {
        enemyPlane.newBullet();
//        newBullet(x, y + HEIGHT / 2 + Bullet.HEIGHT / 2, -1);
    }

    public void update(Graphics g) {

        enemyPlaneView.drawImage(enemyPlane,g);
        enemyPlaneView.drawBullet(enemyPlane,g);
    }

    public void run(){
        moveDown();
    }
}
