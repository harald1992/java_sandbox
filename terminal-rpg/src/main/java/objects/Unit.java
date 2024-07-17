package objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Unit {

    private String name = "Unit";
    private int maxHp;
    private int currentHp = maxHp;
    private int attack;
    protected int xp = 0;

    public Unit(final String name, final int maxHp, final int attack, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.xp = xp;
    }

    public void attack(final Unit target) {
        target.takeDamage(attack);
    }

    public void takeDamage(int damage) {
        currentHp -= damage;
    }
}
