import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 03-Nov-16.
 */
public class Player extends GameObject {
    Handler handler;

    public Player(int x, int y, int id, Handler handler){
        super(x,y,id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }

    private void collision(){
        for( int i=0; i<handler.object.size(); i++ ){
            if( getBounds().intersects(handler.object.get(i).getBounds()) ){
                HUD.HEALTH--;
            }
        }

        for( int i=0; i<handler.bullets.size(); i++ ){
            if( getBounds().intersects(handler.bullets.get(i).getBounds()) ){
                HUD.HEALTH--;
            }
        }
        if(handler.follower!=null) {
            if (getBounds().intersects(handler.follower.getBounds())) {
                HUD.HEALTH -= 2;
            }
        }
        if(handler.boss!=null) {
            if( getBounds().intersects(handler.boss.getBounds()) )
                HUD.HEALTH = 0;
        }
    }

    public void tick(){

        x = velX + x;
        y = velY + y;

        x = Game.clamp(x,0,Game.WIDTH-36);
        y = Game.clamp(y,0,Game.HEIGHT-60);

        collision();
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }
}
