package objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import static constants.AllSpells.getSpellByName;
import static helpers.LevelCalculator.calculateXpForLevel;

@EqualsAndHashCode(callSuper = true)
@Data
public class Player extends Unit {
    private int maxMp;
    private int currentMp;
    private List<Spell> spells = new ArrayList<>();
    private int level = 1;

    public Player(String name, int maxHp, int maxMp, int attack) {
        super(name, maxHp, attack, 0);
        this.maxMp = maxMp;
        this.currentMp = maxMp;

        addSpell(getSpellByName("Attack"));
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void levelUp() {
        System.out.println("Level Up! +1HP and health refreshed!.");
        level ++;
        setMaxHp(getMaxHp() + 1);
        setCurrentHp(getMaxHp());
    }

    public void addExperience(int amount) {
        xp += amount;
        if (xp >= calculateXpForLevel(level + 1)) {
            levelUp();
            addExperience(0);   // to check if more levels will be added
        }
    }

}
