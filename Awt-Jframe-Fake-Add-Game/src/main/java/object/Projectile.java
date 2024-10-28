package object;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static helper.GlobalAccessor.getNearestPlayerMinion;
import static helper.LoadSave.getSubImageFromSpriteSheet64;
import static helper.LoadSave.loadFullImage;
import static scene.playingScene.EnemyManager.getEnemyManager;

public class Projectile extends GameObject {
    private final boolean isPlayerTeam;

    Vector2D direction;

    BufferedImage spriteSheet;
    BufferedImage sprite;

    private final int speed = 5;

    public Projectile(final int x, final int y, final Vector2D direction, final boolean isPlayerTeam) {
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, 0.5f);
        this.isPlayerTeam = isPlayerTeam;
        this.direction = direction.normalized();
        spriteSheet = loadFullImage("/art_src/spells/arrows.png");

        assert spriteSheet != null;
        sprite = getSubImageFromSpriteSheet64(spriteSheet, 0, 0, 0);
        final var angle = vectorToRadians(direction);
        final var angleInDegrees = Math.toDegrees(angle);
        sprite = rotate(sprite, angleInDegrees);
    }

    @Override
    public void update() {
        x += direction.getXFloat() * speed;
        y += direction.getYFloat() * speed;
        updateBoxCollider();
//        this.boxCollider.setRect(this.x, this.y, width, height);

        if (isPlayerTeam) {
            getEnemyManager().getEnemies().forEach(enemy -> {
                if (boxCollider.intersects(enemy.getBoxCollider())) {
                                    System.out.println("Projectile collision");
                                    enemy.setMarkedForDeletion(true);

                    markedForDeletion = true;
                }
            });
        } else if (boxCollider.intersects(getNearestPlayerMinion(this).getBoxCollider())) {
            System.out.println("Projectile collision");
            getNearestPlayerMinion(this).takeDamage(1);
            markedForDeletion = true;
        }

    }

    @Override
    public void draw(final Graphics2D g) {
        g.drawImage(sprite, drawX(), drawY(), width, height, null);
        super.draw(g);
    }

    public static double vectorToRadians(final Vector2D vector) {
        return Math.atan2(vector.getYFloat(), vector.getXFloat());
    }

    public static BufferedImage rotate(BufferedImage bimg, double angle) {
        int w = bimg.getWidth();
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w / 2, h / 2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    @Override
    public String toString() {
        return super.toString() + " Projectile{" + "direction=" + direction + '}';
    }
}
