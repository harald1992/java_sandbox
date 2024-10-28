package scene.playingScene;

import object.BaseClass;
import object.GameObject;
import object.Projectile;

import java.awt.*;
import java.util.ArrayList;

public class ProjectileManager implements BaseClass {
    ArrayList<Projectile> projectiles = new ArrayList<>();

    private static ProjectileManager instance = new ProjectileManager();

    public ProjectileManager() {
    }

    public static void reset() {
        instance = new ProjectileManager();
    }

    public static ProjectileManager getProjectileManager() {
        return instance;
    }

    @Override
    public void update() {
        if ( projectiles.stream().anyMatch(GameObject::isMarkedForDeletion) ) {
            projectiles = new ArrayList<>(projectiles.stream().filter(e -> !e.isMarkedForDeletion()).toList());
        }
        projectiles.forEach(Projectile::update);

    }

    @Override
    public void draw(Graphics2D g) {
        for (final Projectile projectile : projectiles) {
            projectile.draw(g);
        }
    }

    public void addProjectile(final Projectile projectile) {
        projectiles.add(projectile);
    }
}
