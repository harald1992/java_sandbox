package object.unit;

import enums.AnimationStateEnum;
import lombok.Getter;
import object.GameObject;

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

    public void move(final int x, final int y) {
        this.x += x;
        this.y += y;
        this.boxCollider.setRect(this.x, this.y, width, height);
    }

    public void setCurrentAnimationCoordinates(final AnimationStateEnum newAnimation) {
        System.out.println(newAnimation);
        if (currentAnimation != newAnimation) {
            this.currentAnimationCoordinates = getAnimationCoordinates(newAnimation);
            System.out.println(Arrays.deepToString(currentAnimationCoordinates));
            this.currentAnimation = newAnimation;
            animationIndex = 0;
        }

    }

}
