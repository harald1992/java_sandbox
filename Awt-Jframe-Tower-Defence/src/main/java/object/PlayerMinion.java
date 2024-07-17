package object;

import java.awt.*;
import java.awt.image.BufferedImage;

import static helper.LoadSave.loadFullImage;

public class PlayerMinion extends Unit {

    BufferedImage sprite;

    public PlayerMinion(final float x, final float y, final int width, final int height) {
        super(x, y, width, height);

        sprite = loadFullImage("/sprites/survivor-move_handgun_0.png");
//        this.width = height;
//        System.out.println("PlayerMinion size is " + width + " " + height);

    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.drawImage(sprite, drawX(), drawY(), width, height,null);
    }
}
