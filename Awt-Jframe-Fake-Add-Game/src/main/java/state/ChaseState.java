package state;

import object.Vector2D;
import object.unit.Enemy;

import static helper.GlobalAccessor.getPlayer;

public class ChaseState extends State {
    private final Enemy enemy;

    public ChaseState(final Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void start() {
        System.out.println("Entering Chase State");
    }

    @Override
    public void update() {
        final float distanceToPlayer = enemy.moveToPlayerAndReturnDistance();

        if (distanceToPlayer < enemy.getAttackRange()) {
            enemy.setState(new AttackState(enemy));
        } else if (distanceToPlayer >= enemy.getChaseRange()) {
            enemy.setState(new PatrolState(enemy));
        }
    }

    @Override
    public void exit() {
        System.out.println("Exiting Chase State");
    }
}
