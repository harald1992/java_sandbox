package manager;

import lombok.Getter;
import lombok.Setter;
import object.BaseClass;
import object.unit.Enemy;
import object.GameObject;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class EnemyManager  implements BaseClass {

    private ArrayList<Enemy> enemies;

    private static final EnemyManager instance = new EnemyManager();

    public EnemyManager() {

    }

    public static EnemyManager getEnemyManager() {
        return instance;
    }


    public void update() {
        if ( enemies.stream().anyMatch(GameObject::isMarkedForDeletion) ) {
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
