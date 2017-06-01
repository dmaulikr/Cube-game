import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;

/**
 * Created by Victor on 03-Nov-16.
 */
public abstract class GameObject {
    protected int x,y;
    protected int id;
    protected int velX, velY;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public GameObject(int x, int y, int ID) {
        this.x = x;
        this.id = id;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
}
