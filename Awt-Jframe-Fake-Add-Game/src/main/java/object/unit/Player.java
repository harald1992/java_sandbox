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
import static helper.FormationHelpers.getFormation;
import static helper.GlobalAccessor.setGlobalPlayer;
import static main.Camera.getCameraY;
import static main.Camera.setCameraPosition;
import static main.PlayingSceneKeyListener.KEYS_PRESSED;

@Getter
@Setter
public class Player extends Unit {
    private int amount = 1;
    private int speed = 3;
    private ArrayList<PlayerMinion> playerMinions = new ArrayList<>();

    ArrayList<BufferedImage> sprites;

    public Player(final int x, final int y) {
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE, new ArrayList<>(), true);
        setGlobalPlayer(this);
        setAmount(amount);
        setCameraPosition(x - (float) (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);
        move(0, -1);
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

        // only draw minions in sight.
        final int offsetToMakeSmoother = 5;
        playerMinions.stream().filter(minion -> minion.getY() > getCameraY() && minion.getY() < getCameraY() + GAME_HEIGHT - offsetToMakeSmoother)
                .forEach(minion -> minion.draw(g));

        drawTextInMiddleOfBox(g, this, String.valueOf(amount));

        super.draw(g);

//        g.setColor(Color.YELLOW);
//        g.drawRect(boxCollider.drawX(), boxCollider.drawY(), (int) boxCollider.getWidth(), (int) boxCollider.getHeight());

    }

    public void setAmount(final int amount, final boolean changeFormation) {
        if (changeFormation) {
            setAmount(amount);
        } else {
            this.amount = amount;
        }
    }

    public void setAmount(final int amount) {
        this.amount = amount;
        final int columns = Math.min(amount, 4);
        final int unitSize = DEFAULT_UNIT_SIZE / 2;

        final var totalWidth = columns * unitSize;
       final float xOffset = - (float) ((columns - 1) * unitSize) / 2;


        System.out.println("xOffset = " + xOffset);
        final List<Point2D.Double> positions =
                getFormation(amount, 4).stream().map(point2D -> new Point2D.Double(x + point2D.getX() * unitSize + xOffset, y + point2D.getY() * unitSize)).toList();

        playerMinions = new ArrayList<>(positions.stream().map(position -> new PlayerMinion((int) position.getX(), (int) position.getY())).toList());

    }

    @Override
    public void move(final float x, final float y) {
        super.move(x, y);
        for (final PlayerMinion playerMinion : playerMinions) {
            playerMinion.move(x, y);
        }
    }

}
