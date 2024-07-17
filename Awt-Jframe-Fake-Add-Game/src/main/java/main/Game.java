package main;

import enums.GameState;
import lombok.AccessLevel;
import lombok.Getter;
import scene.MenuScene;
import scene.PlayingScene;
import scene.SceneMethods;
import scene.SettingsScene;

import javax.swing.*;

import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;
import static enums.GameState.gameState;
import static enums.GameState.setGameState;

@Getter
public class Game extends JFrame implements Runnable {
    private final double FPS_SETTING = 120.0;
    private final double UPS_SETTING = 60.0;   // updates per second

    private int fps;
    private int ups;

    @Getter(AccessLevel.NONE)
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem quitMenuItem;

    private final GameScreen gameScreen;
    private Thread gameThread;

    private MouseListener mouseListener;
    private PlayingSceneKeyListener playingSceneKeyboardListener;
    private MenuSceneKeyListener menuSceneKeyboardListener;

    private SceneMethods menuScene = new MenuScene(this);
    private PlayingScene playingScene = new PlayingScene(this);
    private SceneMethods settingsScene = new SettingsScene(this);

    private static final Game instance = new Game();

    private Game() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // close application when closing window
        setLocationRelativeTo(null); // start window in center
        setResizable(false);
        setTitle("Awt JFrame Tower Defence Game");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        quitMenuItem = new JMenuItem("Quit");
        fileMenu.add(quitMenuItem);
        quitMenuItem.addActionListener(e -> System.exit(0));
        menuBar.add(fileMenu);

        this.setJMenuBar(menuBar);

        gameScreen = new GameScreen(this);
        add(gameScreen);
        pack();

        setVisible(true);
    }

    public static Game getGameInstance() {
        return instance;
    }

    public static void initialize() {
        instance.mouseListener = new MouseListener();
        instance.playingSceneKeyboardListener = new PlayingSceneKeyListener(instance);
        instance.menuSceneKeyboardListener = new MenuSceneKeyListener(instance);
        setGameState(GameState.PLAYING);
        instance.requestFocus(); // make sure focus is on the game JFrame
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double timePerFrame = 1000000000.0 / FPS_SETTING;   // nanoseconds per frame
        final double timePerUpdate = 1000000000.0 / UPS_SETTING;   // nanoseconds per frame

        long now = 0;
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        while (true) {
            // Render
            now = System.nanoTime();

            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            // Update
            if (now - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = now;
                updates++;
            }

            // Print FPS and UPS
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                fps = frames;
                ups = updates;
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }
    }

    private void updateGame() {
        switch (gameState) {
        case MENU:
            menuScene.update();
            break;
        case PLAYING:
            playingScene.update();
            break;
        case SETTINGS:
            settingsScene.update();
            break;
        }
    }

}
