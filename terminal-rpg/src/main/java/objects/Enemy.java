package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Player extends Unit{

    public Player(String name, int maxHp, int attack) {
        super(name, maxHp, attack);
    }

    @Override
    public int attack() {
        return 0;
    }
}
