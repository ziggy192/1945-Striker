package views;

import controllers.EnemyBulletController;
import controllers.PlayerBulletController;
import models.Bullet;
import models.EnemyPlane;
import models.Plane;
import models.PlayerPlane;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/10/2016.
 */
public class EnemyPlaneView extends PlaneView{
    public EnemyPlaneView(Image image) {
        super(image);
    }

    public void drawImage(EnemyPlane enemyPlane, Graphics g) {
        g.drawImage(getImage(), enemyPlane.getX() - enemyPlane.WIDTH / 2,
                enemyPlane.getY() - enemyPlane.HEIGHT / 2,
                enemyPlane.WIDTH, enemyPlane.HEIGHT, null);
    }

//    public void drawBullet(EnemyPlane enemyPlane, Graphics g) {
//
//    }

    public void drawBullet(EnemyPlane enemyPlane,Graphics g) {
        ArrayList<EnemyBulletController> enemyBulletControllerArrayList = enemyPlane.getBulletControllerArrayList();
        ArrayList<EnemyBulletController> removingBulletController = new ArrayList<>();
        for (EnemyBulletController bulletController : enemyBulletControllerArrayList) {
            if (bulletController.update(g)==false) {
                removingBulletController.add(bulletController);
            }
        }
        enemyBulletControllerArrayList.removeAll(removingBulletController);
    }


}
