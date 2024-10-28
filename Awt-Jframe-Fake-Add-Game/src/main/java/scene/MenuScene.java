package scene;

import main.Game;

import java.awt.*;

import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;

public class MenuScene extends Scene implements SceneMethods {

    public MenuScene(final Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(final Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Tower Defence", GAME_WIDTH / 2 - 150, GAME_HEIGHT / 2 - 50);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Press Enter to Play", GAME_WIDTH / 2 - 150, GAME_HEIGHT / 2 + 50);
    }
}
