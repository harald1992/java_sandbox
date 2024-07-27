package state;

import enums.ActionStateEnum;
import object.Vector2D;
import object.unit.Enemy;

import static helper.GlobalAccessor.getPlayer;
import static helper.HelperFunctions.getRandomNumberBetween;

public class PatrolState extends State {
    private final Enemy enemy;
    private int timer = 0;
    Vector2D direction;
    Vector2D initialPosition;

    public PatrolState(final Enemy enemy) {
        this.enemy = enemy;
        initialPosition = new Vector2D(enemy.getX(), enemy.getY());
        setNewDirection();
    }

    @Override
    public void start() {
        System.out.println("Entering Patrol State");
    }

    @Override
    public void update() {
        final float distanceToPlayer = enemy.facePlayerAndReturnDistance();

        if (distanceToPlayer < enemy.getChaseRange()) {
            enemy.setState(new ChaseState(enemy));
        }


        if (timer > 0) {
            enemy.move(direction.getXFloat(), direction.getYFloat());
        } else {
            enemy.move(0, 0);
        }

        timer++;
        if (timer > 50) {
            setNewDirection();
            timer = -50; // so it stays idle :)
        }
    }

    @Override
    public void exit() {
        System.out.println("Exiting Patrol State");
    }

    private void setNewDirection() {
        direction = new Vector2D((float) getRandomNumberBetween(-1, 1), (float) getRandomNumberBetween(-1, 1)).normalized();
        if (!enemy.getBoxCollider().contains(initialPosition.getX() + direction.getXFloat(), initialPosition.getY() + direction.getYFloat())) {
            direction = new Vector2D(initialPosition.getX() - enemy.getX(), initialPosition.getY() - enemy.getY()).normalized();
        }
    }
}
