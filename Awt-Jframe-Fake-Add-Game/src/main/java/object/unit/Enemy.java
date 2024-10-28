package object.unit;

import constants.EnemyStats;
import lombok.Getter;
import object.Vector2D;
import state.PatrolState;
import state.State;

import static configuration.Configuration.TILE_SIZE;
import static helper.GlobalAccessor.getNearestPlayerMinion;

@Getter
public class Enemy extends Unit {
    final float speed = 1.0f;
    final float attackRange;
    final float chaseRange = 8 * TILE_SIZE;
    final boolean canShoot;

    private State currentState;

    public Enemy(final EnemyStats enemyStats, final int x, final int y) {
        super(x, y, enemyStats.getWidth(), enemyStats.getHeight(), enemyStats.getSprites(), false);
        this.attackRange = enemyStats.getAttackRange();
        this.canShoot = enemyStats.isShooter();

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
        final PlayerMinion nearestPlayerMinion = getNearestPlayerMinion(this);
        final float dx = nearestPlayerMinion.getCenter().getX() - this.getCenter().getX();
        final float dy = nearestPlayerMinion.getCenter().getY() - this.getCenter().getY();
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
