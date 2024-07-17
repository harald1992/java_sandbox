package constants;

import objects.Unit;

@FunctionalInterface
public interface SpellEffect {
    void apply(Unit caster, Unit target);
}
