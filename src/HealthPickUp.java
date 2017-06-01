import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 06-Nov-16.
 */
public class HealthPickUp extends GameObject{
    Random r = new Random();
    public HealthPickUp(int x, int y, int id){
        super(x,y,id);
        velX = r.nextInt()%8-4;
        velY = r.nextInt()%8-4;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

    public void tick(){
        if( x<0 || x>Game.WIDTH-18 ) velX *=-1;
        if( y<0 || y>Game.HEIGHT-40 ) velY *=-1;
        x = velX + x;
        y = velY + y;
    }

    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x,y,16,16);
    }

}
