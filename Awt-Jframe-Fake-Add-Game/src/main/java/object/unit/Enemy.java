package object.unit;

import enums.AnimationStateEnum;
import object.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.TILE_SIZE;

import static constants.AnimationDictionary.getAnimationCoordinates;
import static helper.GlobalAccessor.getPlayer;
import static helper.LoadSave.getSubImageFromSpriteSheet;
import static helper.LoadSave.loadFullImage;

public class Enemy extends Unit {

    public Enemy(final int x, final int y) {
        super(x, y, 3 *  DEFAULT_UNIT_SIZE, 3 * DEFAULT_UNIT_SIZE);
        this.spriteSheet = loadFullImage("/art_src/characters/goblin/goblin.png");
    }

    @Override
    public void update() {
        moveToPlayer();
        super.update();

    }

    private void moveToPlayer() {
        float dX = getPlayer().getX() - x;
        float dY = getPlayer().getY() - y;
        final Vector2D vector2D = new Vector2D(dX, dY);

        final float length = (float) Math.sqrt(dX * dX + dY * dY);

        if (boxCollider.intersects(getPlayer().getBoxCollider())) {
            //            System.out.println("Unit collision");
            //
            //            markedForDeletion = true;
        }

        if (length != 0 && length <= 4.0f * TILE_SIZE) { // To avoid division by zero
            dX /= length;
            dY /= length;
            final float speed = 2;

            move((int) (dX * speed), (int) (dY * speed));

            setAnimationBasedOnDirection(vector2D);

        }
    }

    public void setAnimationBasedOnDirection(final Vector2D direction) {
        float angle = (float) Math.toDegrees(Math.atan2(direction.getY(), direction.getX()));
        angle = (angle + 360) % 360; // Normalize to 0-360 degrees

        if (angle >= 337.5 || angle < 22.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_RIGHT);
        } else if (angle >= 22.5 && angle < 67.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_TOP_RIGHT);
        } else if (angle >= 67.5 && angle < 112.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_TOP);
        } else if (angle >= 112.5 && angle < 157.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_TOP_LEFT);
        } else if (angle >= 157.5 && angle < 202.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_LEFT);
        } else if (angle >= 202.5 && angle < 247.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_BOTTOM_LEFT);
        } else if (angle >= 247.5 && angle < 292.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_BOTTOM);
        } else if (angle >= 292.5 && angle < 337.5) {
            setCurrentAnimationCoordinates(AnimationStateEnum.IDLE_BOTTOM_RIGHT);
        }

    }

    @Override
    public void draw(Graphics2D g) {
        final BufferedImage image = getSubImageFromSpriteSheet(spriteSheet, currentAnimationCoordinates[animationIndex][0], currentAnimationCoordinates[animationIndex][1], 32);
        g.drawImage(image, drawX(), drawY(), width, height, null);
        super.draw(g);

    }
}
