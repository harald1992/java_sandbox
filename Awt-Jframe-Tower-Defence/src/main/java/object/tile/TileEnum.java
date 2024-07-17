package object.tile;

import lombok.Getter;

@Getter
public enum TileEnum {
    WATER(0),
    WATER_LEFT(4),
    WATER_RIGHT(2),
    ROAD(10);

    private final int value;

    TileEnum(final int value) {
        this.value = value;
    }

    public static TileEnum fromValue(int value) {
        for (TileEnum tile : TileEnum.values()) {
            if (tile.getValue() == value) {
                return tile;
            }
        }
        return null; // Or any default value
    }

}
