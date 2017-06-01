import javax.swing.JFrame;
import java.awt.Canvas;

/**
 * Created by Victor on 03-Nov-16.
 */
public class Window extends Canvas{

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
