package object.unit;

import enums.AnimationStateEnum;
import lombok.Getter;
import object.GameObject;
import object.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static constants.AnimationDictionary.getAnimationCoordinates;

@Getter
public abstract class Unit extends GameObject {
    protected BufferedImage spriteSheet;

    private int timer = 0;
    protected int animationIndex = 0;
    protected int[][] currentAnimationCoordinates = getAnimationCoordinates(AnimationStateEnum.IDLE_LEFT);
    private AnimationStateEnum currentAnimation = AnimationStateEnum.IDLE_LEFT;

    public Unit(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
    }

    public void update() {
        timer++;
        if (timer > 10) {
            animationIndex++;
            if (animationIndex > currentAnimationCoordinates.length - 1) {
                animationIndex = 0;
            }
            timer = 0;
        }
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

    public void setCurrentAnimationCoordinates(final AnimationStateEnum newAnimation) {
        if (currentAnimation != newAnimation) {
            this.currentAnimationCoordinates = getAnimationCoordinates(newAnimation);
//            System.out.println(Arrays.deepToString(currentAnimationCoordinates));
            this.currentAnimation = newAnimation;
            animationIndex = 0;
        }

    }

    public Vector2D getCenter() {
        return new Vector2D(x + (float) width / 2, y + (float) height / 2);
    }

    public void setAnimationBasedOnDirection(final Vector2D direction) {
        float angle = (float) Math.toDegrees(Math.atan2(-direction.getY(), direction.getX())); // -dy because the y-axis is inverted
        angle = (angle + 360) % 360; // Normalize to 0-360 degrees

        final boolean isMoving = direction.getX() != 0 || direction.getY() != 0;
        AnimationStateEnum state = null;

        if (angle >= 337.5 || angle < 22.5) {
            state = isMoving ? AnimationStateEnum.WALK_RIGHT : AnimationStateEnum.IDLE_RIGHT;
        } else if (angle >= 22.5 && angle < 67.5) {
            state = isMoving ? AnimationStateEnum.WALK_TOP_RIGHT : AnimationStateEnum.IDLE_TOP_RIGHT;
        } else if (angle >= 67.5 && angle < 112.5) {
            state = isMoving ? AnimationStateEnum.WALK_TOP : AnimationStateEnum.IDLE_TOP;
        } else if (angle >= 112.5 && angle < 157.5) {
            state = isMoving ? AnimationStateEnum.WALK_TOP_LEFT : AnimationStateEnum.IDLE_TOP_LEFT;
        } else if (angle >= 157.5 && angle < 202.5) {
            state = isMoving ? AnimationStateEnum.WALK_LEFT : AnimationStateEnum.IDLE_LEFT;
        } else if (angle >= 202.5 && angle < 247.5) {
            state = isMoving ? AnimationStateEnum.WALK_BOTTOM_LEFT : AnimationStateEnum.IDLE_BOTTOM_LEFT;
        } else if (angle >= 247.5 && angle < 292.5) {
            state = isMoving ? AnimationStateEnum.WALK_BOTTOM : AnimationStateEnum.IDLE_BOTTOM;
        } else if (angle >= 292.5 && angle < 337.5) {
            state = isMoving ? AnimationStateEnum.WALK_BOTTOM_RIGHT : AnimationStateEnum.IDLE_BOTTOM_RIGHT;
        }

        if (state != null) {
            setCurrentAnimationCoordinates(state);
        }
    }

}
