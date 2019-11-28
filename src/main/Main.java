package main;

import gameAssets.GameEngine.Round;
import gameAssets.GameEngine.Score;

public final class Main {

    private Main() {

    }


    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        /**
         * homework logic
         */

        int rounds = gameInput.getRounds();
        while (rounds > 0) {
            Round.getInstance().play(gameInput);
            rounds --;
        }

        Score.getInstance().printScore(gameInput);
    }
}
