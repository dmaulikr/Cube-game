import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by Victor on 03-Nov-16.
 */
public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    private boolean spawned = false;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private Player player;

    public Game(){
        handler = new Handler();
        Random r = new Random();
        hud = new HUD();
        new Window(WIDTH, HEIGHT, "MyGame", this);

        handler.object.add(new BasicEnemy(r.nextInt(WIDTH-100)+50, r.nextInt(HEIGHT-100)+50, 1, handler));
        player = new Player(100,100,0,handler);
        handler.setPlayer(player);
        hud.setHandler(handler);
        handler.setFollower(new Follower(WIDTH/2,HEIGHT/2,1,handler,player));
        this.addKeyListener(new KeyInput(player));
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double ammountOfTicks = 60.0;
        double ns = 1000000000 /ammountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta>=1){
                tick();
                delta--;
            }
            if(running){
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer >1000){
                timer += 1000;
                hud.setFps(frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        handler.tick();
        hud.tick();

        if(hud.getLevel()>10 && !spawned){
            handler.clearEnemies();
            handler.setBoss(new Boss(handler));
            spawned = true;
        }

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if( bs == null ){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        hud.render(g);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int val, int min, int max){
        if( val>max )
            return max;
        if( val<min )
            return min;
        return val;
    }

    public static void main(String[] args){
        new Game();
    }
}
