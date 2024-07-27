package object;

import enums.ActionStateEnum;
import enums.DirectionEnum;
import lombok.Data;
import object.unit.Unit;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static constants.AnimationDictionary.getAnimationCoordinates;
import static helper.LoadSave.getSubImageFromSpriteSheet;
import static helper.MathHelpers.convertAngleToDirection;
import static helper.MathHelpers.convertVector2DToAngleDegrees;

@Data
public class AnimationAndSpriteManager {

    private final Unit unit;
    private ArrayList<BufferedImage> spriteSheets;

    private ActionStateEnum actionState = ActionStateEnum.IDLE;
    private DirectionEnum direction = DirectionEnum.TOP;

    protected int[][] currentAnimationCoordinates = getAnimationCoordinates("IDLE_RIGHT");

    private int timer = 0;
    protected int animationIndex = 0;
    private boolean animationCycleComplete = true;

    public AnimationAndSpriteManager(final Unit unit, final ArrayList<BufferedImage> spriteSheets) {
        this.unit = unit;
        this.spriteSheets = spriteSheets;
    }

    public void update() {
        timer++;
        if (timer > 10) {
            animationIndex++;
            if (animationIndex > currentAnimationCoordinates.length - 1) {
                animationIndex = 0;
                if (actionState == ActionStateEnum.SHOOT) {
                    setAnimation(ActionStateEnum.IDLE);
                    unit.spawnProjectile();
                    animationCycleComplete = true; // Indicate that the animation cycle has completed

                    System.out.println("SHOOTING DONE");
                }
            }
            timer = 0;
        }
    }

    public void draw(final Graphics2D g) {
        final AtomicInteger errors = new AtomicInteger();

        spriteSheets.forEach(spriteSheet -> {
            try {
                final BufferedImage sprite =
                        getSubImageFromSpriteSheet(spriteSheet, currentAnimationCoordinates[animationIndex][0], currentAnimationCoordinates[animationIndex][1], 32);
                g.drawImage(sprite, unit.drawX(), unit.drawY(), unit.width, unit.height, null);
            } catch (final RasterFormatException e) {
                errors.getAndIncrement();
            }
        });
        if (errors.get() > 0) {
            System.out.println("errors in spritesheet = " + errors + " out of " + spriteSheets.size());
        }

        if (unit instanceof object.unit.PlayerMinion) {
            drawDebugInfo(g);
        }

    }

    private void drawDebugInfo(final Graphics2D g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        g.drawString("Player", 16, 100);
        g.drawString("Current ActionState: " + getActionState(), 16, 125);
        g.drawString("Current Direction: " + getDirection(), 16, 150);
        g.drawString("Animation coordinates: " + Arrays.deepToString(getCurrentAnimationCoordinates()), 16, 175);
        g.drawString("animationIndex: " + getAnimationIndex(), 16, 200);
    }



    public void setAnimation(final ActionStateEnum newActionState) {
        if (newActionState != actionState) {
            animationCycleComplete = false;

            actionState = newActionState;
            setNewAnimationCoordinates();
        }
    }

    public void setDirection(final Vector2D direction) {
        final float angleDegrees = convertVector2DToAngleDegrees(direction.normalized());
        setDirection(angleDegrees);
    }

    private void setDirection(final float angleDegrees) {
        final DirectionEnum newDirection = convertAngleToDirection(angleDegrees);
        final float angleRadians = (float) Math.toRadians(angleDegrees);

        final float x = (float) Math.cos(angleRadians);
        final float y = (float) Math.sin(angleRadians);
        unit.setExactDirection(new Vector2D(x, -y));

        if (newDirection != direction) {
            direction = newDirection;
            setNewAnimationCoordinates();
        }
    }

    public void setNewAnimationCoordinates() {
        final String newAnimationString = actionState.toString() + "_" + direction.toString();
        this.currentAnimationCoordinates = getAnimationCoordinates(newAnimationString);
        animationIndex = 0;

    }

}
