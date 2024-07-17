package object;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

import static configuration.Configuration.ROAD_WIDTH;

import static configuration.Configuration.ROAD_X_MIN;
import static constants.EffectDictionary.getRandomEffect;
import static helper.CollisionHelper.calculateOverlapRatio;
import static helper.GlobalAccessor.getPlayer;
import static helper.HelperFunctions.getRandomNumberBetween;

public class CheckpointRow extends GameObject {

    ArrayList<CheckpointBonus> checkpointBonuses = new ArrayList<>();

    public CheckpointRow(final float x, final float y, final int width, final int height) {
        super(x, y, width, height);

        final int amountOfBonuses = getRandomNumberBetween(2, 3);

        for (int i = 0; i < amountOfBonuses; i++) {
            final Effect newEffect = getRandomEffect();
            checkpointBonuses.add(new CheckpointBonus(ROAD_X_MIN + (float) (i * ROAD_WIDTH) / amountOfBonuses, y, ROAD_WIDTH / amountOfBonuses, height, newEffect.text(),
                    newEffect.effect()));
        }
    }

    public void update() {
        if (boxCollider.intersects(getPlayer().getBoxCollider())) {
            System.out.println("Checkpoint reached, determine overlap to know which bonus to get");

            final CheckpointBonus checkpointBonus = checkpointBonuses.stream().max(Comparator.comparingDouble(bonus -> calculateOverlapRatio(getPlayer(), bonus)))
                    .orElse(checkpointBonuses.get(getRandomNumberBetween(0, checkpointBonuses.size() - 1)));
            System.out.println(checkpointBonus.getText());
            checkpointBonus.getBonus().accept(getPlayer().getAmount());

            markedForDeletion = true;
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
