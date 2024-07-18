package object;

import lombok.Getter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static main.Camera.getCameraX;
import static main.Camera.getCameraY;

@Getter
public abstract class GameObject {

    protected int x, y;
    protected int width;
    protected int height;
    protected Rectangle2D boxCollider;
    protected boolean markedForDeletion = false;

    public GameObject(final int x, final int y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.boxCollider = new Rectangle2D.Float(x, y, width, height);
    }

    public int drawX() {
       return (int) x - getCameraX();
    }

    public int drawY() {
//        System.out.println(y);
        return (int) y - getCameraY();
    }

    public abstract void update();

    public abstract void draw(Graphics2D g);
}
