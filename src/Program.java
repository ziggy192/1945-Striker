import java.io.IOException;

/**
 * Created by Nghia on 10/2/2016.
 */
public class Program {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world");
//        PlayerPlane enemyPlane = new PlayerPlane();
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();

    }
}
