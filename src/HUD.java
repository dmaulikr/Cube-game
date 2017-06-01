import java.awt.*;
import java.util.Random;

/**
 * Created by Victor on 04-Nov-16.
 */
public class HUD {

    public static int HEALTH = 127;
    private int G = 255;
    private int R = 0;
    private int score = 0;
    private int level = 1;
    private int fps;
    private Handler handler;
    Random r = new Random();

    public void setFps(int fps) {
        this.fps = fps;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getLevel() {
        return level;
    }

    public void tick(){
        HEALTH = Game.clamp(HEALTH,0,127);
        G = Game.clamp(HEALTH*2-50,0,255);
        R = (127-HEALTH)*2;
        score+=level/2+1;
        if( score>100*level*level ) {
            level++;
            if(level<11)
                handler.object.add(new BasicEnemy(r.nextInt(Game.WIDTH-100)+50, r.nextInt(Game.HEIGHT-100)+50, level, handler));
        }
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(10,10,258,20);
        g.setColor(Color.gray);
        g.fillRect(12,12,254,16);
        g.setColor(new Color(R,G,0));
        g.fillRect(12,12,2*HEALTH,16);

        g.drawString("Score: "+score,10,60);
        g.drawString("Level: "+level,10,80);
        g.drawString("FPS: "+fps,Game.WIDTH-60,20);
    }
}
