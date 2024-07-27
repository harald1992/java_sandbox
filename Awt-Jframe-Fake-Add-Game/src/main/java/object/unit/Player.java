package object.unit;

import enums.ActionStateEnum;
import enums.GameState;
import lombok.Getter;
import lombok.Setter;
import object.GameObject;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;
import static enums.GameState.setGameState;
import static helper.DrawHelpers.drawTextInMiddleOfBox;
import static helper.GlobalAccessor.getNearestPlayerMinion;
import static helper.GlobalAccessor.setGlobalPlayer;
import static helper.SpreadingHelpers.arrangeUnitsInFormation;
import static main.Camera.getCameraY;
import static main.Camera.setCameraPosition;
import static main.Game.getGameInstance;
import static main.PlayingSceneKeyListener.KEYS_PRESSED;

@Getter
@Setter
public class Player extends Unit {
    private int amount = 1;
    private int speed = 5;
    private ArrayList<PlayerMinion> playerMinions = new ArrayList<>();

    ArrayList<BufferedImage> sprites;

    public Player(final int x, final int y) {
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, new ArrayList<>(), true);
        setGlobalPlayer(this);
        setAmount(amount);
        setCameraPosition(x - (float) (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);
    }

    @Override
    public void update() {
        if (playerMinions.stream().anyMatch(GameObject::isMarkedForDeletion)) {
            playerMinions = new ArrayList<>(playerMinions.stream().filter(e -> !e.isMarkedForDeletion()).toList());
        }
        if (playerMinions.isEmpty()) {
            setGameState(GameState.GAME_OVER);
            return;
        }

        if (playerMinions.getFirst().getAnimationAndSpriteManager().getActionState() == ActionStateEnum.SHOOT) {
            playerMinions.forEach(PlayerMinion::update);
            return;
        }

        int dx = 0, dy = 0;

        if (KEYS_PRESSED.getOrDefault("UP", false)) {
            dy -= speed;
        }
        if (KEYS_PRESSED.getOrDefault("DOWN", false)) {
            dy += speed;
        }
        if (KEYS_PRESSED.getOrDefault("LEFT", false)) {
            dx -= speed;
        }
        if (KEYS_PRESSED.getOrDefault("RIGHT", false)) {
            dx += speed;
        }

        if ((dx != 0 || dy != 0)) {
            setCameraPosition(x - (float) (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);
        }

        move(dx, dy);
        playerMinions.forEach(PlayerMinion::update);
    }

    public void shoot() {
        playerMinions.forEach(playerMinion -> playerMinion.getAnimationAndSpriteManager().setAnimation(ActionStateEnum.SHOOT));

    }

    @Override
    public void draw(final Graphics2D g) {
        final int offsetToMakeSmoother = 5;
        playerMinions.stream().filter(minion -> minion.getY() > getCameraY() && minion.getY() < getCameraY() + GAME_HEIGHT - offsetToMakeSmoother)
                .forEach(minion -> minion.draw(g));

        drawTextInMiddleOfBox(g, new GameObject(x, y - (float) DEFAULT_UNIT_SIZE / 2, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE) {
            @Override
            public void update() {
            }

            @Override
            public void draw(final Graphics2D g) {
            }
        }, String.valueOf(amount));

        g.setColor(Color.YELLOW);
        g.drawRect(drawX(), drawY(), width, height);

    }

    public void setAmount(final int amount) {
        final int columns = 4;
        final int rows = Math.max(1, (int) Math.ceil((double) amount / columns));

        this.amount = amount;

        if (amount < columns) {
            width = amount * DEFAULT_UNIT_SIZE;
        } else {
            width = columns * DEFAULT_UNIT_SIZE;
        }
        final int initialColumns = Math.min(amount, columns);
        final float offset = (float) (rows - 1) * DEFAULT_UNIT_SIZE / 2;
        final List<Point2D> positions = arrangeUnitsInFormation(new Point2D.Double(getCenter().getX(), getCenter().getY() + offset), amount, initialColumns, 0, DEFAULT_UNIT_SIZE);
        playerMinions = new ArrayList<>(
                positions.stream().map(position -> new PlayerMinion((int) position.getX(), (int) ((int) position.getY()), DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE)).toList());
    }

    @Override
    public void move(final float x, final float y) {
        super.move(x, y);
        for (final PlayerMinion playerMinion : playerMinions) {
            playerMinion.move(x, y);
        }
    }

}
