package main;

import enums.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static enums.GameState.setGameState;
import static main.Game.getGameInstance;

public class GameOverKeyListener  implements KeyListener {



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:

                setGameState(GameState.MENU);
                getGameInstance().startNewGame();


                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
