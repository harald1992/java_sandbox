package main;

import enums.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static enums.GameState.setGameState;

public class MenuSceneKeyListener implements KeyListener {
   Game game;

    public MenuSceneKeyListener(Game game) {
       this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_ENTER:
            System.out.println("Enter key pressed");
            setGameState(GameState.PLAYING);
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
