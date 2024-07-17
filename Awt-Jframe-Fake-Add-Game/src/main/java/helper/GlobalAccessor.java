package helper;

import object.Player;

public class GlobalAccessor {

    private static Player PLAYER;

    public static Player getPlayer() {
        return PLAYER;
    }

    public static void setGlobalPlayer(final Player player) {
            PLAYER = player;
    }
}
