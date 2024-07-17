package main;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;

@Getter
public class GameScreen extends JPanel {
    private Game game;
    private Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private Renderer renderer;

    public GameScreen(Game game) {
        this.game = game;
        this.renderer = new Renderer(this);

        setPanelSize();
        setDoubleBuffered(true);

    }

    private void setPanelSize() {
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        renderer.render((Graphics2D) g);
    }

}
