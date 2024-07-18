package helper;

import object.GameObject;

import java.awt.*;

public class DrawHelpers {

    public static void drawTextWithShadow(Graphics g, String text, int x, int y) {
        // Set the font
        g.setFont(new Font("Arial", Font.BOLD, 32));

        // Draw shadow
        g.setColor(Color.DARK_GRAY); // Shadow color
        g.drawString(text, x + 2, y + 2); // Slightly offset position for the shadow

        // Draw actual text
        g.setColor(Color.WHITE); // Actual text color
        g.drawString(text, x, y); // Original text position
    }

    public static void drawTextInMiddleOfBox(Graphics2D g, GameObject ob, String text) {

        final FontMetrics fm = g.getFontMetrics();
        final int textWidth = fm.stringWidth(text);
        final int textX = ob.drawX() + (ob.getWidth() / 2) - (textWidth / 2);
        final int textY = ob.drawY() + (ob.getHeight() / 2) + (fm.getAscent() - fm.getDescent()) / 2;
        drawTextWithShadow(g, text, textX, textY);

    }
}
