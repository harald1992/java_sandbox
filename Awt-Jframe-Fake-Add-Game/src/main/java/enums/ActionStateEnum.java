package enums;

import lombok.Getter;


@Getter
public enum ActionStateEnum {
    IDLE("IDLE"),
    WALK("WALK"),
    ATTACK("ATTACK"),
    SHOOT("SHOOT");

    private final String value;

    ActionStateEnum(final String value) {
        this.value = value;
    }

    public static ActionStateEnum fromString(final String text) {
        for (final ActionStateEnum b : ActionStateEnum.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }

}
