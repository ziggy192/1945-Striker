import java.awt.*;

/**
 * Created by Nghia on 10/4/2016.
 */
public class Bullet {
    public static final int WIDTH = 17;
    public static final int HEIGHT = 33;
    private int x;
    private int y;
    private Image image;

    private static final int SPEED = 5;

    public Bullet() {

    }

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    public boolean exists(){
        if (this==null) return false;
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
    public void fly(){
        y-=SPEED;
    }

    public void drawImage(Graphics g){
        g.drawImage(image,x,y,WIDTH,HEIGHT,null);

    }




}

