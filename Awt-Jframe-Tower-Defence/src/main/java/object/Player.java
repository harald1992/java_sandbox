package object;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;
import static helper.DrawHelpers.drawTextInMiddleOfBox;
import static helper.GlobalAccessor.setGlobalPlayer;
import static helper.SpreadingHelpers.arrangeUnitsInFormation;
import static main.Camera.setCameraPosition;
import static main.PlayingSceneKeyListener.KEYS_PRESSED;

@Getter
@Setter
public class Player extends Unit {
    private int amount = 1;
    private int speed = 3;
    private ArrayList<PlayerMinion> playerMinions = new ArrayList<>();

    public Player(final float x, final float y, final int width, final int height) {
        super(x, y, width, height);
        setGlobalPlayer(this);
        setAmount(amount);
    }

    @Override
    public void update() {
        float dx = 0, dy = 0;

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

        move(dx, dy);

        setCameraPosition(x - 0.5f * GAME_WIDTH, y - GAME_HEIGHT + 10 * DEFAULT_UNIT_SIZE);
    }

    @Override
    public void draw(Graphics2D g) {
        playerMinions.forEach(minion -> minion.draw(g));
        drawTextInMiddleOfBox(g, new GameObject(x, y, width, Math.min(height, 8 * DEFAULT_UNIT_SIZE)) {
            @Override
            public void update() {}

            @Override
            public void draw(Graphics2D g) {}
        }, String.valueOf(amount));

        g.setColor(Color.YELLOW);
        g.drawRect(drawX(), drawY(), width, height);
    }

    public void setAmount(final int amount) {
        this.amount = amount;
        if (amount < 4) {
            width = amount * DEFAULT_UNIT_SIZE;
            height = DEFAULT_UNIT_SIZE;
        } else {
            width = 4 * DEFAULT_UNIT_SIZE;
            height = ((amount - 1) / 4 + 1) * DEFAULT_UNIT_SIZE;
        }
        final int initialColumns = Math.min(amount, 4);

        final List<Point2D> positions = arrangeUnitsInFormation(new Point2D.Double(x + 0.5 * width, y + 0.5 * height), amount, initialColumns, 0, DEFAULT_UNIT_SIZE);
        playerMinions = new ArrayList<>(
                positions.stream().map(position -> new PlayerMinion((float) position.getX(), (float) position.getY(), DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE)).toList());
    }

    @Override
    public void move(final float x, final float y) {
        super.move(x, y);
        for (final PlayerMinion playerMinion : playerMinions) {
            playerMinion.move(x, y);
        }
    }

}
