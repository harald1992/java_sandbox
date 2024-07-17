package helpers;

import static config.GameProperties.gameWidth;

public class PrintHelpers {

    public static void drawMenu(final String title, final String[] options) {
        drawHeader(title);

        for (int i = 0; i < options.length; i++) {
            options[i] = i + 1 + ". " + options[i];
            drawIndent( gameWidth / 4 );

            System.out.println(options[i]);
        }

        drawLine();
        System.out.println();
    }

    public static void drawHeader(String title) {
        drawLine();

        title = "* " + title + " *";
        drawTextInMiddle(title);

        drawLine();
    }

    public static void drawText(String text, int indent) {
        drawIndent(indent);
        System.out.println(text);
    }

    public static void drawTextInMiddle(String text) {
        drawIndent( gameWidth / 2 - text.length() /2 );
        System.out.println(text);
    }

    public static void clearConsole() {
        System.out.flush();
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public static void drawLine() {
        for (int i = 0; i < gameWidth; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }


    public static void drawIndent(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }
}
