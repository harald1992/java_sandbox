package object.unit;

import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static constants.AnimationDictionary.IDLE_TOP;
import static constants.AnimationDictionary.SHOOTING_TOP;
import static constants.AnimationDictionary.SHOOTING_TOP_LEFT;
import static helper.LoadSave.getSubImageFromSpriteSheet;
import static helper.LoadSave.loadImagesFromFolder;

public class PlayerMinion extends Unit {

    //    BufferedImage sprite;

    ArrayList<BufferedImage> spriteObjects;

    private int timer = 0;

    int animationIndex = 0;
    int[][] currentAnimation = IDLE_TOP;

    public PlayerMinion(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
        this.spriteObjects = loadImagesFromFolder("/spritesheets/isometric_hero_bow");
    }

    public void update() {
        timer++;
        if (timer > 10) {
            animationIndex++;
            if (animationIndex > currentAnimation.length - 1) {
                animationIndex = 0;
            }
            timer = 0;
        }

    }


    public void setCurrentAnimation(final int[][] currentAnimation) {
        if (currentAnimation != this.currentAnimation) {
            this.currentAnimation = currentAnimation;
            animationIndex = 0;
        }

    }

    @Override
    public void draw(Graphics2D g) {

        super.draw(g);
        //        g.drawImage(sprite, drawX(), drawY(), width, height,null);
        drawSprites(g);
    }

    private void drawSprites(Graphics2D g) {
        spriteObjects.forEach(
                spriteSheet -> g.drawImage(getSubImageFromSpriteSheet(spriteSheet, currentAnimation[animationIndex][0], currentAnimation[animationIndex][1], 32), drawX(), drawY(),
                        width, height, null));
    }
}
