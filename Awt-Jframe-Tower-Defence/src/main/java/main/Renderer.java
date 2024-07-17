package main;

import enums.GameState;

import java.awt.*;

import static helper.DrawHelpers.drawTextWithShadow;

public class Renderer {

    private GameScreen gameScreen;

    public Renderer(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void render(Graphics2D g) {
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
        drawTextWithShadow(g, "FPS: " + gameScreen.getGame().getFps(), 5, 25);
        drawTextWithShadow(g, "UPS: " + gameScreen.getGame().getUps(), 5, 45);

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
