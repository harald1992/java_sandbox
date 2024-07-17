package constants;

import objects.Spell;

import java.util.List;
import java.util.Objects;

public class AllSpells {

    public static List<Spell> SPELLS = List.of(
            new Spell("Attack", 0, (caster, target) -> target.takeDamage(caster.getAttack())),
            new Spell("Fireball", 3, (caster, target) -> target.takeDamage(3)));


   public static Spell getSpellByName(final String name) {
    return SPELLS.stream().filter(s -> Objects.equals(s.getName(), name)).findFirst().orElseThrow();
    }

}
