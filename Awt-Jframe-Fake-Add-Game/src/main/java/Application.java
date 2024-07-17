import static main.Game.getGameInstance;
import static main.Game.initialize;

public class Application {

    public static void main(String[] args) {
        initialize();

        getGameInstance().start();
    }
}
