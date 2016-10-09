import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/4/2016.
 */
public class PlayerPlane extends Plane {
    private static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int MAX_BULLET_NUM = 10;


//    ArrayList<Bullet> bArr = new ArrayList<>();
//    Bullet b;

    //location exactly at the middle of the plane

    private Bullet BulletArr[] = new Bullet[10];


    public PlayerPlane(int x, int y, Image image) {
        super(x, y, image);

    }


    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        System.out.println(String.format("%s,%s", x, y));
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Key Right");
                x += 10;

                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Key Left");
                x -= 10;
                break;
            case KeyEvent.VK_UP:
                System.out.println("Key Up");
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Key down");
                y += 10;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Space");
                fire();
                break;
        }
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println(String.format("%s,%s", e.getX(), e.getY()));
        x = e.getX();
        y = e.getY();

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        if (e.getButton() == MouseEvent.BUTTON1) {
            fire();

        }

    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT, null);
    }

    public void fire() {
        newBullet(x, y - Bullet.HEIGHT / 2 - HEIGHT / 2, 1);
    }

    public boolean hasBullet() {
        if (b == null) return false;
        return true;
    }


}
