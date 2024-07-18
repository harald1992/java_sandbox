package helper;

import object.unit.Player;

public class GlobalAccessor {

    private static Player PLAYER;

    public static Player getPlayer() {
        return PLAYER;
    }

    public static void setGlobalPlayer(final Player player) {
            PLAYER = player;
    }
}
