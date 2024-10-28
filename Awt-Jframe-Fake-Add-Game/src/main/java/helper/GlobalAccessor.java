package helper;

import enums.GameState;
import object.GameObject;
import object.unit.Player;
import object.unit.PlayerMinion;
import object.unit.Unit;

import static enums.GameState.setGameState;
import static helper.HelperFunctions.getDistanceBetween;

public class GlobalAccessor {

    private static Player PLAYER;

    public static Player getPlayer() {
        return PLAYER;
    }

    public static PlayerMinion getNearestPlayerMinion(final GameObject unit) {
        return PLAYER.getPlayerMinions()
                .stream()
                .min((minion1, minion2) -> Float.compare(getDistanceBetween(unit, minion1), getDistanceBetween(unit, minion2)))
                .orElseGet(() -> {
                    setGameState(GameState.GAME_OVER);
                   return new PlayerMinion(0, 0); // so there is no nullpointer
                });

    }

    public static void setGlobalPlayer(final Player player) {
        PLAYER = player;
    }
}
