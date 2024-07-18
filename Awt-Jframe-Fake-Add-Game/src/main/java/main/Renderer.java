package main;

import enums.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

import static helper.DrawHelpers.drawTextWithShadow;
import static helper.LoadSave.loadFullImage;

public class Renderer {

    private final GameScreen gameScreen;

    public Renderer(final GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        System.setProperty("sun.java2d.d3d", "false");
        System.setProperty("sun.java2d.opengl", "true");

    }

    public void render(Graphics2D g) {
        g.clearRect(0, 0, gameScreen.getWidth(), gameScreen.getHeight());
        g.setColor(Color.BLACK); // Set background color as needed
        g.fillRect(0, 0, gameScreen.getWidth(), gameScreen.getHeight()); // Fill background

        switch (GameState.gameState) {
        case MENU:
            renderMenuScene(g);
            break;
        case PLAYING:
            renderPlayingScene(g);
            break;
        case SETTINGS:
            renderSettingsScene(g);
            break;
        }


        renderFps_Ups(g);

    }



    private void renderFps_Ups(Graphics g) {
        drawTextWithShadow(g, "FPS: " + gameScreen.getGame().getFps(), 8, 32);
        drawTextWithShadow(g, "UPS: " + gameScreen.getGame().getUps(), 8, 64);

    }

    private void renderMenuScene(final Graphics2D g) {
        gameScreen.getGame().getMenuScene().render(g);
    }

    private void renderPlayingScene(Graphics2D g) {
        gameScreen.getGame().getPlayingScene().render(g);
    }

    private void renderSettingsScene(Graphics2D g) {
        gameScreen.getGame().getSettingsScene().render(g);
    }
}
