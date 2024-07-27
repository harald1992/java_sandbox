package object.unit;

import java.util.ArrayList;
import java.util.List;

import static helper.LoadSave.loadFullImage;

public class PlayerMinion extends Unit {

    public PlayerMinion(final int x, final int y, final int width, final int height) {
        super(x, y, width, height,
                new ArrayList<>(List.of(
                        loadFullImage("/art_src/characters/hero/clothes.png"),
                        loadFullImage("/art_src/characters/hero/male_head1.png"),
                        loadFullImage("/art_src/characters/hero/shortbow.png"))),
                true);
    }

    public void takeDamage(final int damage) {
       this.markedForDeletion = true;
    }

}
