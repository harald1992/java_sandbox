package object;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.TILE_SIZE;
import static helper.GlobalAccessor.getPlayer;
import static helper.LoadSave.loadFullImage;

public class Enemy extends Unit {
    private BufferedImage sprite;

    private BufferedImage spriteSheet;

//    private final int xSize = 111;
//    private final int ySize = 65;

    public Enemy(final float x, final float y, final int width, final int height) {
        super(x, y, 666 / 6, 325 / 5);
        sprite = loadFullImage("/sprites/skeleton-idle_0.png");
        spriteSheet = loadFullImage("/spritesheets/skeleton_walk.png");


        System.out.println("Enemy size is " + width + " " + height);

    }

    @Override
    public void update() {
        moveToPlayer();

    }

    private void moveToPlayer() {
        float directionX = getPlayer().getX() - x;
        float directionY = getPlayer().getY() - y;

        final float length = (float) Math.sqrt(directionX * directionX + directionY * directionY);

        if (boxCollider.intersects(getPlayer().getBoxCollider())) {
            System.out.println("Unit died");

            markedForDeletion = true;
        }

        if (length != 0 && length <= 4.0f * TILE_SIZE) { // To avoid division by zero
            directionX /= length;
            directionY /= length;
            final float speed = 1.5f;

            move(directionX * speed, directionY * speed);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        final BufferedImage sprite = getSubImageFromSpriteSheet(0, 0);
        g.drawImage(sprite, drawX(), drawY(), width, height, null);
        super.draw(g);

    }

    private BufferedImage getSubImageFromSpriteSheet(final int xCord, final int yCord) {

        return spriteSheet.getSubimage(xCord * width, yCord * height, width, height);
    }
}
