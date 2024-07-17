package objects;

import constants.SpellEffect;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Spell {
    private final String name;
    private final int cost;

    private final SpellEffect effect;


}
