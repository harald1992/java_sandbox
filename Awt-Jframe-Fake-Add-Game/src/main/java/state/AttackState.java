package state;

import enums.ActionStateEnum;
import object.unit.Enemy;

import static helper.GlobalAccessor.getNearestPlayerMinion;
import static helper.GlobalAccessor.getPlayer;

public class AttackState extends State {
    private final Enemy enemy;
    private boolean isAttacking = false;

    public AttackState(final Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void start() {
        System.out.println("Entering Attack State");
        enemy.facePlayerAndReturnDistance();
//        enemy.moveToPlayerAndReturnDistance();
    }


    @Override
    public void update() {
        if (!isAttacking) {
           final ActionStateEnum actionStateEnum = enemy.isCanShoot() ? ActionStateEnum.SHOOT : ActionStateEnum.ATTACK;
            enemy.getAnimationAndSpriteManager().setAnimation(actionStateEnum);
            isAttacking = true;
        }
        if (enemy.getAnimationAndSpriteManager().isAnimationCycleComplete()) {
            if (enemy.isCanShoot()) {
                enemy.spawnProjectile();
            } else {
                System.out.println("should give damage");
                getNearestPlayerMinion(enemy).takeDamage(1);
            }
            enemy.setState(new ChaseState(enemy));
        }

    }

    @Override
    public void exit() {
        System.out.println("Exiting Attack State");
    }
}
