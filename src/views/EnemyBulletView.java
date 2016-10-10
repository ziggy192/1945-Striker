package views;

import models.EnemyBullet;
import models.EnemyPlane;

import java.awt.*;

/**
 * Created by Nghia on 10/10/2016.
 */
public class EnemyBulletView {

    Image image;

    public EnemyBulletView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void drawBullet(EnemyBullet enemyBullet, Graphics g) {
        g.drawImage(getImage(), enemyBullet.getX()+(enemyBullet.WIDTH/2),
                    enemyBullet.getY()+(enemyBullet.HEIGHT/2), -enemyBullet.WIDTH, -enemyBullet.HEIGHT, null);

    }
}
