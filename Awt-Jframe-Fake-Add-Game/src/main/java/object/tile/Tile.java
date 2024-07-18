package object.tile;

import lombok.Getter;
import object.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

import static configuration.Configuration.TILE_SIZE;
import static helper.HelperFunctions.getRandomNumberBetween;
import static helper.LoadSave.loadFullImage;

@Getter
public class Tile extends GameObject {

    protected BufferedImage sprite;

    public Tile(final TileEnum tileEnum, final int x, final int y) {
        super(x, y, TILE_SIZE, TILE_SIZE);
        this.sprite = setSprite(tileEnum);
        //        loadFullImage("/sprites/water/water/watrtl21.png");

    }

    public void update() {
    }

    public void draw(Graphics2D g) {

//        g.drawImage(sprite, drawX(), drawY(), null);
        g.drawImage(sprite, drawX(), drawY(), width, height, null);
        //        g.setColor(Color.BLACK);
        //        g.drawRect(drawX(), drawY(), width, height);
    }

    private BufferedImage setSprite(final TileEnum tileEnum) {
        final int randomTileIndex;
        return switch (tileEnum) {
            case TileEnum.WATER -> {
                randomTileIndex = getRandomNumberBetween(21, 33);
                yield loadFullImage("/sprites/water/water/watrtl" + randomTileIndex + ".png");
            }
            case WATER_RIGHT -> {
                randomTileIndex = getRandomNumberBetween(5, 8);
                yield loadFullImage("/sprites/water/water-right/watrtl0" + randomTileIndex + ".png");
            }
            case TileEnum.WATER_LEFT -> {
                randomTileIndex = getRandomNumberBetween(5, 8);
                yield loadFullImage("/sprites/water/water-left/watrtl0" + randomTileIndex + "mirror.png");
            }
            case TileEnum.ROAD -> loadFullImage("/sprites/road/tvlm041.png");
        };

    }

}
