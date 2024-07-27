package object.unit;

import lombok.Getter;
import object.Vector2D;
import state.PatrolState;
import state.State;

import java.util.ArrayList;
import java.util.List;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.TILE_SIZE;
import static helper.GlobalAccessor.getNearestPlayerMinion;
import static helper.GlobalAccessor.getPlayer;
import static helper.LoadSave.loadFullImage;

@Getter
public class Enemy extends Unit {
    final float speed = 1.0f;
    final float attackRange = 3 * TILE_SIZE;
    final float chaseRange = 8 * TILE_SIZE;
    final boolean canShoot = true;

    private State currentState;

    public Enemy(final int x, final int y) {
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, new ArrayList<>(List.of(loadFullImage("/art_src/characters/goblin/goblin.png"))), false);

        setState(new PatrolState(this));
    }

    public void setState(final State newState) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        currentState.start();
    }

    @Override
    public void update() {
        super.update();
        currentState.update();
    }

    public float facePlayerAndReturnDistance() {
        final float dx = getPlayer().getCenter().getX() - this.getCenter().getX();
        final float dy = getPlayer().getCenter().getY() - this.getCenter().getY();
        final Vector2D direction = new Vector2D(dx, dy).normalized();

        this.faceTowards(direction.getXFloat(), direction.getYFloat());
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public float moveToPlayerAndReturnDistance() {
        final PlayerMinion nearestPlayerMinion = getNearestPlayerMinion(this);
        final float dx = nearestPlayerMinion.getCenter().getX() - this.getCenter().getX();
        final float dy = nearestPlayerMinion.getCenter().getY() - this.getCenter().getY();
        final Vector2D direction = new Vector2D(dx, dy).normalized();

        this.move(direction.getXFloat() * this.getSpeed(), direction.getYFloat() * this.getSpeed());

        return (float) Math.sqrt(dx * dx + dy * dy);
    }

}
