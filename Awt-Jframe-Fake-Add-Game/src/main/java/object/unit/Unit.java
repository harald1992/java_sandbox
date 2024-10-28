package object.unit;

import enums.ActionStateEnum;
import lombok.Getter;
import lombok.Setter;
import object.AnimationAndSpriteManager;
import object.GameObject;
import object.Projectile;
import object.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static scene.playingScene.ProjectileManager.getProjectileManager;

@Getter
@Setter
public abstract class Unit extends GameObject {

    private final AnimationAndSpriteManager animationAndSpriteManager;
    private Vector2D exactDirection = new Vector2D(0, 0);
    private final boolean isPlayerTeam;

    public Unit(final int x, final int y, final int width, final int height, final ArrayList<BufferedImage> spriteSheets, final boolean isPlayerTeam) {
        super(x, y, width, height, 0.5f, 1.0f);

        this.isPlayerTeam = isPlayerTeam;
        this.animationAndSpriteManager = new AnimationAndSpriteManager(this, spriteSheets);
    }

    public void update() {
        animationAndSpriteManager.update();
    }

    @Override
    public void draw(final Graphics2D g) {
        animationAndSpriteManager.draw(g);
        super.draw(g);
    }

    public void faceTowards(final float x, final float y) {
        getAnimationAndSpriteManager().setDirection(new Vector2D(x, - y));
    }

    public void move(final float x, final float y) {
        this.x += x;
        this.y += y;
        updateBoxCollider();

        if (x != 0 || y != 0) {
            getAnimationAndSpriteManager().setAnimation(ActionStateEnum.WALK);
            getAnimationAndSpriteManager().setDirection(new Vector2D(x, - y));
        } else {
            getAnimationAndSpriteManager().setAnimation(ActionStateEnum.IDLE);
        }
    }

    public void spawnProjectile() {
        final Projectile projectile = new Projectile((int) x, (int) y, getExactDirection(), isPlayerTeam);
        getProjectileManager().addProjectile(projectile);
    }

}
