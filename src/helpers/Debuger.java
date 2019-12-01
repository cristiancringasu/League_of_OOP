package helpers;

import engine.Score;
import main.GameInput;

public final class Debuger {
    private static Debuger instance = null;
    private int round = 0;
    private Debuger() {

    }

    public static Debuger getInstance() {
        if (instance == null) {
            instance = new Debuger();
        }

        return instance;
    }

    public void printPlayers(final GameInput gameInput) {
        System.out.println("Round: " + round);
        Score.getInstance().printScore(gameInput);
        System.out.println("-----------END ROUND--------");
        round++;

    }
}
