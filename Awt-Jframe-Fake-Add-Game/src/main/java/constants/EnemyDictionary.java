package constants;

import enums.EnemyEnum;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static helper.LoadSave.loadFullImage;

public class EnemyDictionary {

    public static HashMap<EnemyEnum, EnemyStats> enemyDictionary = new HashMap<>();

    static {
        enemyDictionary.put(EnemyEnum.GOBLIN,
                new EnemyStats(DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, getImageListFromUrl("/art_src/characters/goblin/goblin.png"), true, 5 * DEFAULT_UNIT_SIZE));
        enemyDictionary.put(EnemyEnum.MINOTAUR,
                new EnemyStats(DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, getImageListFromUrl("/art_src/characters/minotaur/minotaur.png"), false, DEFAULT_UNIT_SIZE));

    }

    private static ArrayList<BufferedImage> getImageListFromUrl(final String url) {
        return new ArrayList<>(List.of(Objects.requireNonNull(loadFullImage(url))));
    }

    public static EnemyStats getEnemyStats(final EnemyEnum enemyEnum) {
        return enemyDictionary.get(enemyEnum);
    }
}
