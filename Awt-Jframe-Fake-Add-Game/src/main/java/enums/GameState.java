package enums;

import static main.Game.getGameInstance;

public enum GameState {
    MENU,
    PLAYING,
    GAME_OVER,
    SETTINGS;


    public static GameState gameState = MENU;

    public static void setGameState(final GameState gameState) {
        getGameInstance().removeKeyListener(getGameInstance().getMenuSceneKeyboardListener());
        getGameInstance().removeKeyListener(getGameInstance().getPlayingSceneKeyboardListener());
        getGameInstance().removeKeyListener(getGameInstance().getGameOverSceneKeyboardListener());

        GameState.gameState = gameState;

        switch (gameState) {
            case MENU:
                getGameInstance().addKeyListener(getGameInstance().getMenuSceneKeyboardListener());
                break;
            case PLAYING:
                getGameInstance().addKeyListener(getGameInstance().getPlayingSceneKeyboardListener());
                break;
            case GAME_OVER:
                getGameInstance().addKeyListener(getGameInstance().getGameOverSceneKeyboardListener());
                break;


//            case SETTINGS:
//                game.addKeyListener(game.getSettingsSceneKeyboardListener());
//                break;
        }
    }
}
