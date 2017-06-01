import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 04-Nov-16.
 */
public class Boss extends GameObject{
    Random r = new Random();
    Handler handler;
    int i=0;
    private int timer = 100;

    public Boss(Handler handler){
        super(Game.WIDTH/2-32,-80,1);
        this.handler = handler;
        velX = 0;
        velY = 1;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,64,64);
    }

    public void tick(){

        if( y>25 ){
            velX = 2;
            velY = 0;
            y = 25;
        }

        if( x<0 || x>Game.WIDTH-64 ){

            velX *=-1;
            if (x<10 && velX<11)
                velX++;
        }

        if( y == 25 && r.nextInt(13-Math.abs(velX)) == 1 ) {
            handler.bullets.add(new BossBullets(x, y, i++, handler));
        }

        x = velX + x;
        y = velY + y;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,64,64);
    }
}


