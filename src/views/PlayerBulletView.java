package views;

import controllers.PlayerPlaneController;
import models.PlayerBullet;

import java.awt.*;

/**
 * Created by Nghia on 10/10/2016.
 */
public class PlayerBulletView {
    private Image image;

    public PlayerBulletView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void drawImage(PlayerBullet playerBullet, Graphics g) {
        g.drawImage(image, playerBullet.getX()-(PlayerBullet.WIDTH/2),
                playerBullet.getY()-(PlayerBullet.HEIGHT/2),
                PlayerBullet.WIDTH, PlayerBullet.HEIGHT, null);

    }
}
