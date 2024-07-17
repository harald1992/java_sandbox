package constants;

import objects.Enemy;
import objects.Spell;

import java.util.List;
import java.util.Objects;

public class AllEnemies {

//    public static final Enemy SLIME = new Enemy("Slime", 1, 1);
//    public static final Enemy SLIME = new Enemy("Goblin", 3, 1);
//    public static final Enemy SLIME = new Enemy("Skeleton", 4, 1);
//    public static final Enemy SLIME = new Enemy("Orc", 5, 2);
//    public static final Enemy SLIME = new Enemy("Ogre", 10, 3);
//    public static final Enemy SLIME = new Enemy("Troll", 15, 1);
//

    public static final List<Enemy> ENEMIES = List.of(
            new Enemy("Slime", 1, 1),
            new Enemy("Goblin", 3, 1),
            new Enemy("Skeleton", 4, 1),
            new Enemy("Orc", 5, 2),
            new Enemy("Ogre", 10, 3),
            new Enemy("Troll", 15, 5)
    );

    public static Enemy getEnemyByName(final String name) {
        final Enemy enemy = ENEMIES.stream().filter(s -> Objects.equals(s.getName(), name)).findFirst().orElseThrow();
        return new Enemy(enemy);
    }

    public static Enemy newRandomEnemy() {
        final int randomIndex = (int) Math.floor(Math.random() * ENEMIES.size());
        return new Enemy(ENEMIES.get(randomIndex));
    }

}
