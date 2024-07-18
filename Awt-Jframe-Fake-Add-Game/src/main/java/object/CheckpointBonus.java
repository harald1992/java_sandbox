package object;

import lombok.Getter;

import java.awt.*;
import java.util.function.Consumer;

import static helper.DrawHelpers.drawTextInMiddleOfBox;

@Getter
public class CheckpointBonus extends GameObject {
    private final String text;
    private final Consumer<Integer> bonus;

    public CheckpointBonus(final int x, final int y, final int width, final int height, final String text, final Consumer<Integer> bonus) {
        super(x, y, width, height);
        this.text = text;
        this.bonus = bonus;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        // transparency
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.setColor(Color.YELLOW);

        g.fillRect(drawX(), drawY(), width, height);

        // reset alpha
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        drawTextInMiddleOfBox(g, this, text);
        g.setColor(Color.WHITE);
        g.drawRect(drawX(), drawY(), width, height);


    }
}
