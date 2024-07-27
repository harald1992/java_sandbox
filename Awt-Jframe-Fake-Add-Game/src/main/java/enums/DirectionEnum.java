package enums;

import lombok.Getter;

@Getter
public enum DirectionEnum {
    TOP("TOP"),
    TOP_RIGHT("TOP_RIGHT"),
    RIGHT("RIGHT"),
    BOTTOM_RIGHT("BOTTOM_RIGHT"),
    BOTTOM("BOTTOM"),
    BOTTOM_LEFT("BOTTOM_LEFT"),
    LEFT("LEFT"),
    TOP_LEFT("TOP_LEFT");

    private final String value;

    DirectionEnum(final String value) {
        this.value = value;
    }

    public static DirectionEnum fromString(final String text) {
        for (final DirectionEnum b : DirectionEnum.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
