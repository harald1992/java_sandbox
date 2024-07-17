package object;

import lombok.Getter;

import java.util.function.Consumer;

public record Effect(String text, Consumer<Integer> effect) {
}
