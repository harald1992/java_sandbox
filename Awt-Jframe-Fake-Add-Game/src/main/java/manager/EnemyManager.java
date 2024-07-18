package manager;

import lombok.Setter;
import object.unit.Enemy;
import object.GameObject;

import java.awt.*;
import java.util.ArrayList;

@Setter
public class EnemyManager {
    private LevelManager levelManager;

    ArrayList<Enemy> enemies;

    public EnemyManager(final LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void update() {
        if ( enemies.stream().anyMatch(GameObject::isMarkedForDeletion) ) {
            System.out.println("regenerating enemies");
            enemies = new ArrayList<>(enemies.stream().filter(e -> !e.isMarkedForDeletion()).toList());
        }
        enemies.forEach(Enemy::update);

    }

    public void draw(Graphics2D g) {
        for (final Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }
}
