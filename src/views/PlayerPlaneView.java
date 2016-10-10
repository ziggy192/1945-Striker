package views;

import controllers.PlayerBulletController;
import models.Bullet;
import models.PlayerBullet;
import models.PlayerPlane;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/10/2016.
 */
public class PlayerPlaneView extends PlaneView{

    public PlayerPlaneView(Image image) {
        super(image);
    }



    public void drawBullet(Graphics g, PlayerPlane playerPlane) {
        ArrayList<PlayerBulletController> playerBulletArrayList = playerPlane.getBulletControllerArrayList();
        ArrayList<PlayerBulletController> removingBulletController = new ArrayList<>();
        for (PlayerBulletController bulletController : playerBulletArrayList) {
            if (bulletController.update(g)==false) {
                removingBulletController.add(bulletController);
            }
        }
        playerBulletArrayList.removeAll(removingBulletController);
    }

    public void drawImage(Graphics g, PlayerPlane playerPlane) {
        g.drawImage(getImage(), playerPlane.getX() - PlayerPlane.WIDTH / 2, playerPlane.getY() - PlayerPlane.HEIGHT / 2, PlayerPlane.WIDTH, PlayerPlane.HEIGHT, null);
    }


}
