package object.unit;

import java.util.ArrayList;
import java.util.List;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static helper.GlobalAccessor.getPlayer;
import static helper.LoadSave.loadFullImage;

public class PlayerMinion extends Unit {

    public PlayerMinion(final int x, final int y) {
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE,
                new ArrayList<>(List.of(
                        loadFullImage("/art_src/characters/hero/clothes.png"),
                        loadFullImage("/art_src/characters/hero/male_head1.png"),
                        loadFullImage("/art_src/characters/hero/shortbow.png"))),
                true);
    }

    public void takeDamage(final int damage) {
        if (!this.markedForDeletion) {
            System.out.println("PlayerMinion took damage");
            getPlayer().setAmount(getPlayer().getAmount() - 1, false);
            this.markedForDeletion = true;
        }

    }

}
