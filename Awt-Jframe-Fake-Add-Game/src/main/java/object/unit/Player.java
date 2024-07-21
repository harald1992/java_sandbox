package object.unit;

import enums.AnimationStateEnum;
import lombok.Getter;
import lombok.Setter;
import object.GameObject;
import object.Vector2D;

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
        super(x, y, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE);
        setGlobalPlayer(this);
        setAmount(amount);
        setCameraPosition(x - (float) (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);

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

        if (dx != 0 || dy != 0) {
            setAnimationBasedOnDirection(new Vector2D(dx, dy));
            move(dx, dy);
            setCameraPosition(x - (float) (GAME_WIDTH - 4 * DEFAULT_UNIT_SIZE) / 2, y - GAME_HEIGHT + 5 * DEFAULT_UNIT_SIZE);
        }
        playerMinions.forEach(PlayerMinion::update);
    }

    @Override
    public void setCurrentAnimationCoordinates(final AnimationStateEnum newAnimation) {
        playerMinions.forEach(minion -> minion.setCurrentAnimationCoordinates(newAnimation));
        super.setCurrentAnimationCoordinates(newAnimation);
    }

    @Override
    public void draw(Graphics2D g) {
        final int offsetToMakeSmoother = 5;
        playerMinions.stream().filter(minion -> minion.getY() > getCameraY() && minion.getY() < getCameraY() + GAME_HEIGHT - offsetToMakeSmoother)
                .forEach(minion -> minion.draw(g));

        //        playerMinions.forEach(minion -> System.out.println(Arrays.deepToString(minion.getCurrentAnimationCoordinates())));

        drawTextInMiddleOfBox(g, new GameObject(x, y - (float) DEFAULT_UNIT_SIZE / 2, DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE) {
            @Override
            public void update() {
            }

            @Override
            public void draw(Graphics2D g) {
            }
        }, String.valueOf(amount));

        g.setColor(Color.YELLOW);
        g.drawRect(drawX(), drawY(), width, height);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        g.drawString("Player", 16, 100);
        g.drawString("Animation: " + getCurrentAnimation(), 16, 125);
        g.drawString("Animation coordinates: " + Arrays.deepToString(this.currentAnimationCoordinates), 16, 150);
        g.drawString("animationIndex: " + animationIndex, 16, 175);
    }

    public void setAmount(final int amount) {

//       final int columns = Math.min(Math.max(1, amount / 2), 8); // minimum 1 to 8 and mostly amount / 2
        final int columns = 4;

       final int rows = Math.max(1, (int) Math.ceil((double) amount / columns));

        final int unitSize = DEFAULT_UNIT_SIZE;
        height = unitSize;
        System.out.println("columns = " + columns);
        System.out.println("rows = " + rows);
        this.amount = amount;
        if (amount < columns) {
            width = amount * unitSize;
        } else {
            width = columns * unitSize;
        }
        final int initialColumns = Math.min(amount, columns);
        final float offset =  (float) (rows - 1) * unitSize / 2;
        System.out.println("Offset: " + offset / unitSize);
        final List<Point2D> positions = arrangeUnitsInFormation(new Point2D.Double(getCenter().getX(), getCenter().getY() + offset), amount, initialColumns, 0, DEFAULT_UNIT_SIZE);
        playerMinions =
                new ArrayList<>(positions.stream().map(position -> new PlayerMinion((int) position.getX(), (int) ((int)  position.getY()), DEFAULT_UNIT_SIZE, DEFAULT_UNIT_SIZE)).toList());
    }

    @Override
    public void move(final float x, final float y) {
        super.move(x, y);
        for (final PlayerMinion playerMinion : playerMinions) {
            playerMinion.move(x, y);
        }
    }

}
