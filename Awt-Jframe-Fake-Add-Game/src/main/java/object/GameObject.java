package object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;

import static main.Camera.getCameraX;
import static main.Camera.getCameraY;
import static main.Game.getGameInstance;

@Getter
@Setter
@ToString
public abstract class GameObject {

    protected float x, y;
    protected int width;
    protected int height;
    protected BoxCollider boxCollider;
    protected boolean markedForDeletion = false;
    private float scaleFactorX;
    private float scaleFactorY;

    public GameObject(final float x, final float y, final int width, final int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scaleFactorX = 1.0f;
        updateBoxCollider();
    }

    public GameObject(final float x, final float y, final int width, final int height, final float scaleFactor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scaleFactorX = scaleFactor;
        this.scaleFactorY = scaleFactor;
        updateBoxCollider();
    }

    public GameObject(final float x, final float y, final int width, final int height, final float scaleFactorX, final float scaleFactorY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
        updateBoxCollider();
    }

    public int drawX() {
        return (int) (x - getCameraX());
    }

    public int drawY() {
        return (int) (y - getCameraY());
    }

    private BoxCollider getSmallerCenteredRectangle(final float scaleFactorX, final float scaleFactorY) {
        final float newWidth = width * scaleFactorX;
        final float newHeight = height * scaleFactorY;
        final float newX = x + (width - newWidth) / 2;
        final float newY = y + (height - newHeight) / 2;
        return new BoxCollider(newX, newY, (int) newWidth, (int) newHeight);
    }

    public void updateBoxCollider() {
        this.boxCollider = getSmallerCenteredRectangle(this.scaleFactorX, this.scaleFactorY);
    }

    public abstract void update();

    public void draw(final Graphics2D g) {
        if (getGameInstance().isDebugMode()) {
            drawBoxCollider(g);
        }
    }

    public Vector2D getCenter() {
        return new Vector2D(x + (float) width / 2, y + (float) height / 2);
    }

    public void drawBoxCollider(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawRect(boxCollider.drawX(), boxCollider.drawY(), (int) boxCollider.getWidth(), (int) boxCollider.getHeight());
    }
}
