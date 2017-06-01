import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Victor on 03-Nov-16.
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    LinkedList<Trail> trails = new LinkedList<Trail>();
    LinkedList<BossBullets> bullets = new LinkedList<BossBullets>();
    Player player;
    Boss boss = null;
    Follower follower = null;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setFollower(Follower follower) {
        this.follower = follower;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public void tick(){
        for(int i=0; i<object.size(); i++){
            object.get(i).tick();
        }
        for(int i=0; i<trails.size(); i++){
            trails.get(i).tick();
        }
        for(int i=0; i<bullets.size(); i++){
            bullets.get(i).tick();
        }
        player.tick();
        if( boss!=null )
            boss.tick();
        if(follower!=null)
            follower.tick();
    }

    public void render(Graphics g){
        for(int i=0; i<object.size(); i++) {
            object.get(i).render(g);
        }
        for(int i=0; i<trails.size(); i++){
            trails.get(i).render(g);
        }
        for(int i=0; i<bullets.size(); i++){
            bullets.get(i).render(g);
        }
        player.render(g);
        if(boss!=null)
            boss.render(g);
        if(follower!=null)
            follower.render(g);
    }

    public void clearEnemies(){

        object.clear();
        follower = null;
        boss = null;
    }

}
