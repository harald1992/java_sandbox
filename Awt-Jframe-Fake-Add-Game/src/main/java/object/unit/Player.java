package object.unit;

import enums.AnimationStateEnum;
import lombok.Getter;
import lombok.Setter;
import object.GameObject;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static configuration.Configuration.DEFAULT_UNIT_SIZE;
import static configuration.Configuration.GAME_HEIGHT;
import static configuration.Configuration.GAME_WIDTH;

import static helper.DrawHelpers.drawTextInMiddleOfBox;
import static helper.GlobalAccessor.setGlobalPlayer;
import static helper.SpreadingHelpers.arrangeUnitsInFormation;
import static main.Camera.getCameraY;
import static main.Camera.setCameraPosition;
import static main.PlayingSceneKeyListener.KEYS_PRESSED;

@Getter
@Setter
public class Player extends Unit {
    private int amount = 1;
    private int speed = 5;
    private ArrayList<PlayerMinion> playerMinions = new ArrayList<>();

    ArrayList<BufferedImage> sprites;

    public Player(final int x, final int y) {
        super(x, y, DEFAULT_UNIT_SIZE, 2 * DEFAULT_UNIT_SIZE);
        setGlobalPlayer(this);
        setAmount(amount);

        //        this.sprites = loadImagesFromFolder("/spritesheets/isometric_hero_basic");
        //        this.sprites = new ArrayList<>(this.sprites.stream().map(s -> getSubImageFromSpriteSheet(s, 0, 2)).toList());
    }

    @Override
    public void update() {
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

        if (dy < 0) {
            if (dx > 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_TOP_RIGHT));
            } else if (dx < 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_TOP_LEFT));
            } else {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_TOP));
            }
        }
        if (dy > 0) {
            if (dx > 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_BOTTOM_RIGHT));
            } else if (dx < 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_BOTTOM_LEFT));
            } else {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_BOTTOM));
            }
        }

        if (dy == 0) {
            if (dx > 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_RIGHT));
            } else if (dx < 0) {
                playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(AnimationStateEnum.WALK_LEFT));
            }
        }

        move(dx, dy);

        setCameraPosition(x - (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);
        playerMinions.forEach(PlayerMinion::update);
    }

    @Override
    public void draw(Graphics2D g) {
        final int offsetToMakeSmoother = 5;
        playerMinions.stream().filter(minion -> minion.getY() > getCameraY() && minion.getY() < getCameraY() + GAME_HEIGHT - offsetToMakeSmoother)
                .forEach(minion -> minion.draw(g));

//        playerMinions.forEach(minion -> System.out.println(Arrays.deepToString(minion.getCurrentAnimationCoordinates())));

        drawTextInMiddleOfBox(g, new GameObject(x, y - DEFAULT_UNIT_SIZE / 2, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE) {
            @Override
            public void update() {
            }

            @Override
            public void draw(Graphics2D g) {
            }
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
        playerMinions =
                new ArrayList<>(positions.stream().map(position -> new PlayerMinion((int) position.getX(), (int) position.getY(), DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE)).toList());
    }

    @Override
    public void move(final int x, final int y) {
        super.move(x, y);
        for (final PlayerMinion playerMinion : playerMinions) {
            playerMinion.move(x, y);
        }
    }

}
