import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 07-Nov-16.
 */
public class Follower extends GameObject {
    Handler handler;
    Player player;
    private double length;

    public Follower(int x, int y, int id, Handler handler, Player player){
        super(x,y,id);
        this.handler = handler;
        this.player = player;
        velX = 0;
        velY = 0;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

    public void tick(){
        length = Math.sqrt((player.x+8 - x)*(player.x+8 - x) + (player.y+8 - y)*(player.y+8 - y));
        velX = (int)(3*(player.x+8 - x)/length);
        velY = (int)(3*(player.y+8 - y)/length);

        x = velX + x;
        y = velY + y;
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,y,16,16);

        handler.trails.add(new Trail(x,y, id, Color.blue,16,16,0.08f,handler));
    }
}
