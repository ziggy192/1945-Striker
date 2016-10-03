import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nghia on 10/2/2016.
 */
public class GameWindow extends Frame {
    Image backgroundImage = null;
    Image playerPlane = null;
    Image playerPlane2 = null;
    private int playerPlaneX = 365;
    private int playerPlaneY = 500;
    private int playerPlane2X = 365;
    private int playerPlane2Y = 400;


    public GameWindow(){
        this.setVisible(true);
        this.setSize(800,600);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                playerPlane2X=e.getXOnScreen()-35;
                playerPlane2Y=e.getYOnScreen()-25;
                repaint();
            }
        });
        this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    System.out.println("Key Typed");
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("Key Pressed");
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_RIGHT:
                            System.out.println("Key Right");
                            playerPlaneX += 10;
                            repaint();
                            break;
                        case KeyEvent.VK_LEFT:
                            System.out.println("Key Left");
                            playerPlaneX -=10;
                            repaint();
                            break;
                        case KeyEvent.VK_UP:
                            System.out.println("Key Up");
                            playerPlaneY -=10;
                            repaint();
                            break;
                        case KeyEvent.VK_DOWN:
                            System.out.println("Key down");
                            playerPlaneY +=10;
                            repaint();
                            break;


                    }
                }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released");
            }
        });
        try {
            backgroundImage=
            ImageIO.read(new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");
            playerPlane = ImageIO.read(new File("resources/plane3.png"));
            playerPlane2 = ImageIO.read(new File("resources/plane2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, 800,600, null);
        g.drawImage(playerPlane,playerPlaneX,playerPlaneY ,null);
        g.drawImage(playerPlane2,playerPlane2X,playerPlane2Y ,null);

        System.out.println("draw background ");
    }
}
