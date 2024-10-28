package constants;

import object.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import static helper.GlobalAccessor.getPlayer;
import static helper.HelperFunctions.getRandomNumberBetween;

public class EffectDictionary {

    private static final ArrayList<Effect> effects = new ArrayList<>();

    static {
        effects.add(new Effect("+1", amount -> getPlayer().setAmount(amount + 1)));
        effects.add(new Effect("+3", amount -> getPlayer().setAmount(amount + 3)));
        effects.add(new Effect("+5", amount -> getPlayer().setAmount(amount + 5)));
        effects.add(new Effect("-5", amount -> getPlayer().setAmount(Math.max(amount - 5, 1))));

        effects.add(new Effect("*2", amount -> getPlayer().setAmount( 2 * amount)));
        effects.add(new Effect("*3", amount -> getPlayer().setAmount( 3 * amount)));

    }

    public static Effect getRandomEffect() {
       final int randomInt = getRandomNumberBetween(0, effects.size() - 1);
       return effects.get(randomInt);
    }

}
