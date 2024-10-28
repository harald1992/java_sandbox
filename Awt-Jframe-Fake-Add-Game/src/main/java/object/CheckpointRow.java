package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.ROAD_WIDTH;

import static configuration.Configuration.ROAD_X_MIN;
import static constants.EffectDictionary.getRandomEffect;
import static helper.CollisionHelper.calculateOverlapRatio;
import static helper.GlobalAccessor.getNearestPlayerMinion;
import static helper.GlobalAccessor.getPlayer;
import static helper.HelperFunctions.getRandomNumberBetween;

public class CheckpointRow extends GameObject {

    ArrayList<CheckpointBonus> checkpointBonuses = new ArrayList<>();

    public CheckpointRow(final int x, final int y, final int width) {
        super(x, y, width, DEFAULT_UNIT_SIZE, 1.0f);

        final int amountOfBonuses = getRandomNumberBetween(2, 3);

        for (int i = 0; i < amountOfBonuses; i++) {
            final Effect newEffect = getRandomEffect();
            checkpointBonuses.add(new CheckpointBonus(ROAD_X_MIN + (i * ROAD_WIDTH) / amountOfBonuses, y, ROAD_WIDTH / amountOfBonuses, height, newEffect.text(),
                    newEffect.effect()));
        }
    }

    public void update() {
       final var playerMinions = getPlayer().getPlayerMinions();
       final int amount = Math.min(4, playerMinions.size());
        for (int i = 0; i < amount; i++) {
            if (getPlayer().getPlayerMinions().get(i).getBoxCollider().intersects(getBoxCollider())) {

                final CheckpointBonus checkpointBonus = checkpointBonuses.stream().max(Comparator.comparingDouble(bonus -> calculateOverlapRatio(getPlayer(), bonus)))
                        .orElse(checkpointBonuses.get(getRandomNumberBetween(0, checkpointBonuses.size() - 1)));
                checkpointBonus.getBonus().accept(getPlayer().getAmount());

                markedForDeletion = true;
                break;
            }
        }



    }

    public void draw(final Graphics2D g) {

        for (final CheckpointBonus checkpointBonus : checkpointBonuses) {
            checkpointBonus.draw(g);
        }
        g.setColor(Color.BLACK);
        g.drawRect(drawX(), drawY(), width, height);

    }

}
