import java.awt.*;

/**
 * Created by Nghia on 10/4/2016.
 */
public class Bullet {
    public static final int WIDTH = 17;
    public static final int HEIGHT = 33;
    private static final int SPEED = 5;
    private int x;
    private Image image;
    private int y;
    private int direction;


    public Bullet() {

    }

    public Bullet(int x, int y, Image image, int direction) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.direction=direction;
    }

    public boolean exists() {
        if (this == null) return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void fly() {
        y -= SPEED*direction;
    }


    public void drawImage(Graphics g) {
//        g.d
        g.drawImage(image, x-(WIDTH/2)*direction, y-(HEIGHT/2)*direction, WIDTH*direction, HEIGHT*direction, null);
//        g.drawImage();

    }


}

