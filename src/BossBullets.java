import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 04-Nov-16.
 */
public class BossBullets extends GameObject{
    Random r = new Random();
    Handler handler;

    public BossBullets(int x, int y, int id, Handler handler){
        super(x,y,id);
        this.handler = handler;
        velX = r.nextInt(10)-5;
        velY = r.nextInt(2)+2;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

    public void tick(){
        if( y>Game.HEIGHT-40 ) handler.bullets.remove(this);
        x = velX + x;
        y = velY + y;

        handler.trails.add(new Trail(x,y, id, Color.red,16,16,0.1f,handler));
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
    }
}


