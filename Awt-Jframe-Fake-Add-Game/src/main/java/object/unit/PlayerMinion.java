package object.unit;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static helper.LoadSave.getSubImageFromSpriteSheet;
import static helper.LoadSave.loadFullImage;

public class PlayerMinion extends Unit {

    ArrayList<BufferedImage> spriteObjects = new ArrayList<>();

    public PlayerMinion(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
        //        this.spriteObjects = loadImagesFromFolder("/spritesheets/isometric_hero_bow");


        this.spriteObjects.add(loadFullImage("/art_src/characters/hero/clothes.png"));
        this.spriteObjects.add(loadFullImage("/art_src/characters/hero/male_head1.png"));

        this.spriteObjects.add(loadFullImage("/art_src/characters/hero/shortbow.png"));

        //        this.spriteObjects = loadImagesFromFolder("/art_src/characters/hero");
    }

    @Override
    public void draw(Graphics2D g) {

        super.draw(g);
        drawSprites(g);
    }

    private void drawSprites(Graphics2D g) {
    final AtomicInteger errors = new AtomicInteger();

        spriteObjects.forEach(spriteSheet -> {
            try {
//                System.out.println(currentAnimationCoordinates[animationIndex][0] +  currentAnimationCoordinates[animationIndex][1]);
                final BufferedImage sprite = getSubImageFromSpriteSheet(spriteSheet, currentAnimationCoordinates[animationIndex][0], currentAnimationCoordinates[animationIndex][1], 32);
                g.drawImage(sprite, drawX(), drawY(), width, height, null);
            } catch (final RasterFormatException e) {
                errors.getAndIncrement();
            }
        });
        if (errors.get() > 0) {
            System.out.println("errors in spritesheet = " + errors + " out of " + spriteObjects.size());
        }
    }

}
