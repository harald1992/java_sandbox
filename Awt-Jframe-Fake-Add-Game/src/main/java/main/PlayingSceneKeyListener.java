package main;

import enums.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import static enums.GameState.setGameState;

public class PlayingSceneKeyListener implements KeyListener {
    private final Game game;

    public static HashMap<String, Boolean> KEYS_PRESSED = new HashMap<>();

    public PlayingSceneKeyListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            KEYS_PRESSED.put("LEFT", true);
            break;

        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            KEYS_PRESSED.put("RIGHT", true);
            break;

        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            KEYS_PRESSED.put("UP", true);
            break;

        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            KEYS_PRESSED.put("DOWN", true);
            break;

        case KeyEvent.VK_ESCAPE:
            setGameState(GameState.MENU);
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            KEYS_PRESSED.put("LEFT", false);
            break;

        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            KEYS_PRESSED.put("RIGHT", false);
            break;

        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            KEYS_PRESSED.put("UP", false);

            break;

        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            KEYS_PRESSED.put("DOWN", false);

            break;
        }
    }
}
