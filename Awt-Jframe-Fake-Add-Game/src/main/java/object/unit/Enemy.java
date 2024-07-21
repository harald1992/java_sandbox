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
    final int speed = 5;

    public Enemy(final int x, final int y) {
        super(x, y, 3 * DEFAULT_UNIT_SIZE, 3 * DEFAULT_UNIT_SIZE);
        this.spriteSheet = loadFullImage("/art_src/characters/goblin/goblin.png");
    }

    @Override
    public void update() {
        moveToPlayer();
        super.update();

    }

    private void moveToPlayer() {
        final float dx = getPlayer().getCenter().getX() - getCenter().getX();
        final float dy = getPlayer().getCenter().getY() - getCenter().getY();
        //        final Vector2D vector2D = new Vector2D(dX, dY);

        if (boxCollider.intersects(getPlayer().getBoxCollider())) {
            //            System.out.println("Unit collision");
            //
                        markedForDeletion = true;
        }

        final float length = (float) Math.sqrt(dx * dx + dy * dy);

        if (length != 0 && length <= 5.0f * TILE_SIZE) { // To avoid division by zero
            setAnimationBasedOnDirection(new Vector2D(dx, dy));

            final Vector2D movement = new Vector2D(dx, dy);
            movement.normalize();
//            System.out.println(movement);
            move(movement.getXFloat() * speed, movement.getYFloat() * speed);

        }
    }

    @Override
    public void draw(Graphics2D g) {
        final BufferedImage image = getSubImageFromSpriteSheet(spriteSheet, currentAnimationCoordinates[animationIndex][0], currentAnimationCoordinates[animationIndex][1], 24, 48);
        g.drawImage(image, drawX(), drawY(), width, height, null);
        super.draw(g);

    }
}
