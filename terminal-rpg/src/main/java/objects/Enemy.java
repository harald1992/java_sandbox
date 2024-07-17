package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Enemy extends Unit  {

    public Enemy(String name, int maxHp, int attack ) {
        super(name, maxHp, attack, maxHp * attack);
    }

    public Enemy(Enemy enemy) {
        super(enemy.getName(), enemy.getMaxHp(), enemy.getAttack(), enemy.getMaxHp() * enemy.getAttack());
    }

}
