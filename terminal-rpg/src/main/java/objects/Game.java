package objects;

import java.util.List;
import java.util.Scanner;

import static constants.AllEnemies.newRandomEnemy;
import static constants.AllSpells.getSpellByName;
import static helpers.LevelCalculator.calculateXpForLevel;
import static helpers.PrintHelpers.clearConsole;
import static helpers.PrintHelpers.drawHeader;
import static helpers.PrintHelpers.drawMenu;
import static helpers.PrintHelpers.drawText;
import static helpers.PrintHelpers.drawTextInMiddle;

public class Game {
    public boolean gameOver = false;

    public Player player;
    public Enemy enemy;

    private boolean isPlayersTurn = true;

    public Game() {
        mainMenu();
    }

    public void mainMenu() {
        clearConsole();
        drawMenu("Main menu", new String[] { "Start Game", "Quit Game" });

        final int selection = readInt(2);
        if (selection == 1) {
            pickClass();
        }
    }

    private void pickClass() {
        clearConsole();
        drawMenu("Choose your class", new String[] { "Warrior", "Wizard" });

        final int selection = readInt(2);
        if (selection == 1) {
            player = new Player("Warrior", 10, 3, 2);
        }
        if (selection == 2) {
            player = new Player("Wizard", 5, 10, 1);
            player.addSpell(getSpellByName("Fireball"));
        }

        startBattle();
    }

    private void startBattle() {
        enemy = newRandomEnemy();

        while (enemy == null || enemy.getXp() > player.getAttack() * player.getMaxHp()) {
            enemy = newRandomEnemy();
        }

        do {
            clearConsole();
            drawEnemy(enemy, 15);
            System.out.println();
            drawPlayer(player, 0);
            System.out.println();

            if (isPlayersTurn) {
                final List<String> spellNames = player.getSpells().stream().map(Spell::getName).toList();

                final String[] actions = spellNames.toArray(new String[0]);

                drawMenu("Choose your action", actions);
                final int selection = readInt(2);
                player.getSpells().get(selection - 1).getEffect().apply(player, enemy);
                checkVictory();
            } else {
                enemy.attack(player);
                checkVictory();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) { }

            isPlayersTurn = !isPlayersTurn;

        } while (!gameOver);

    }

    private void drawEnemy(Unit unit, int indent) {
        drawText(unit.getName(), indent);
        drawText("HP: " + unit.getCurrentHp() + "/" + unit.getMaxHp(), indent);
        drawText("Attack: " + unit.getAttack(), indent);
    }

    private void drawPlayer(Player unit, int indent) {
        indent = 0;

        drawText(unit.getName(), indent);
        drawText("HP: " + unit.getCurrentHp() + "/" + unit.getMaxHp(), indent);
        drawText("MP: " + unit.getCurrentMp() + "/" + unit.getMaxMp(), indent);

        drawText("Attack: " + unit.getAttack(), indent);
        drawText("Level: " + unit.getLevel(), indent);
        drawText("Experience: " + unit.getXp() + " / " + calculateXpForLevel(unit.getLevel() + 1), indent);
    }


    private void checkVictory() {
        if (player.getCurrentHp() <= 0) {
            gameOver = true;
            System.out.println("\nYou lost!");
        } else if (enemy.getCurrentHp() <= 0) {
            player.addExperience(enemy.getXp());
            startBattle();
        }
    }

    private int readInt(int allowedUserChoices) {
        final Scanner scanner = new Scanner(System.in);

        int input;
        do {
            input = scanner.nextInt();
        } while (input < 1 || input > allowedUserChoices);

        return input;
    }


    private void drawSword() {
        System.out.println("  /\\ ");
        System.out.println("  ||");
        System.out.println("  ||");
        System.out.println("  ||");
        System.out.println(",_||_,");
        System.out.println("  ||");
        System.out.println("  /\\ ");
    }

    private void drawStaff() {
        System.out.println("\\.'',/  ");
        System.out.println("= ,. =");
        System.out.println("/ || \\");
        System.out.println("  ||   ");
        System.out.println("  ||   ");
        System.out.println("  ||   ");
        System.out.println("  ||   ");
        System.out.println("  ||   ");
    }
}
