import java.awt.*;

/**
 * Created by Victor on 07-Nov-16.
 */
public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int Width;
    private int Height;
    private float life;

    public Trail(int x, int y, int ID, Color color, int Width, int Height, float life, Handler handler) {
        super(x, y, ID);
        this.handler = handler;
        this.color = color;
        this.Width = Width;
        this.Height = Height;
        this.life = life;
    }

    public void tick() {
        if(alpha>life){
            alpha-=life-0.01f;
        }else
            handler.trails.remove(this);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x,y,Width,Height);

    }


    private AlphaComposite makeTransparent( float alpha ){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }


    @Override
    public Rectangle getBounds() {
        return null;
    }
}
