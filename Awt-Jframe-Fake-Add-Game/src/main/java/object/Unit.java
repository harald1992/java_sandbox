package object;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Unit extends GameObject {
    public Unit(final float x, final float y, final int width, final int height) {
        super(x, y, width, height);
    }

    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawRect(drawX(), drawY(), width, height);
    }

    public void move(final float x, final float y) {
        this.x += x;
        this.y += y;
        this.boxCollider.setRect(this.x, this.y, width, height);
    }
}
