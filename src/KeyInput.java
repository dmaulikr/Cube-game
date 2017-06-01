import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Victor on 04-Nov-16.
 */
public class KeyInput extends KeyAdapter {
    private boolean[] keys = new boolean[4];
    private Player player;

    public KeyInput(Player player){
        this.player = player;
        keys[0] = keys[1] = keys[2] = keys[3] = false;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyChar();
        GameObject temp = player;
        switch (key){
            case 'w': keys[0] = true; temp.setVelY(-5); break;
            case 's': keys[1] = true; temp.setVelY(+5); break;
            case 'a': keys[2] = true; temp.setVelX(-5); break;
            case 'd': keys[3] = true; temp.setVelX(+5); break;
            case KeyEvent.VK_ESCAPE: System.exit(1);
            default: break;
        }
    }

    public void keyReleased(KeyEvent e){
        char key = e.getKeyChar();

        GameObject temp = player;
        switch (key){
            case 'w': keys[0] = false; break;
            case 's': keys[1] = false; break;
            case 'a': keys[2] = false; break;
            case 'd': keys[3] = false; break;
            default: break;
        }

        if( !keys[0] && !keys[1] )
            temp.setVelY(0);

        if( !keys[2] && !keys[3] )
            temp.setVelX(0);

    }
}
